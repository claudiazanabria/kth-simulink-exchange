function char = timeStamp( input_name )
%TIMESTAMP Creates a time-stamped name
%   Detailed explanation goes here
temp=clock;
foo = [input_name date '-' num2str(temp(4)) '-' num2str(temp(5)) '-' num2str(temp(6))];
%'-' and '.' not allowed in matlab names
foo = strrep(foo, '-', '');
char = strrep(foo, '.', '');


end

