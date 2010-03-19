classdef SimulinkCreator < handle
    % From ecore --> Matlab
    properties(Access=private)
        sourceFilePath;
        modelManager;
        model;
    end
    methods (Static)
        % do not use the whole path name. CD first!
        function SC=fromFile( path2ecoreFile )
            SC=SimulinkCreator();
            SimulinkCreator.checkEcoreFileReadable( path2ecoreFile );            
            SC.sourceFilePath = path2ecoreFile;
        end
                
    end
    methods (Static, Access=private)
        function checkEcoreFileReadable( ecorePath )
            if (~SimulinkCreator.isEcoreFileReadable( ecorePath ))
                errRecord = MException('SimulinkCreator:EcorenotReadable', ...
                    'Ecore file is not readable: %s', ecorePath);
                throw(errRecord);
            end
        end
        
        function boolean = isEcoreFileReadable( path2EcoreFile )
            boolean = (exist(path2EcoreFile,'file') == 2);
        end  
        
        function closeFirstIfAlreadyOpen( modelName )
            sys = find_system();
            if SimulinkCreator.isNameInList(modelName, sys)
                close_system( modelName );
            end
        end
        
        function boolean=isNameInList( name, list )
            for x=1:size( list )
               if strcmp(list(x), name)
                   boolean = true;
                   return;
               end
            end
            boolean = false;
        end
        
    end
    methods
        function doIt(self)
            self.initEcoreReadingClasses();
            self.createModelInSimulink();
            self.processSystem( self.model.getRoot() );
        end
    end
    
    methods (Access=private)
        function processSystem( self, parentSystem )
            sysRefs = parentSystem.getChildren();
            for x=1:sysRefs.size();
                sysRef = sysRefs.get(x);
                instanceName = sysRef.getName();
                targetSys = sysRef.getTarget();
                self.addSystem(targetSys, instanceName, parentSystem);
                self.processSystem( targetSys );
            end
        end
    
        function addSystem( self, aSystem, instanceName, parentSystem )
            if isEmpty( instanceName )
                instanceName = [parentSystem.getName() '/' aSystem.getName()];
            end
            add_block('built-in/ModelReference', instanceName,...
                'ModelName', aSystem.getName());
        end
                
        function initEcoreReadingClasses(self)
            self.modelManager = modelManagement.simulink.SimulinkModelManager(self.sourceFilePath);
            self.modelManager.loadIt();
            self.model = self.modelManager.getTopElement();
        end
                    
        function createModelInSimulink( self )
            modelName = 'unnamed';
            SimulinkCreator.closeFirstIfAlreadyOpen( modelName )
            new_system( modelName );
            load_system( modelName );
        end
                
    end
end
