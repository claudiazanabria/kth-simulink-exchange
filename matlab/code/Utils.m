classdef Utils < handle
    methods (Static)
      
        function boolean = isMDLFileReadable( path2mdlFile )
            boolean = (exist(path2mdlFile,'file') == 4);
        end        
        
        function boolean=isNameInList( name, list )
            for x=1:size( list )
                if strcmp(list(x), name)
                    boolean = true;
                    return;
                end
            end
            boolean = false;
        end

        function boolean = isDirectoryReadable( path )
            boolean = (exist(path,'dir') == 7);
        end
                
        function checkDirectoryReadable( dirPath )
            if (~Utils.isDirectoryReadable( dirPath ))
                errRecord = MException('Utils:InvalidDirPath', ...
                    'Directory not readable: %s', dirPath);
                throw(errRecord);
            end
        end

        function checkMDLFileReadable( mdlFilePath )
            if (~Utils.isMDLFileReadable( mdlFilePath ))
                errRecord = MException('Utils:InvalidFilePath', ...
                    'File not readable: %s', mdlFilePath);
                throw(errRecord);
            end
        end

        function boolean = blockIsModelReference( block )
            bType = get_param( block, 'BlockType');
            boolean = strcmp(bType, 'ModelReference')==1;
        end
        
        function [modelName handle] = getHandleForModelReference( instanceHandle )
            modelName = get_param(instanceHandle,'ModelName');
            load_system( modelName );
            handle = get_param(modelName, 'Handle');            
        end

        function name = extractOnlyName( fullpath )
             tokens = textscan(char(fullpath), '%s', 'delimiter', '/');
             lastToken = size(tokens{1});
             name = tokens{1}{ lastToken };
        end
        
        function array = posStr2Array( string )
            array = sscanf(char(string) ,'[%d %d %d %d]')';
        end
        
        function str = posArray2String( posArray )
            str = sprintf('[%d %d %d %d]',char(posArray));
        end
        
        function setUUIDinUserData( fromEObject, toBlockName )
            uuidStr = char(fromEObject.getUuid());
            Utils.createUUIDinBlock( uuidStr, toBlockName );            
        end        
        
        function uuidStr = getUUIDfromBlock( blockName )
            userData = get_param(blockName,'UserData');
            if ~isempty( userData )
                uuidStr = userData('UUID');
                if ~isempty( uuidStr )
                    return
                end
            end
            uuidStr = char( java.util.UUID.randomUUID() );
            Utils.createUUIDinBlock( uuidStr, blockName );
        end
        
%         function boolean = isReadableByJava( filePath )
%             file = java.io.File( filePath );
%             test = file.exists();
%             boolean = file.canRead();
%         end
    end
    methods (Static, Access=private)
        function createUUIDinBlock( uuidStr, block )
            % FIXME: This function will overwrite the contents of the Map
            set_param( block,'UserDataPersistent','on');            
            userData = containers.Map({'UUID'},{uuidStr} );
            set_param( block, 'UserData', userData );            
        end
    end
end