%**************************************************************************
%* Copyright (c) 2010 KTH, Mechatronics group and others.
%* All rights reserved. This program and the accompanying materials
%* are made available under the terms of the Eclipse Public License v1.0,
%* which accompanies this distribution, and is available at
%* http://www.eclipse.org/legal/epl-v10.html
%* 
%* Contributors: KTH, Mechatronics group
%**************************************************************************

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
        
        function uuid = getLineSrcUUID(self, x) 
            uuid = Utils.getUUIDfromBlock(self.connectedToPortHandles{x});
        end
        
        function uuid = getLineDstUUID(self, x) %#ok<INUSD>
            uuid = Utils.getUUIDfromBlock( self.fullName );
        end
        
    end
end