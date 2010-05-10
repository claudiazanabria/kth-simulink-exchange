function sl_customization2(cm)
%Use sl_refresh_customizations to apply NOT FINISHED/CJS
  %% Register custom menu function.
  cm.addCustomMenuFcn('Simulink:FileMenu', @getMyMenuItems);
end

%% Define the custom menu function.
function schemaFcns = getMyMenuItems(callbackInfo) 
  schemaFcns = {@OpenEcore,...
						@SaveEcore}
end

%% Define the schema function for first menu item.
function schema = OpenEcore(callbackInfo)
  schema = sl_action_schema;
  schema.label = 'Open .simulink file...';
  schema.userdata = 'item one';	
  schema.callback = @FileSelectOpen; 
end

function FileSelectOpen(callbackInfo)
  disp(uigetfile({'*.simulink','Simulink Ecore (*.simulink)'}))
end

function schema = SaveEcore(callbackInfo)
  schema = sl_action_schema;
  schema.label = 'Save .simulink file...';
  schema.userdata = 'item two';	
  schema.callback = @FileSelectSave; 
end

function FileSelectSave(callbackInfo)
%NOT WORKING
  EcoreCreator.fromFile(uiputfile({'*.simulink','Simulink Ecore (*.simulink)'}))
end
