function sl_customization(cm)
%Use sl_refresh_customizations to apply NOT FINISHED/CJS
  %% Register custom menu function.
  cm.addCustomMenuFcn('Simulink:FileMenu', @getFileMenuItems);
  cm.addCustomMenuFcn('Simulink:ContextMenu', @getContextMenuItems);
end

%% Define the custom menu function.
function schemaFcns = getFileMenuItems(callbackInfo) 
  schemaFcns = {@OpenEcore,...
						@SaveEcore};
end


function schemaFcns = getContextMenuItems(callbackInfo) 
  schemaFcns = {@ToggleEAST};
end

%% Define the schema function for first menu item.
function schema = ToggleEAST(callbackInfo)
   schema = sl_toggle_schema;
  schema.label = 'EAST';
  tmp=get_param(gcb, 'ForegroundColor')
  if strcmp(tmp, 'red') == 1
    schema.checked = 'checked';
  else
    schema.checked = 'unchecked';
  end
  schema.callback = @ToggleEASTAction; 
end

function ToggleEASTAction(callbackInfo)
    if strcmp(get_param(gcb, 'ForegroundColor'), 'red') == 0
        set_param(gcb, 'ForegroundColor', 'red');
    else
        set_param(gcb, 'ForegroundColor', 'white');
    end
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
    ModelCreator.fromFile(fullfile(pathname,filename))
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
    EcoreCreator.fromFile(gcs, fullfile(pathname,filename))
  end
 end
