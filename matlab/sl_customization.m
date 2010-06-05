function sl_customization(cm)
%Use sl_refresh_customizations to apply 
  %% Register custom menu function.
  cm.addCustomMenuFcn('Simulink:FileMenu', @getFileMenuItems);
  cm.addCustomMenuFcn('Simulink:ContextMenu', @getContextMenuItems);
end

%% Define the custom menu function.
function schemaFcns = getFileMenuItems(callbackInfo) 
  schemaFcns = {@OpenEcoreLib,@OpenEcore,...
						@SaveEcore};
end


function schemaFcns = getContextMenuItems(callbackInfo) 
  schemaFcns = {@AddToEASTLib};

end

function schema = ToggleTest(callbackInfo)
   schema = sl_toggle_schema;
  schema.label = 'EAST';
  tmp=get_param(gcb, 'ForegroundColor');
  if strcmp(tmp, 'red') == 1
    schema.checked = 'checked';
  else
    schema.checked = 'unchecked';
  end
  schema.callback = @ToggleEASTAction; 
end

function schema = AddToEASTLib(callbackInfo)
  schema = sl_toggle_schema;
  schema.label = 'Add to EAST library';   
  schema.callback = @AddToEAST; 
end

function AddToEAST(callbackInfo)
%BROKEN FOR (SOME) BLOCKS THAT EXIST
    FunctionTypesFile='FunctionTypes';
%Somewhat of hard-code, but the user can either use the library file in the
%/code directory (which is in the path), or a personal FunctionTypes.mdl 
%located in the CD
   name=get_param(gcb,'name');
   oldName=gcb;
   oldSystem=gcs;
   newName=[FunctionTypesFile '/' name];
   open_system(FunctionTypesFile); 
   set_param(FunctionTypesFile,'Lock','off');
   existingBlocks=find_system(FunctionTypesFile, 'SearchDepth', 1,'name', name);
   if (size(existingBlocks,1) > 0) 
   choice = questdlg(['Block exists in FunctionType library: ', name ], ...
	'Warning', 'Overwrite','Rename','Cancel','Cancel');
% Handle response
        switch choice
            case 'Overwrite'
                delete_block(newName)
                add_block(oldName, newName)
            case 'Rename'
                newHandle=add_block(oldName, newName, 'MakeNameUnique', 'on');
                %'Ugly method, but it should work?
                newName=[get_param(newHandle,'Parent') '/' get_param(newHandle,'Name')];
            case 'Cancel'
                 return
        end
   else
       add_block(oldName, newName)    
   end
  set_param(newName, 'BackgroundColor', 'lightblue');
 
  
  %Inports = find_system(gcb, 'FollowLinks', 'On','BlockType', 'Inport');
  %for x=1:size(Inports)
  %    Portname=char(get_param(Inports(x),'Name'));
  %    if (regexp(Portname,'_In$')>0)
  %        return
  %    else
  %        set_param([newName '/' Portname],'Name',strcat(Portname,'_In'));
  %    end        
  %end
  
%   Outports = find_system(gcb, 'FollowLinks', 'On','BlockType', 'Outport');
% 
%   for x=1:size(Outports)
%       Portname=char(get_param(Outports(x),'Name'));
%       if (regexp(Portname,'_Out$')>0)
%           return
%       else
%           set_param([newName '/' Portname],'Name',strcat(Portname,'_Out'));
%       end        
%   end

  processPorts(newName);  
  Utils.setUUID(newName);
  replace_block(oldSystem, 'Handle', get_param(oldName,'Handle'), newName, 'noprompt')
end

function processPorts(Block)
%%To be used for all porttypes in future versions (8 today)
%
% Extensions are added to ports. Otherwise duplicate ports will be generated
% in the transformation back.
    fixPorts(Block,'Inport','_In');
    fixPorts(Block,'Outport','_Out');
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

function ToggleEASTAction(callbackInfo)
    if strcmp(get_param(gcb, 'ForegroundColor'), 'red') == 0
        set_param(gcb, 'ForegroundColor', 'red');
    else
        set_param(gcb, 'ForegroundColor', 'white');
    end
end

function schema = OpenEcoreLib(callbackInfo)
  schema = sl_action_schema;
  schema.label = 'Open Ecore library';
  schema.userdata = 'item one';	
  schema.callback = @OpenEcoreLibrary; 
end

function OpenEcoreLibrary(callbackInfo)
   open_system('FunctionTypes')
end


function schema = OpenEcore(callbackInfo)
  schema = sl_action_schema;
  schema.label = 'Open .simulink file...';
  schema.userdata = 'item one';	
  schema.callback = @FileSelectOpen; 
end

function FileSelectOpen(callbackInfo)
  [filename, pathname] = uigetfile({'*.simulink','Simulink Ecore (*.simulink)'},'Open Ecore file');
  if ~(isequal(filename,0) || isequal(pathname,0))   
    ModelCreatorRef.fromFile(fullfile(pathname,filename))
  end
end

function schema = SaveEcore(callbackInfo)
  schema = sl_action_schema;
  schema.label = 'Save .simulink file...';
  schema.userdata = 'item two';	
  schema.callback = @FileSelectSave; 
end

function FileSelectSave(callbackInfo)
%User has to be in CD of system. Perhaps solvable
%using get_param(gcs,'FileName')?
  [filename, pathname] = uiputfile({'*.simulink','Simulink Ecore (*.simulink)'},'Save Ecore file' , gcs);
  if ~(isequal(filename,0) || isequal(pathname,0))   
    EcoreCreatorRef.fromModel(gcs, fullfile(pathname,filename))
  end
end

