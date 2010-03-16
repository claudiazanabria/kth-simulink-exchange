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
            rootSystem = self.javaEcoreCreator.addRootSystem('modelName');
            self.processSystem( modelName, rootSystem );
            self.saveIt();
        end
    end
    
    methods (Access=private)
        function processSystem( self, systemName, parentSystem)
            [refMdls, mdlBlks] = find_mdlrefs(systemName, false);
            refMdls = removeMyselfFromList(refMdls, systemName);
            for x=1:size(refMdls,1)
                name = refMdls(1);
                aNewSystem = self.javaEcoreCreator.addSystem(name,parentSystem);
                processSystem(name, aNewSystem);
            end
        end
        
        function saveIt( self )
            topElement = self.javaEcoreCreator.getTopElement();
            self.modelManager.setTopElement( topElement );
            self.modelManager.validateIt();
            self.modelManager.saveIt();
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
