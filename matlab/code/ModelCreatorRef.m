% Copyright (c) 2010, KTH, Machine Design, Embedded Control Systems group
% All rights reserved.
% 
% Redistribution and use in source and binary forms, with or without
% modification, are permitted provided that the following conditions are met:
%     * Redistributions of source code must retain the above copyright
%       notice, this list of conditions and the following disclaimer.
%     * Redistributions in binary form must reproduce the above copyright
%       notice, this list of conditions and the following disclaimer in the
%       documentation and/or other materials provided with the distribution.
%     * Neither the name KTH nor the
%       names of its contributors may be used to endorse or promote products
%       derived from this software without specific prior written permission.
% 
% THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
% ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
% WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
% DISCLAIMED. IN NO EVENT SHALL <COPYRIGHT HOLDER> BE LIABLE FOR ANY
% DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
% (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
% LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
% ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
% (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
% SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

classdef ModelCreatorRef < handle
    % Ecore --> Simulink using reference mechanism
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
            MC=ModelCreatorRef();            
%             if Utils.isReadableByJava( path2ecoreFile )
%                 MC.ecoreFile = path2ecoreFile;
%             else
%                 MC.ecoreFile = fullfile(cd(),path2ecoreFile);
%             end         
            MC.ecoreFile = path2ecoreFile;
            MC.doIt();
        end
        
    end
    methods (Static, Access=private)

        function boolean = systemContainsBehaviour( aSystem )
            boolean = (aSystem.getChildren().size() == 0);
        end
        
        function boolean = portDoesNOTExists( port, type )
            parentName = Utils.getLibraryName(char( port.getParent().getSimulinkName() ));
            list = find_system(parentName, 'FollowLinks','on','BlockType', type);
            portName = Utils.getLibraryName(char( port.getSimulinkName() ));
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
        
        function array = position2Array( port )
            posString = char( port.getPosition() );
            array = Utils.posStr2Array( posString );
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
    methods (Access=private)
        function doIt( self )
            import se.kth.md.simulinkExchange.management.simulink.SimulinkModelManager;            
            import se.kth.md.simulinkExchange.conversion.simulink.preprocessing.ModelProcessor;
            open_system(Utils.getLibraryName()); 
            set_param(Utils.getLibraryName(),'Lock','off');
            modelManager = SimulinkModelManager( self.ecoreFile );
            modelManager.loadIt();
            model = modelManager.getTopElement();
            list = ModelProcessor.doIt(model);
            self.processList( list );
            ModelCreatorRef.refreshAndSaveSystems();
            ModelCreatorRef.openRootSystem( list );
            %The library needs to be opened, so that blocks can be found
            open_system(Utils.getLibraryName()); 
            set_param(Utils.getLibraryName(),'Lock','off');
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
                case 'Model'
                    self.processModel( anElement);               
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
        
        function processModel( self, aModel)
            instanceName    = char( aModel.getSimulinkName() );
            new_system( instanceName );
            open_system( instanceName );
        end

        function processLine( self, aLine ) %#ok<MANU>
            src = char( aLine.getSimuNameSrc() );
            dst = char( aLine.getSimuNameDst() );
            sys = char( aLine.getParent().getSimulinkName() );
            add_line(sys, src, dst, 'autorouting' ,'on');
        end
        
        function processSysRef( self, aSysRef ) %#ok<MANU>
        %Inputs a System
            aSystem = aSysRef.getTarget();
            modelname       = Utils.getLibraryName( char( aSystem.getName() ));
            position        = Utils.posStr2Array( aSysRef.getPosition() );
            instanceName    = char( aSysRef.getSimulinkName() );            
            add_block(modelname, instanceName,...
                 'Position', position);
            Utils.setUUIDinUserData( aSysRef, instanceName );
        end
        
        function processSystem( self, aSystem ) %#ok<MANU>
             name            = char( aSystem.getName() );
%            fileName        = char( aSystem.getFilename() );
%            fileExists      = Utils.isMDLFileReadable( fileName );
             containsBehaviour = ModelCreatorRef.systemContainsBehaviour( aSystem );
             existingBlocks=find_system(Utils.getLibraryName(), 'SearchDepth', 1,'name', name);
             blockExists = size(existingBlocks) > 0;
             if blockExists 
                 if containsBehaviour
%                     load_system( name );
                     return
                 else
%                     delete( fileName );
                 end
             else
                 add_block('built-in/SubSystem',Utils.getLibraryName(name));
             end
%             new_system( name, 'Model');
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
            portType = ['built-in/' type];
            portName =  Utils.getLibraryName(char( port.getSimulinkName() ));
            if ModelCreatorRef.portDoesNOTExists(port, type)
                position = ModelCreatorRef.position2Array( port );
                add_block(portType, portName, 'Position', position);
                Utils.setUUIDinUserData( port, portName )
            end
        end
        
        
    end
    
end
