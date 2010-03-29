classdef ModelCreator < handle
    % Ecore --> Simulink 
    %
    % TODO:
    % 1: If a port is removed (in the ecore model) from a system that 
    %     has behaviour, the port should be removed from the simulink
    %     system as well.
    %  
    % 2: Saving and closing all systems. Refreshing problem.
    properties (Access=private)
        ecoreFile;
    end
    
    methods (Static)
        function MC=fromFile( path2ecoreFile )
            MC=ModelCreator();
            MC.ecoreFile = path2ecoreFile;
        end
        
    end
    methods (Static, Access=private)

        function boolean = systemContainsBehaviour( aSystem )
            boolean = (aSystem.getChildren().size() == 0);
        end

        function array = posStr2Array( string )
            array = sscanf(string ,'[%d %d %d %d]')';
        end
        
        function array = position2Array( port )
            posString = char( port.getPosition() );
            array = ModelCreator.posStr2Array( posString );
        end
        
        function boolean = portDoesNOTExists( port, type )
            parentName = char( port.getParent().getSimulinkName() );
            list = find_system(parentName, 'BlockType', type);
            portName = char( port.getSimulinkName() );
            boolean = ~Utils.isNameInList(portName, list);
        end

        function boolean = isAsystem( element )
            type = char(element.eClass().getName());
            if strcmp(type,'System')==1
                boolean = true;
            else
                boolean = false;
            end
        end
        
        function boolean = isAsystemReference( element )
            type = char(element.eClass().getName());
            if strcmp(type,'SystemReference')==1
                boolean = true;
            else
                boolean = false;
            end
        end
        
        function refreshAndSaveSystems()
            list = find_system('BlockDiagramType','model');
            for x=1:size(list,1)
                name = char( list(x) );
                obj = get_param( name, 'Object');
                obj.refreshModelBlocks();
                save_system( name );
            end
            close_system( list );
        end
        
        function openRootSystem( list )
            file = char( list.get(0).getRoot().getFilename() );
            open_system( file );
        end
        
    end
    methods
        function doIt( self )
            modelManager = modelManagement.simulink.SimulinkModelManager( self.ecoreFile );
            modelManager.loadIt();
            model = modelManager.getTopElement();
            list = modelManagement.simulink.ModelProcessor.doIt(model);
            self.processList( list );
            ModelCreator.refreshAndSaveSystems();
            ModelCreator.openRootSystem( list );
        end
        
        function processList( self, aList )
            listSize = aList.size();
            for x=0:listSize-1;
                element = aList.get(x);
                self.processElement( element );
            end
        end
        
        function processElement( self, anElement )
            elementType = char(anElement.eClass().getName());
            switch (elementType)
                case 'System'
                    self.processSystem( anElement );
                case 'SystemReference'
                    self.processSysRef( anElement );
                case 'Inport'
                    self.processInport( anElement );
                case 'Outport'
                    self.processOutport( anElement );
                case 'Line'
                    self.processLine( anElement );
            end
        end

        function processLine( self, aLine ) %#ok<MANU>
            src = char( aLine.getSimuNameSrc() );
            dst = char( aLine.getSimuNameDst() );
            sys = char( aLine.getParent().getSimulinkName() );
            add_line(sys, src, dst, 'autorouting' ,'on');
        end
        
        function processSysRef( self, aSysRef ) %#ok<MANU>
            aSystem = aSysRef.getTarget();
            modelname       = char( aSystem.getName() );
            position        = char( aSysRef.getPosition() );
            instanceName    = char( aSysRef.getSimulinkName() );
            add_block('built-in/ModelReference', instanceName,...
                'ModelName', modelname, 'Position', position);            
        end
        
        function processSystem( self, aSystem ) %#ok<MANU>
            name            = char( aSystem.getName() );
            fileName        = char( aSystem.getFilename() );
            fileExists      = Utils.isMDLFileReadable( fileName );
            containsBehaviour = ModelCreator.systemContainsBehaviour( aSystem );
            if fileExists
                if containsBehaviour
                    load_system( name );
                    return
                else
                    delete( fileName );
                end
            end
            new_system( name, 'Model');
        end
                
        function processInport( self, inport )
            type = 'Inport';
            self.processPort( inport, type );
        end
        
        function processOutport( self, inport )
            type = 'Outport';
            self.processPort( inport, type );
        end
        
        function processPort( self, port, type ) %#ok<MANU>
            blockType = ['built-in/' type];
            instanceName = char( port.getSimulinkName() );
            if ModelCreator.portDoesNOTExists(port, type)
                position = ModelCreator.position2Array( port );
                add_block(blockType, instanceName, 'Position', position);
            end
        end
        
        
    end
    
end
