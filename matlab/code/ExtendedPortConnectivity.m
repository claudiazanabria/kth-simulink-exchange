classdef ExtendedPortConnectivity < handle
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
%     end
    
    methods        
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
