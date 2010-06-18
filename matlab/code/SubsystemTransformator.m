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

classdef SubsystemTransformator
    properties
        systemName;
    end
    methods (Static)
        function ST=SubsystemTransformator( sysName )
            ST.systemName = sysName;
            ST.doIt();
        end
    end
    methods
        function doIt( self )
            self.fixModelSettings();
            blocks = find_system(self.systemName,'SearchDepth',1,'BlockType','SubSystem');
            zize = size(blocks,1);
            fprintf('Attemting to transform %d blocks.\n', zize);
            for x=1:zize
                block = blocks{x};
                virtual = get_param(block,'IsSubsystemVirtual');
                if strcmp(virtual, 'off')
                    fprintf('Block: %s\t',block);
                    mdlRef = Utils.extractOnlyName(block);
                    [success,mdlRefBlkH] = Simulink.SubSystem. ...
                        convertToModelReference(block, mdlRef, 'ReplaceSubsystem',true,'Force',true); %#ok<NASGU>
                    if success
                        fprintf('succeded.\n');
                    else
                        fprintf('failed.\n');
                    end
                else
                    fprintf('Block %s is NOT atomic, ignoring it.\n',block);
                end
            end
        end
        
        function fixModelSettings( self )
            set_param(self.systemName, 'InlineParams', 'on');
            set_param(self.systemName, 'SignalResolutionControl', 'UseLocalSettings');
            set_param(self.systemName, 'StrictBusMsg', 'ErrorLevel1')
        end
    end
end