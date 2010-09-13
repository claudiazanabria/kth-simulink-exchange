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
   Utils.AddToEcoreLibrary(gcb);
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

