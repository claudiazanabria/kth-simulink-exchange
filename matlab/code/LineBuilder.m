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
        function lines = process( self, extendedPorts )
            zize = size( extendedPorts, 2 );
            for x=1:zize
                portName = extendedPorts{x}.portName;
                if ~self.visitedPorts.contains( portName )
                    self.processPort( extendedPorts{x} );
                end
            end
            lines = self.createdLines;
        end
                
        function processPort(self, extendedPort )
            zize = extendedPort.numberOfConnections();
            for x=1:zize
                aLine = modelManagement.simulink.LineInfo(self.parentSystem);                
                aLine.setName( 'lineName' );
                aLine.setSrcName( char(extendedPort.lineSrcPortName{x}) );
                aLine.setDstName( char(extendedPort.lineDstPortName{x}) );
                self.createdLines.add( aLine );
                self.visitedPorts.add( char(extendedPort.lineDstPortName{x}) );                
            end 
        end        
    end
end

