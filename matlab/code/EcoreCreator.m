classdef EcoreCreator < handle
    % From Matlab --> ecore
    properties(Access=private)
        sourceFilePath;
        modelManager;
        javaEcoreCreator;        
    end
    methods (Static)
        % do not use the whole path name. CD first!
        function EC=fromFile( path2mdlFile )
            EC=EcoreCreator();
            EcoreCreator.checkMDLFileReadable( path2mdlFile );            
            EC.sourceFilePath = path2mdlFile;
        end
                
    end
    methods (Static, Access=private)
        function checkMDLFileReadable( mdlPath )
            if (~EcoreCreator.isMDLFileReadable( mdlPath ))
                errRecord = MException('EcoreCreator:MDLnotReadable', ...
                    'MDL file is not readable: %s', mdlPath);
                throw(errRecord);
            end
        end
        
        function boolean = isMDLFileReadable( path2mdlFile )
            boolean = (exist(path2mdlFile,'file') == 4);
        end        
    end
    methods
        function doIt(self)
            self.initEcoreCreationClasses();
            self.openModelInSimulink();
            modelName = self.getModelName();
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
            self.addLines(systemName);
        end
        
        function addLines( self, aSystem )
            lines = find_system('toppy','FindAll','on','type','line');
            for x=1:size(lines,1)
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
                    
        function openModelInSimulink( self )
            load_system( self.sourceFilePath );
        end
        
        function name=getModelName( self )
            name = bdroot();
        end
        
        
    end
end
