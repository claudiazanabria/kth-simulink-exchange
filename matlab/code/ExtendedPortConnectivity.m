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
%                 
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
% 
%                 
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
