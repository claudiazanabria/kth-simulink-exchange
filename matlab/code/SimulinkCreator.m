classdef SimulinkCreator < handle
    % From ecore --> Matlab
    %properties(Access=private)
    properties
        sourceFilePath;
        modelManager;
        model;
        systemsRepository = containers.Map();
        defaultModelName = 'unnamed';
    end
    methods (Static)
        % do not use the whole path name. CD first!
        function SC=fromFile( path2ecoreFile )
            SC=SimulinkCreator();
            SimulinkCreator.checkEcoreFileReadable( path2ecoreFile );
            SC.sourceFilePath = path2ecoreFile;
            SimulinkCreator.removeAllElementsFromMap( SC.systemsRepository );
        end
        
    end
    methods (Static, Access=private)
        function removeAllElementsFromMap( map )
            keys = map.keys();
            for x=1:size(keys,2)
                map.remove( keys(x) );
            end            
        end

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

        function boolean = isMDLFileReadable( path2mdlFile )
            boolean = (exist(path2mdlFile,'file') == 4);
        end        

        function closeFirstIfAlreadyOpen( modelName )
            sys = find_system();
            if SimulinkCreator.isNameInList(modelName, sys)
                save_system( modelName );
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
        
        function boolean = mightContainBehaviour( aSystem )
            boolean = (aSystem.getChildren().size() == 0);
        end
        
        function array = posStr2Array( string )
            array = sscanf(string ,'[%d %d %d %d]')';
        end

        function string = posArray2Str( positionArray )
            string = sprintf('[%d %d %d %d]',positionArray);
        end
    end
    methods
        function doIt(self)
            self.initEcoreReadingClasses();
            self.createModelInSimulink();
            self.processSystem( self.model.getRoot() );
            open_system( self.defaultModelName );            
        end
    end
    
    methods (Access=private)
        function processSystem( self, parentSystem )
            fprintf('About to process: %s\n',char(parentSystem.getName()));
            systemLayouter = SystemLayouter();
            systemLayouter.startWithSystems();
            sysRefs = parentSystem.getChildren();
            for x=0:sysRefs.size()-1;
                sysRef = sysRefs.get(x);
                instanceName = self.computeSimulinkName( sysRef );
                targetSys = sysRef.getTarget();
                self.addSystem(targetSys, instanceName, systemLayouter);
                self.processSystem( targetSys );
            end
        end
        
        function position = computeSystemPosition(self, aSystem, systemLayouter)
            posString = aSystem.getPosition();
            if posString
                position = SimulinkCreator.posStr2Array( posString );
            else
                position = systemLayouter.nextSystem();
                posString = SimulinkCreator.posArray2Str( position );
                aSystem.setPosition( posString );
            end
            
        end
                
        function addSystem( self, aSystem, instanceName, systemLayouter)
            self.createSystemIfNeeded( aSystem );
            modelName = char(aSystem.getName());
            position = self.computeSystemPosition(aSystem, systemLayouter);
            add_block('built-in/ModelReference', instanceName,...
                'ModelName', modelName, 'Position', position);
        end
        
        function createSystemIfNeeded( self, aSystem )
            sysName = char(aSystem.getName());
            if  self.systemHasNOTBeenHandled( sysName )
                self.createSystem( aSystem );
                self.addSystemToRepository( aSystem );
            end
        end

        function createSystem( self, aSystem )
            fileName = [char(aSystem.getName()) '.mdl'];
            aSystem.setFilename( fileName ); 
            fileExists = SimulinkCreator.isMDLFileReadable( fileName );
            containsBehaviour = SimulinkCreator.mightContainBehaviour( aSystem );
            if fileExists
                if containsBehaviour 
                    return
                else
                    delete( fileName );
                end
            end
            self.createEmptyMDLFile( aSystem );
        end
        
        function createEmptyMDLFile( self, aSystem )
            name = char( aSystem.getName() );
            fileName = char( aSystem.getFilename() );
            new_system( name, 'Model');
            save_system( name, fileName );
            aSystem.setSimulinkName( name );
        end

        function addSystemToRepository( self, aSystem )
            name = char(aSystem.getName());
            load_system( name );
            handle = get_param(name, 'Handle');
            self.systemsRepository( name ) = handle;
        end
        
        function boolean = systemHasNOTBeenHandled( self, sysName )
            boolean = ~self.systemsRepository.isKey( sysName );
        end
                
        function instanceName = computeSimulinkName( self, sysRef ) %#ok<MANU>
            parentName = char(sysRef.getParent().getSimulinkName());
            targetName = char(sysRef.getName());
            instanceName = [parentName '/' targetName];
            sysRef.setSimulinkName( instanceName );
        end
        
        function initEcoreReadingClasses(self)
            self.modelManager = modelManagement.simulink.SimulinkModelManager(self.sourceFilePath);
            self.modelManager.loadIt();
            self.model = self.modelManager.getTopElement();
        end
        
        function createModelInSimulink( self )
            modelName = self.defaultModelName;
            SimulinkCreator.closeFirstIfAlreadyOpen( modelName )
            new_system( modelName );
            load_system( modelName );
            self.setRootSystemName( modelName );
        end
        
        function setRootSystemName( self, name )
            rootSystem = self.model.getRoot();
            rootSystem.setSimulinkName( name );
        end
        
    end
    
end
