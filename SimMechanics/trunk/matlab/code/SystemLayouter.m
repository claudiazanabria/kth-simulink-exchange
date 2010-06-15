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

classdef SystemLayouter < handle
    properties
        distanceBetweenPorts    = 60;
        distanceBetweenSystmes  = 90;
        blockSize               = 150;
        portSizeHoriz                = 30;
        portSizeVert                 = 14;
    end
    properties (Access=private)
        top     = 50;
        left    = 20;
        bottom  = 0;
        right   = 0;
    end
    
    methods
        function result = nextPort(self)
            self.top = self.top + self.distanceBetweenPorts;
            self.buildPositionArray('port');
            result = [self.left self.top self.right self.bottom];
        end
        
        function result = nextSystem(self)
            self.left = self.left + self.distanceBetweenSystmes + self.blockSize;
            self.buildPositionArray('system');
            result = [self.left self.top self.right self.bottom];
        end
        
        function startWithSystems(self)
            self.top    = 40;
            self.left   = -140;
        end
        
        function startWithOutports(self)
            self.left = self.left + self.distanceBetweenSystmes + self.blockSize;
            if (self.left < 0), self.left = 100; end;
            self.top = 50;
        end
        
        function buildPositionArray(self, componentType)
            switch lower( componentType )
                case 'system'
                    self.bottom = self.top + self.blockSize;
                    self.right = self.left + self.blockSize;
                case 'port'
                    self.bottom = self.top + self.portSizeVert;
                    self.right = self.left + self.portSizeHoriz;
            end
        end
    end
end