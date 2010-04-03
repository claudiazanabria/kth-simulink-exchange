classdef EcoreCreator < handle
    % From Matlab --> ecore
    properties(Access=private)
        sourceFilePath;
        modelManager;
        javaEcoreCreator;        
    end
    methods (Static)
        function EC=fromFile( path2mdlFile ) 
            Utils.checkMDLFileReadable( path2mdlFile );
            EC=EcoreCreator();
            EC.sourceFilePath = path2mdlFile;
            EC.doIt();
        end
                
    end
    methods
        function doIt(self)
            self.initEcoreCreationClasses();
            modelName = self.openModelInSimulink();
            self.javaEcoreCreator.newModel( modelName );
            rootSystem = self.javaEcoreCreator.addRootSystem( modelName );
            self.processSystem( modelName, rootSystem );
            self.saveIt();
        end
        
    end
    methods (Access=private)
        
        function processSystem( self, systemName, parentSystem)
            [refMdls, mdlBlks] = find_mdlrefs(systemName, false);
            for x=1:size(refMdls,1)-1
                name = char(refMdls(x));
                instanceName = char(mdlBlks(x));
                aNewSystem = self.javaEcoreCreator.addSystem(name,...
                    parentSystem,instanceName);
                load_system( name );
                self.addOutportsTo( aNewSystem );
                self.addInportsTo( aNewSystem );
                self.processSystem(name, aNewSystem);
            end
            self.addLines( mdlBlks, parentSystem );
        end
        
        function addLines( self, mdlBlks, parentSystem )
            lineBuilder = LineBuilder( parentSystem );
            for x=1:size(mdlBlks,1)
                ep = ExtendedPortConnectivity.fromBlockName(mdlBlks{x});
                linesInfo = lineBuilder.process( ep );
                self.javaEcoreCreator.addLines( linesInfo );
            end
        end
                
        function addOutportsTo( self, aSystem )
            name = char(aSystem.getName());
            ports = find_system(name,'SearchDepth',1,'BlockType','Outport');
            for x=1:size(ports,1)
                portName = char(ports(x));
                self.javaEcoreCreator.addOutPort(portName, aSystem);
            end
        end

        function addInportsTo( self, aSystem )
            name = char(aSystem.getName());
            ports = find_system(name,'SearchDepth',1,...
                'BlockType','Inport');
            for x=1:size(ports,1)
                portName = char(ports(x));
                self.javaEcoreCreator.addInPort(portName, aSystem);
            end
        end

        function saveIt( self )
            topElement = self.javaEcoreCreator.getTopElement();
            self.modelManager.setTopElement( topElement );
            self.modelManager.validateIt();
            destFileName = fullfile(cd(), self.sourceFilePath);
            self.modelManager.saveAsWithPropperExtension(destFileName);
        end
        
        function initEcoreCreationClasses(self)
            self.modelManager = modelManagement.simulink.SimulinkModelManager();
            factory = self.modelManager.getFactory();
            self.javaEcoreCreator = modelManagement.simulink.SimulinkEcoreCreator( factory );
        end
                    
        function sysName = openModelInSimulink( self )
            fullPath = which( self.sourceFilePath );
            load_system( fullPath );
            sysName = char( find_system('Filename', fullPath));
        end                
        
    end
end
