classdef ExtendedOutport < ExtendedPort
    methods (Static)
        function E=ExtendedOutport(aBlockHandle, aPortConnectivity)
            E.doIt(aBlockHandle, aPortConnectivity);
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
            boolean = (self.originalPort.DstBlock ~= -1);
        end

    end
end