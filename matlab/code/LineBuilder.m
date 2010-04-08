classdef LineBuilder < handle
    % I translate an array of ExtendedPortConnectivity
    % into a Java list of LineInfo.
    % In other words, extract all the info needed to create 
    % all lines starting or ending in this block.
    properties
        parentSystem;
        visitedPorts;
        createdLines;
    end
    methods (Static)
        function LB=LineBuilder( parentSystem )
            LB.parentSystem = parentSystem;
            LB.visitedPorts = java.util.LinkedHashSet();
            LB.createdLines = modelManagement.simulink.LineInfo.createArray();            
        end
    end
    methods
        function process( self, extendedPorts )
            zize = size( extendedPorts, 2 );
            for x=1:zize
                self.processExtendedPort( extendedPorts{x} );
            end
        end
                
        function processExtendedPort( self, extendedPort )
            zize = size( extendedPort.connectedToPortHandles, 2 );
            for x=1:zize
                if extendedPort.connected
                    self.processPort( extendedPort );
                end
            end
        end
        
        function processPort(self, extendedPort )
            zize = extendedPort.numberOfConnections();
            for x=1:zize
                dstUUIDStr = extendedPort.lineDstUUID{x};
                %fprintf('%s\t%s\n',extendedPort.fullName, dstUUIDStr);
                if ~self.visitedPorts.contains( dstUUIDStr )                    
                    aLine = modelManagement.simulink.LineInfo(self.parentSystem);
                    aLine.setName( 'unnamed' );
                    aLine.setSrcPort( extendedPort.lineSrcUUID{x} );
                    aLine.setDstPort( dstUUIDStr );
                    self.createdLines.add( aLine );
                    self.visitedPorts.add( dstUUIDStr );
                    %self.printIt( extendedPort, x );
                end
            end
        end
        
%         function printIt( self, ep, x) %#ok<MANU>
%             fName = ep.fullName;
%             pName = ep.connectedToPortFullNames{x};
%             id = ep.lineDstUUID{x};
%             fprintf('Adding %s \t\t connectedTo: %s \t\tAdding: %s\n', fName, pName, id );
%         end
        
        function list = getCreatedLines( self )
            list = self.createdLines;
        end
    end
end

