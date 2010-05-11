function sl_customization(cm)
%Use sl_refresh_customizations to apply NOT FINISHED/CJS
  %% Register custom menu function.
  cm.addCustomMenuFcn('Simulink:FileMenu', @getMyMenuItems);
end

%% Define the custom menu function.
function schemaFcns = getMyMenuItems(callbackInfo) 
  schemaFcns = {@OpenEcore,...
						@SaveEcore};
end

%% Define the schema function for first menu item.
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
