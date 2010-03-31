classdef ExtendedPortConnectivity < handle
    properties (Access=private)        
%         blockHandle;
%         originalPortConnectivity;   %struct
%         extendedPC; % extended Port Connectivity struct
%         originalPort;
%         extendedPort;
%         firstElement = true;
    end
    methods (Static)
        function result=fromBlockName( name )
            aHandle = get_param( name, 'Handle');
            result = ExtendedPortConnectivity.fromBlockHandle( aHandle );
        end
        
        function result=fromBlockHandle( aBlockHandle )
            portConnectivity = get_param( aBlockHandle, 'PortConnectivity');
            theSize = size( portConnectivity,1 );
            result = cell(1,theSize);
            for x=1:theSize
                ep = ExtendedPort.new(aBlockHandle, portConnectivity(x) );
                result(1,x) = { ep };
            end
        end
    end
    
%     methods (Static, Access=private)
%         
%         function n = dataPortNumber( theTypeString )
%             n = str2num( theTypeString ); %#ok<ST2NM>
%             if isempty(n)
%                 n = 0;
%             end
%         end
%                 
%         function [name aHandle]=findPortNameAndHandle(bHandle, portType, portNumber)
%             aHandle = find_system(bHandle,'SearchDepth',1, ...
%                 'BlockType', portType , ...
%                 'Port', portNumber );
%             name = get_param(aHandle, 'Name');
%         end
%                 
%         function boolean = blockIsModelReference( block )
%             bType = get_param( block, 'BlockType');
%             boolean = strcmp(bType, 'ModelReference')==1;
%         end
%         
%     end
    
    methods        
%         function createStruct( self )
%             self.extendedPC = ExtendedPortConnectivity.createEmptyStruct();
%             for x=1:size( self.originalPortConnectivity,1 )
%                 self.originalPort = self.originalPortConnectivity(x);
%                 temp = ExtendedPortConnectivity.createEmptyStruct();
%                 self.extendedPort = temp(1);
%                 self.fillInData();
%                 posInStruct = self.nextPortNumber();
%                 self.extendedPC( posInStruct ) = self.extendedPort;
%             end
%         end
%         
%         function fillInData( self )
%             self.definePortType();
%             self.defineSrcPortNameAndHandle();
%             if self.extendedPort.connected
%                 self.defineConnectedBlockNames();
%                 self.defineConnectedPorts();
%             end
%         end
%                        
%         function num = portNumberWithinBlock(self, x)
%             if self.isInport()
%                 num = self.originalPort.SrcPort;
%             else
%                 num = self.originalPort.DstPort(x);
%             end
%         end
%         
%         function defineConnectedPorts( self )
%             bHandle = self.extendedPort.connectedToBlockHandle;
%             portType = ExtendedPortConnectivity.portOposite( self.extendedPort.portType );
%             theSize     = self.amountOfConnections();
%             portNames   = cell(1,theSize);
%             portHandles = cell(1,theSize);
%             for x=1:theSize
%                 portNumber = self.portNumberWithinBlock(x);                
%                 [aName aHandle] = ExtendedPortConnectivity.findPortNameAndHandle(...
%                     bHandle, portType, portNumber);
%                 portNames(x)    = { aName };
%                 portHandles(x)  = { aHandle };                
%             end
%             self.extendedPort.connectedToPortNames = portNames;
%             self.extendedPort.connectedToPortHandles = portHandles;
%         end
%         
%         function defineConnectedBlockNames( self )
%             theSize = self.amountOfConnections();
%             blockNames          = cell(1,theSize);            
%             blockHandles        = cell(1,theSize);
%             blockInstanceName   = cell(1,theSize);
%             for x=1:theSize
%                 bHandle = getConnectedBlockHandleNr( x );
%                 blockInstanceName(1,x) = { get_param( bHandle, 'Name') };
%                 if blockIsModelReference( bHandle )
%                     modelName = get_param(bHandle,'ModelName');
%                     blockNames(1,x)     = { modelName };
%                     blockHandles(1,x)   = get_param( modelName, 'Handle'); 
%                 else
%                     blockNames(1,x)     = blockInstanceName(1,x);
%                     blockHandles(1,x)   = bHandle;
%                 end                
%             end
%             self.extendedPort.connectedToInstanceName   = blockInstanceName;
%             self.extendedPort.connectedToBlockName      = blockNames;
%             self.extendedPort.connectedToBlockHandle    = blockHandles;
%         end
% 
%         function bHandle = getConnectedBlockHandleNr( self, x)
%             if self.isInport()
%                 bHandle = self.originalPort.SrcBlock;
%             else
%                 bHandle = self.originalPort.DstBlock(x);
%             end
%         end
%                 
%         function aHandle = getParentBlockHandle( self )
%             if self.blockIsModelReference( self.blockHandle );
%                 modelName = get_param(self.blockHandle,'ModelName');
%                 load_system( modelName );
%                 aHandle = get_param(modelName, 'Handle');
%             else
%                 aHandle = self.blockHandle;
%             end
%         end
%         
%         function defineSrcPortNameAndHandle( self )
%             bHandle = self.getParentBlockHandle();
%             portType = self.extendedPort.portType;
%             portNumber = self.originalPort.Type;
%             [name aHandle] = ExtendedPortConnectivity.findPortNameAndHandle(...
%                                 bHandle, portType, portNumber);
%             self.extendedPort.portName = name;
%             self.extendedPort.portHandle = aHandle;
%         end
%                  
%         function portNumber = nextPortNumber( self )
%             if self.firstElement
%                 self.firstElement = false;
%                 portNumber = 1;
%             else
%                 portNumber = size(self.extendedPC,2)+1;
%             end
%         end
%         
    end
    
end
