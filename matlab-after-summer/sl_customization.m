function sl_customization(cm)
%Use sl_refresh_customizations to apply 
  %% Register custom menu function.
  cm.addCustomMenuFcn('Simulink:FileMenu', @getFileMenuItems);
  cm.addCustomMenuFcn('Simulink:ContextMenu', @getContextMenuItems);
end

%% Define the custom file menu function.
function schemaFcns = getFileMenuItems(callbackInfo) 
  schemaFcns = {@OpenEcoreLib,@OpenEcore,...
						@SaveEcore};
end

%% Define the custom context menu function.
function schemaFcns = getContextMenuItems(callbackInfo) 
  schemaFcns = {@AddToEASTLib};
end

function schema = AddToEASTLib(callbackInfo)
  schema = sl_toggle_schema;
  schema.label = 'Add to Ecore library';   
  schema.callback = @AddToEAST; 
end

function AddToEAST(callbackInfo)
   name=get_param(gcb,'name');
   oldName=gcb;
   oldSystem=gcs;
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

function schema = OpenEcoreLib(callbackInfo)
  schema = sl_action_schema;
  schema.label = 'Open Ecore library';
  schema.userdata = 'item one';	
  schema.callback = @OpenEcoreLibrary; 
end

function OpenEcoreLibrary(callbackInfo)
   open_system(Utils.getLibraryName());
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

