classdef ExtendedInport < ExtendedPort
    methods (Static)
        function E=ExtendedInport()
            E.portType = 'Inport';
        end
    end
    methods
        function boolean = isInport( self ) %#ok<MANU>
            boolean = true;
        end
        
        function boolean = isOutport( self ) %#ok<MANU>
            boolean = false;
        end
        
        function type = oppositePortType( self ) %#ok<MANU>
            type = 'Outport';
        end
        
        function number = numberOfConnections( self ) %#ok<MANU>
            number = 1;
        end
        
        function boolean = isPortConnected( self )
            boolean = (self.originalPort.SrcBlock ~= -1);
        end
        
        function bHandle = getConnectedBlockHandleNr(self, x) %#ok<INUSD>
            bHandle = self.originalPort.SrcBlock;
        end
        
        function number = getPortNrInConnectedBlock(self, x)
            number = self.originalPort.SrcPort(x);
        end
        
        function name = getLineSrc(self, x) 
            name = self.connectedToPortNames{x};
        end
        
        function name = getLineDst(self, x) %#ok<INUSD>
            name = self.portName;
        end
    end
end