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
            zize = size( extendedPort.lineDstFullName, 2 );
            for x=1:zize
                lineDstFullName = extendedPort.lineDstFullName{x};
                fprintf('%s\n',lineDstFullName);
                if ~self.visitedPorts.contains( lineDstFullName )
                    self.processPort( extendedPort );
                end
            end
        end
        
        function processPort(self, extendedPort )
            zize = extendedPort.numberOfConnections();
            for x=1:zize
                if extendedPort.connected
                    aLine = modelManagement.simulink.LineInfo(self.parentSystem);
                    aLine.setName( 'lineName' );
                    aLine.setSrcName( char(extendedPort.lineSrcPortName(x)) );
                    aLine.setDstName( char(extendedPort.lineDstPortName(x)) );
                    self.createdLines.add( aLine );
                    self.visitedPorts.add( char(extendedPort.lineDstFullName(x)) );
                end
            end
        end
        
        function list = getCreatedLines( self )
            list = self.createdLines;
        end
    end
end

