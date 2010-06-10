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
% Adds JARs to class path
classdef ClassPathSetter
    % aca tambien
    properties
        basePath = 'F:/Documents/matlab/libs';
        %basePath = '/Users/alex/Documents/Konsult jobb/KTH-ECS/checkout/Matlab/libs';
    end
    properties (Access=protected)
        jarFiles;
        numberOfFiles;
    end
    
    % Adds all JAR files found in basePath to Matlab's 
    % dynamic class path
    %
    % Usage: ClassPathSetter( <dirPath> )
    % if dirPath is empty, basePath (defined above will be used).
    %
    methods(Static)        
        function CPS=ClassPathSetter( path2Jars )
            if nargin ~= 0
                CPS.basePath = path2Jars;
            end
            dpath = javaclasspath;
            for x=1:size(dpath,2)
       
                if (cellfun('isempty',strfind(dpath(x),'se.kth'))==0)
                    disp('Classpath already set')
                    return
                end
            end    
            jarsFullPathNames = CPS.fullPathNames();
            javaaddpath( jarsFullPathNames );
        end        
    end
    methods
        
        function result = fullPathNames( self )
            Utils.checkDirectoryReadable( self.basePath );
            self.jarFiles =  dir(fullfile(self.basePath,'/*.jar'));
            self.numberOfFiles = size(self.jarFiles,1);
            
            result = cell(self.numberOfFiles,1);
            for x = 1:self.numberOfFiles
                result{x} = fullfile(self.basePath,...
                    self.jarFiles(x).name);
            end
        end
                
    end
end                    