classdef SimulinkCreator < handle
    % From ecore --> Matlab
    %properties(Access=private)
    properties
        sourceFilePath;
        modelManager;
        model;
        modelName;
        systemsRepository = containers.Map();
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
        
        function [name fileName] = computeFilename( aSystem )
            name = char(aSystem.getName());
            fileName = [name '.mdl'];
            aSystem.setFilename( fileName );
        end
        
        function boolean = portDoesNOTExists(parentName, instanceName, type)
            list = find_system(parentName, 'BlockType', type);
            boolean = ~SimulinkCreator.isNameInList(instanceName, list);
        end

        function position = computeSystemPosition(aSystem, systemLayouter)
            posString = aSystem.getPosition();
            if posString
                position = SimulinkCreator.posStr2Array( posString );
            else
                position = systemLayouter.nextSystem();
                posString = SimulinkCreator.posArray2Str( position );
                aSystem.setPosition( posString );
            end            
        end
        
        function createEmptyMDLFile( aSystem )
            name = char( aSystem.getName() );
            fileName = char( aSystem.getFilename() );
            new_system( name, 'Model');
            save_system( name, fileName );
            aSystem.setSimulinkName( name );
        end
        
    end
    methods
        function doIt(self)
            SimulinkCreator.removeAllElementsFromMap( self.systemsRepository );
            self.initEcoreReadingClasses();
            self.createModelInSimulink();
            self.processSystem( self.model.getRoot() );
            self.saveAndCloseOpenedSystems();
            open_system( self.modelName );
        end
    end
    
    methods (Access=private)
        function processSystem( self, parentSystem )
            fprintf('About to process: %s\n',char(parentSystem.getName()));
            systemLayouter = SystemLayouter();
            self.processInports( parentSystem, systemLayouter );                
            systemLayouter.startWithSystems();
            sysRefs = parentSystem.getChildren();
            for x=0:sysRefs.size()-1;
                sysRef = sysRefs.get(x);
                instanceName = self.computeSimulinkName( sysRef );              
                targetSys = sysRef.getTarget();
                self.addSystem(targetSys, instanceName, systemLayouter);                
                self.processSystem( targetSys );
            end
            systemLayouter.startWithOutports();
            self.processOutports( parentSystem, systemLayouter );                
        end

        function saveAndCloseOpenedSystems( self )
            keys = self.systemsRepository.keys();            
            for x=fliplr(1:size(keys,2))
                sysName = self.systemsRepository( char(keys(x)) );
                save_system( sysName );
                close_system( sysName );
            end
        end
        
        function processInports( self, aSystem, systemLayouter )
            portList = aSystem.getInports();
            self.processPorts( 'Inport', portList, systemLayouter);
        end
        
        function processOutports( self, aSystem, systemLayouter )
            portList = aSystem.getOutports();
            self.processPorts( 'Outport', portList, systemLayouter);
        end
        
        function processPorts(self, type, portList, systemLayouter)
            for x=0:portList.size()-1
                port = portList.get(x);
                self.createPortIfNOTPresent( port, type, systemLayouter);
            end
        end
                
        function createPortIfNOTPresent( self, port, type, systemLayouter)
            instanceName = self.computeSimulinkName( port );
            parentName = char(port.getParent().getName());
            if SimulinkCreator.portDoesNOTExists(parentName, instanceName, type)                
                blockType = ['built-in/' type];
                position = systemLayouter.nextPort();
                add_block(blockType, instanceName, 'Position', position);
            end
        end
                
                
        function addSystem( self, aSystem, instanceName, systemLayouter)
            self.createSystemIfNeeded( aSystem );
            modelname = char(aSystem.getName());
            position = SimulinkCreator.computeSystemPosition(aSystem, systemLayouter);
            add_block('built-in/ModelReference', instanceName,...
                'ModelName', modelname, 'Position', position);
        end
        
        function createSystemIfNeeded( self, aSystem )
            sysName = char(aSystem.getName());
            if  self.systemHasNOTBeenHandled( sysName )
                self.createSystem( aSystem );                
            end
        end

        function createSystem( self, aSystem )
            [name fileName] = SimulinkCreator.computeFilename( aSystem );
            aSystem.setSimulinkName( name );
            fileExists = SimulinkCreator.isMDLFileReadable( fileName );
            containsBehaviour = SimulinkCreator.mightContainBehaviour( aSystem );
            if fileExists
                if containsBehaviour
                    self.loadSystem( aSystem );
                    return
                else
                    delete( fileName );
                end
            end
            SimulinkCreator.createEmptyMDLFile( aSystem );
            self.loadSystem( aSystem );
        end
                
        function loadSystem( self, aSystem )
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
            rootSystem = self.model.getRoot();
            name = char(rootSystem.getName());
            self.modelName = name;
            rootSystem.setSimulinkName( name );
            SimulinkCreator.closeFirstIfAlreadyOpen( name )
            SimulinkCreator.createEmptyMDLFile( rootSystem );
            self.loadSystem( rootSystem );
        end        
    end
    
end
