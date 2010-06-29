%**************************************************************************
%* Copyright (c) 2010 KTH, Mechatronics group and others.
%* All rights reserved. This program and the accompanying materials
%* are made available under the terms of the Eclipse Public License v1.0,
%* which accompanies this distribution, and is available at
%* http://www.eclipse.org/legal/epl-v10.html
%* 
%* Contributors: KTH, Mechatronics group
%**************************************************************************

classdef ExtendedPort < handle
    properties
        portName                 = '';
        fullName                 = '';
        portHandle               = 0;
        portType                 = '';
        connected                = false;
        connectedToBlockType     = '';
        connectedToBlockNames    = {};
        connectedToBlockHandles  = 0;
        connectedToInstanceNames = {};
        connectedToPortFullNames = {};
        connectedToPortHandles   = {};
        lineSrcUUID              = {};
        lineDstUUID              = {};
        lineNames                = {};
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
        bHandle = getConnectedBlockHandleNr(self, x);
        name = getLineSrcUUID(self, x);
        name = getLineDstUUID(self, x);
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
        'FollowLinks', 'On',...        
        'BlockType', portType ,'Port', portNumber );
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
%                fprintf('%s\n',self.fullName);
                self.setLineEndings();
            end
        end
        
        function setLineEndings( self )
            theSize = self.numberOfConnections();
            self.lineSrcUUID            = cell(1,theSize);
            self.lineDstUUID            = cell(1,theSize);
            for x=1:theSize
                self.lineSrcUUID(1,x) = { self.getLineSrcUUID(x) };
                self.lineDstUUID(1,x) = { self.getLineDstUUID(x) };
            end
        end
        
        function setConnectedPorts( self )
            theSize = self.numberOfConnections();
            self.connectedToPortFullNames   = cell(1,theSize);
            self.connectedToPortHandles     = cell(1,theSize);
            for x=1:theSize
                bHandle = self.connectedToBlockHandles{x};
                nr = num2str(self.getPortNrInConnectedBlock(x)+1);
                [fName pHandle] = self.findPortInfo( bHandle, nr );
                self.connectedToPortFullNames(1,x) = { fName };
                self.connectedToPortHandles(1,x) = { pHandle };
            end
        end
        
        function [fName pHandle] = findPortInfo( self, ...
                bHandle, portNummer)
            oposite = self.oppositePortType();
            [pName pHandle] = ExtendedPort.findPortNameAndHandle( ...
                bHandle, oposite, portNummer );
            if isempty( pName )
                % port is an inport from the enclosing system.
                pName = get_param(bHandle, 'Name');
                pHandle = bHandle;
                self.connectedToBlockType = self.portType;
            else
                self.connectedToBlockType = 'Block';
            end
            parentname = get_param(pHandle, 'Parent');
            fName = [parentname '/' pName ];
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
            
            pName = get_param(bHandle, 'Parent');
            temp = [pName '/' get_param( bHandle, 'Name')];
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
            self.portName = pName;
            self.fullName = [parentName '/' pName];
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
    end
end
