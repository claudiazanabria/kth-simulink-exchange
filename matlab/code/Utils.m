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
        
        function AddToEcoreLibrary(blockName)
               name=get_param(blockName,'name');
               oldName=blockName;
               oldSystem=get_param(oldName,'Parent');
               newName=Utils.getLibraryName(name);
               open_system(Utils.getLibraryName()); 
               set_param(Utils.getLibraryName(),'Lock','off');
               existingBlocks=find_system(Utils.getLibraryName(), 'SearchDepth', 1,'name', name);
               if (size(existingBlocks,1) > 0) 
               choice = questdlg(['Block exists in ' Utils.getLibraryName() ' library: ', name ], ...
                'Warning', 'Overwrite','Rename','Cancel','Cancel');
            % Handle response
                    switch choice
                        case 'Overwrite'
                            delete_block(newName)
                            add_block(oldName, newName)
                        case 'Rename'
                            newHandle=add_block(oldName, newName, 'MakeNameUnique', 'on');
                            newName=[get_param(newHandle,'Parent') '/' get_param(newHandle,'Name')];
                        case 'Cancel'
                             return
                    end
               else
                   add_block(oldName, newName)    
               end
              set_param(newName, 'BackgroundColor', 'lightblue');
              Utils.processPorts(newName);  
              Utils.setUUID(newName);
              save_system(Utils.getLibraryName);
              replace_block(oldSystem, 'Handle', get_param(oldName,'Handle'), newName, 'noprompt')
        end
        
        function processPorts(blockName)
        %%To be used for all porttypes in future versions (8 in 2009a))
        %
        % Extensions are added to ports. Otherwise duplicate ports will be generated
        % in the transformation back.
            Utils.fixPorts(blockName,'Inport','_In');
            Utils.fixPorts(blockName,'Outport','_Out');
        end

        function fixPorts(Block,Porttype,suffix)
        %%Changes suffix and sets UUID of a port
        Ports = find_system(Block, 'FollowLinks', 'On','BlockType', Porttype);
          for x=1:size(Ports)
              Utils.setUUID(char(Ports(x)));
              Portname=char(get_param(Ports(x),'Name'));
              if (regexp(Portname,[suffix '$'])>0)
                  return
              else
                  set_param([Block '/' Portname],'Name',strcat(Portname,suffix));
              end
          end
        end
        
%         function boolean = isReadableByJava( filePath )
%             file = java.io.File( filePath );
%             test = file.exists();
%             boolean = file.canRead();
%         end
    end

end