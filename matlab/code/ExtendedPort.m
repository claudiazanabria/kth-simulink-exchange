classdef ExtendedPort < handle
    properties
        portName                 = '';
        portHandle               = 0;
        portType                 = '';
        connected                = false;
        connectedToBlockType     = '';
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
            theSize = size(self.connectedToBlockHandles,2);
            self.connectedToPortNames   = cell(1,theSize);
            self.connectedToPortHandles = cell(1,theSize);            
            for x=1:theSize
                bHandle = self.connectedToBlockHandles{x};
                nr = num2str(self.getPortNrInConnectedBlock(x)+1);
                [pName pHandle] = self.findPortInfo( bHandle, nr );
              self.connectedToPortNames(1,x) = { pName };
              self.connectedToPortHandles(1,x) = { pHandle };
            end
        end
        
        function [pName pHandle] = findPortInfo( self, ...
                bHandle, portNummer)
            oposite = self.oppositePortType();
            [name pHandle] = ExtendedPort.findPortNameAndHandle( ... 
                bHandle, oposite, portNummer );
            if isempty( name )
                % port is an inport from the enclosing system.
                name = get_param(bHandle, 'Name');
                pHandle = bHandle;
                self.connectedToBlockType = self.portType;
            else
                self.connectedToBlockType = 'Block';
            end
            parentName = get_param(pHandle, 'Parent');
            pName = [parentName '/' name ];            
        end
               
%         function parentName = getParentNameRecursively(self, handleOrName)
%             parentName = get_param(handleOrName, 'Parent');
%         end
        
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

            parentName = get_param(bHandle, 'Parent');
            temp = [parentName '/' get_param( bHandle, 'Name')];
            blockInstanceName = { temp };
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
            [pName self.portHandle] = ...
                ExtendedPort.findPortNameAndHandle(...
                                self.parentBlockHandle, ...
                                self.portType, portNumberInBlock);
            parentName = get_param(self.portHandle, 'Parent');
            self.portName = [parentName '/' pName];
        end
                
        function setParentBlockHandle( self, instanceParentHandle )
            if Utils.blockIsModelReference( instanceParentHandle );
                [unused self.parentBlockHandle] = ... 
                Utils.getHandleForModelReference(instanceParentHandle);... 
                    %#ok<ASGLU>
            else
                self.parentBlockHandle = instanceParentHandle;
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