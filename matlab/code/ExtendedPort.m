classdef ExtendedPort < handle
    properties
        portName                = '';
        portHandle              = 0;
        portType                = '';
        connected               = false;
        connectedToBlockName    = '';
        connectedToBlockHandle  = 0;
        connectedToInstanceName = '';
        connectedToPortNames    = '';
        connectedToPortHandles  = 0;
    end
    properties (Access=private)
        originalPort;
        parentBlockHandle;
    end
    methods (Abstract)
        boolean = isInport( self );
        boolean = isOutport( self );
        type = oppositePortType( self );
        number = numberOfConnections( self );
        boolean = isPortConnected( self );
    end
    methods (Static)
        function ep=new(aBlockHandle, aPortConnectivity )
            aBlock = aPortConnectivity.SrcBlock;
            if isempty( aBlock )    
                ep = ExtendedOutport(aBlockHandle, aPortConnectivity);
            else
                ep = ExtendedInport(aBlockHandle, aPortConnectivity);
            end
        end               
    end
    methods
        function doIt(self, aBlockHandle, aPortConnectivity)
            self.parentBlockHandle = aBlockHandle;
            self.originalPort = aPortConnectivity;
            self.portName = 'test';
        end
        
        function asStruct = asStruct( self )
            aStruct = struct( ...
                'portName',     self.portName,     ...
                'portHandle',   self.portHandle,      ...
                'portType',     self.portType,     ...
                'connected',    self.connected,  ...
                ...
                'connectedToBlockName', self.connectedToBlockName,     ...
                'connectedToBlockHandle', self.connectedToBlockHandle,    ...
                'connectedToInstanceName', self.connectedToInstanceName,  ...
                'connectedToPortNames',  self.connectedToPortNames,    ...
                'connectedToPortHandles', self.connectedToPortHandles     );
        end                        
    end
end