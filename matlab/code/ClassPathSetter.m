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