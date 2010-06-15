% Copyright (c) 2010, KTH, Machine Design, Embedded Control Systems group
% All rights reserved.
% 
% Redistribution and use in source and binary forms, with or without
% modification, are permitted provided that the following conditions are met:
%     * Redistributions of source code must retain the above copyright
%       notice, this list of conditions and the following disclaimer.
%     * Redistributions in binary form must reproduce the above copyright
%       notice, this list of conditions and the following disclaimer in the
%       documentation and/or other materials provided with the distribution.
%     * Neither the name KTH nor the
%       names of its contributors may be used to endorse or promote products
%       derived from this software without specific prior written permission.
% 
% THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
% ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
% WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
% DISCLAIMED. IN NO EVENT SHALL <COPYRIGHT HOLDER> BE LIABLE FOR ANY
% DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
% (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
% LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
% ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
% (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
% SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

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
            import se.kth.md.simulinkExchange.modelConversion.simulink.LineInfo;
            LB.createdLines = LineInfo.createArray();            
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
            import se.kth.md.simulinkExchange.modelConversion.simulink.LineInfo;
            zize = extendedPort.numberOfConnections();
            for x=1:zize
                dstUUIDStr = extendedPort.lineDstUUID{x};
                %fprintf('%s\t%s\n',extendedPort.fullName, dstUUIDStr);
                if ~self.visitedPorts.contains( dstUUIDStr )                    
                    aLine = LineInfo(self.parentSystem);
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

