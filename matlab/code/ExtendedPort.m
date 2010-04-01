classdef ExtendedPort < handle
    properties
        portName                 = '';
        portHandle               = 0;
        portType                 = '';
        connected                = false;
        connectedToBlockNames    = '';
        connectedToBlockHandles  = 0;
        connectedToInstanceNames = '';
        connectedToPortNames     = '';
        connectedToPortHandles   = 0;
    end
    properties (Access=protected)
        originalPort;
        parentBlockHandle;  % for ModelReferences this is the System.
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
                ep = ExtendedOutport();
            else
                ep = ExtendedInport();
            end
            ep.doIt(aBlockHandle, aPortConnectivity);
        end
        
    end
    methods (Static, Access=private)
        function [name aHandle]=findPortNameAndHandle( ...
                bHandle, portType, portNumber)
            
            aHandle = find_system(bHandle,'SearchDepth',1, ...
                'BlockType', portType , ...
                'Port', portNumber );
            name = get_param(aHandle, 'Name');
        end
        
    end
    methods
        function doIt(self, aBlockHandle, aPortConnectivity)
            self.setParentBlockHandle( aBlockHandle );
            self.originalPort = aPortConnectivity;
            self.setPortNameAndHandle();
            self.connected = self.isPortConnected();
            if self.connected
                self.setConnectedBlockNames();
                self.setConnectedPorts();
            end
        end

        function setConnectedPorts( self )
            % here
        end
        
        function setConnectedBlockNames( self )
            theSize = self.numberOfConnections();
            self.connectedToBlockNames    = cell(1,theSize);            
            self.connectedToBlockHandles  = cell(1,theSize);
            self.connectedToInstanceNames = cell(1,theSize);
            for x=1:theSize
                blockHandle = self.getConnectedBlockHandleNr( x );
                    [ self.connectedToBlockNames(1,x) ...
                    self.connectedToBlockHandles(1,x) ...
                    self.connectedToInstanceNames(1,x) ] = ...
                    self.connectedBlockNr( blockHandle );
            end
        end
        
        function [blockName blockHandle blockInstanceName] = ...
                    connectedBlockNr( self, bHandle ) %#ok<MANU>
                        
            blockInstanceName = { get_param( bHandle, 'Name') };
            if Utils.blockIsModelReference( bHandle )
                [modelName handle] = ... 
                    Utils.getHandleForModelReference( bHandle );
                blockName   = { modelName };
                blockHandle = { handle };
            else
                blockName   = blockInstanceName;
                blockHandle = { bHandle };
            end
        end
        
        function setPortNameAndHandle( self )
            portNumberInBlock = self.originalPort.Type;
            [self.portName self.portHandle] = ...
                ExtendedPort.findPortNameAndHandle(...
                                self.parentBlockHandle, ...
                                self.portType, portNumberInBlock);
        end
                
        function setParentBlockHandle( self, instanceParentHandle )
            if Utils.blockIsModelReference( instanceParentHandle );
                [unused self.parentBlockHandle] = ... 
                Utils.getHandleForModelReference(instanceParentHandle);... 
                    %#ok<ASGLU>
            else
                self.parentBlockHandle = self.blockHandle;
            end
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