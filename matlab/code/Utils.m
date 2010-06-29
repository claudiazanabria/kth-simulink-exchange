%**************************************************************************
%* Copyright (c) 2010 KTH, Mechatronics group and others.
%* All rights reserved. This program and the accompanying materials
%* are made available under the terms of the Eclipse Public License v1.0,
%* which accompanies this distribution, and is available at
%* http://www.eclipse.org/legal/epl-v10.html
%* 
%* Contributors: KTH, Mechatronics group
%**************************************************************************

classdef Utils < handle
    methods (Static)
        function setUserData(block, parameter, value)
        %A method to set UserData properties using containers.Map
        %object
            set_param( block,'UserDataPersistent','on');
            userData = get_param(block,'UserData');
            if strcmp(class(userData),'containers.Map')     
                userData(parameter)=value;
            else
                if ~isempty(userData)
                    warning('Overwriting existing UserData in block "%s"\nUse the containers.Map object to store UserData instead!'...
                    , block)
                end
                %Create a new container
                userData = containers.Map(parameter,value);
            end
            set_param( block, 'UserData', userData );         
        end
        
        function char = getUserData(block, parameter)
            char='';
            if (iscell(block))
                if (block{1}=='/')
                   char ='Error';
                   return
                end
            end
            %A method to get a single UserData value as string from
            %containers.Map objects stored in UserData
            userData = get_param(block,'UserData');
            if strcmp(class(userData),'containers.Map')     
                if userData.isKey(parameter)
                    char = userData(parameter);
                else
                    char = '';
                end    
            else
                if ~isempty(userData)
                    warning('Cannot read UserData stored as %s in block "%s"\nUse the containers.Map object to store UserData instead!'...
                    , class(userData), block)
                    char= '';
                end
            end
        end
 
        
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
        
        function name = extractOnlyRootname( fullpath )
             tokens = textscan(char(fullpath), '%s', 'delimiter', '/');
             name = tokens{1}{ 1 };
        end       
        
        function array = posStr2Array( string )
            array = sscanf(char(string) ,'[%d %d %d %d]')';
        end
        
        function str = posArray2String( posArray )
            str = sprintf('[%d %d %d %d]',char(posArray));
        end
        
        function str = getLibraryName( objectName )
        %Finds the object in the library, and adds a pathname to it
        
            libraryName='FunctionTypes';
            %Somewhat of hard-code, but the user can either use the library file in the
            %/code directory (which is in the path), or a personal FunctionTypes.mdl 
            %located in the CD
            if (nargin == 0)
                str=libraryName;
            else
            %Returns with path    
               str = [libraryName '/' objectName]; 
            end
            
        end
        
        function setUUIDinUserData( fromEObject, toBlockName )
            uuidStr = char(fromEObject.getUuid());
            if ~(strcmp('',uuidStr))
                Utils.setUserData(toBlockName, 'UUID', uuidStr);
            end
        end 
        
        function setUUID( blockName )
            uuidStr = char( java.util.UUID.randomUUID() );
            Utils.setUserData(blockName, 'UUID', uuidStr);            
        end       
        
        function uuidStr = getUUIDfromBlock(blockName)
            uuidStr = Utils.getUserData(blockName, 'UUID');
                if ~isempty( uuidStr )
                    return
                end
            uuidStr = char( java.util.UUID.randomUUID() );
            Utils.setUserData(blockName,'UUID', uuidStr);
        end
        
        function checkSystem (systemName)
            containsBlocks = false; containsReferenceBlocks = false;
            faultyBlocks = '';
            mdlBlks = find_system(systemName, 'SearchDepth',1 );
            for x=1:size(mdlBlks)
               if ~(strcmp(mdlBlks(x),systemName))%Not root system
                   blockType = get_param(mdlBlks(x), 'Blocktype');
                   switch char(blockType)
                        case 'SubSystem'
                            referenceBlockName = get_param(mdlBlks(x),'ReferenceBlock');
                            if ~isempty(char(referenceBlockName))
                                if strcmp(Utils.getLibraryName(),Utils.extractOnlyRootname(referenceBlockName))
                                    containsReferenceBlocks = true;
                                    Utils.checkSystem(mdlBlks);
                                else
                                    containsBlocks=true;
                                    faultyBlocks = [faultyBlocks mdlBlks(x)];
                                end
                            else
                                containsBlocks=true;
                                faultyBlocks = [faultyBlocks mdlBlks(x)];
                            end    
                        case {'Inport','Outport'}
                            return
                        otherwise
                             containsBlocks = true;
                             faultyBlocks = [faultyBlocks mdlBlks(x)];
                    end
               end
            end
            if (containsBlocks && containsReferenceBlocks)
                warndlg(['System' systemName 'contains orphan blocks' faultyBlocks])
            end
        end
        
        
%         function boolean = isReadableByJava( filePath )
%             file = java.io.File( filePath );
%             test = file.exists();
%             boolean = file.canRead();
%         end
    end

end