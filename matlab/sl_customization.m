function sl_customization2(cm)
%See Simlink docks how to use NOT FINISHED/CJS
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

function myCallback2(callbackInfo)
  disp(uiputfile({'*.simulink','Simulink Ecore (*.simulink)'}))
end
