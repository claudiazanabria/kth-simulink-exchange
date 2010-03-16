% Adds JARs to class path
classdef ClassPathSetter
    % aca tambien
    properties(Constant)
        basePath = 'F:/Documents/MATLAB/libs';
        jarFiles    = ClassPathSetter.jarFileNames();
        numberOfFiles = ClassPathSetter.amountOfFiles();
    end
    
    % Adds all JAR files found in basePath to Matlab's 
    % dynamic class path
    %
    % Usage: ClassPathSetter.setJarsInDynamicClassPath()
    methods(Static)
        function setJarsInDynamicClassPath
            javaaddpath( ClassPathSetter.fullPathNames() );
        end
        
    end

    %
    % Private methods
    methods(Static, Access=private)
        function boolean = isBasePathReadable()
            boolean = (exist(ClassPathSetter.basePath,'dir') == 7);
        end
                
        function jars = jarFileNames()
            jars = dir(fullfile(ClassPathSetter.basePath,'/*.jar'));
        end

        function checkBasePath
            if (~ClassPathSetter.isBasePathReadable())
                errRecord = MException('ClassPathSetter:InvalidBasePath', ...
                    'Base path not readable: %s', ClassPathSetter.basePath);
                throw(errRecord);
            end
        end
        
        function result = fullPathNames()
            ClassPathSetter.checkBasePath();
            
            result = cell(ClassPathSetter.numberOfFiles,1);
            for x = 1:ClassPathSetter.numberOfFiles
                result{x} = fullfile(ClassPathSetter.basePath,...
                    ClassPathSetter.jarFiles(x).name);
            end
        end
        
        function result = amountOfFiles()
            result = size(ClassPathSetter.jarFiles,1);
        end
    end    
end                    