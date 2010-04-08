classdef ExtendedOutport < ExtendedPort
    methods (Static)
        function E=ExtendedOutport()
            E.portType = 'Outport';
        end
    end
    methods
        function boolean = isInport( self ) %#ok<MANU>
            boolean = false;
        end
        
        function boolean = isOutport( self ) %#ok<MANU>
            boolean = true;
        end
        
        function type = oppositePortType( self ) %#ok<MANU>
            type = 'Inport';
        end
        
        function number = numberOfConnections( self )
            number = size(self.originalPort.DstBlock,2);
        end
        
        function boolean = isPortConnected( self )
            % DstBlock might be an array
            boolean = any(self.originalPort.DstBlock ~= -1);
        end
        
        function bHandle = getConnectedBlockHandleNr( self, x)
            bHandle = self.originalPort.DstBlock(x);
        end
        
        function number = getPortNrInConnectedBlock(self, x)
            number = self.originalPort.DstPort(x);
        end
        
        function uuid = getLineDstUUID(self, x) 
            uuid = Utils.getUUIDfromBlock(self.connectedToPortHandles{x});
        end
        
        function uuid = getLineSrcUUID(self, x) %#ok<INUSD>
            uuid = Utils.getUUIDfromBlock( self.fullName );
        end
        
    end
end