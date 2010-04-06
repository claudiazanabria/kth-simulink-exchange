function sldemo_bus_counter_bus() 
% SLDEMO_BUS_COUNTER_BUS initializes a set of bus objects in the MATLAB base workspace 

% Bus object: COUNTERBUS 
clear elems;
elems(1) = Simulink.BusElement;
elems(1).Name = 'input';
elems(1).Dimensions = 1;
elems(1).DimensionsMode = 'Fixed';
elems(1).DataType = 'int32';
elems(1).SampleTime = -1;
elems(1).Complexity = 'real';
elems(1).SamplingMode = 'Sample based';

elems(2) = Simulink.BusElement;
elems(2).Name = 'LIMITBUS';
elems(2).Dimensions = 1;
elems(2).DimensionsMode = 'Fixed';
elems(2).DataType = 'LIMITBUS';
elems(2).SampleTime = -1;
elems(2).Complexity = 'real';
elems(2).SamplingMode = 'Sample based';

COUNTERBUS = Simulink.Bus;
COUNTERBUS.HeaderFile = '';
COUNTERBUS.Description = sprintf('');
COUNTERBUS.Elements = elems;
assignin('base', 'COUNTERBUS', COUNTERBUS)

% Bus object: COUNTERBUSOUT 
clear elems;
elems(1) = Simulink.BusElement;
elems(1).Name = 'output';
elems(1).Dimensions = 1;
elems(1).DimensionsMode = 'Fixed';
elems(1).DataType = 'int32';
elems(1).SampleTime = -1;
elems(1).Complexity = 'real';
elems(1).SamplingMode = 'Sample based';

elems(2) = Simulink.BusElement;
elems(2).Name = 'LIMITBUS';
elems(2).Dimensions = 1;
elems(2).DimensionsMode = 'Fixed';
elems(2).DataType = 'LIMITBUS';
elems(2).SampleTime = -1;
elems(2).Complexity = 'real';
elems(2).SamplingMode = 'Sample based';

COUNTERBUSOUT = Simulink.Bus;
COUNTERBUSOUT.HeaderFile = '';
COUNTERBUSOUT.Description = sprintf('');
COUNTERBUSOUT.Elements = elems;
assignin('base', 'COUNTERBUSOUT', COUNTERBUSOUT)

% Bus object: LIMITBUS 
clear elems;
elems(1) = Simulink.BusElement;
elems(1).Name = 'upper_limit';
elems(1).Dimensions = 1;
elems(1).DimensionsMode = 'Fixed';
elems(1).DataType = 'int32';
elems(1).SampleTime = -1;
elems(1).Complexity = 'real';
elems(1).SamplingMode = 'Sample based';

elems(2) = Simulink.BusElement;
elems(2).Name = 'lower_limit';
elems(2).Dimensions = 1;
elems(2).DimensionsMode = 'Fixed';
elems(2).DataType = 'int32';
elems(2).SampleTime = -1;
elems(2).Complexity = 'real';
elems(2).SamplingMode = 'Sample based';

LIMITBUS = Simulink.Bus;
LIMITBUS.HeaderFile = '';
LIMITBUS.Description = sprintf('');
LIMITBUS.Elements = elems;
assignin('base', 'LIMITBUS', LIMITBUS)

