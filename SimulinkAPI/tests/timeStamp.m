%TIMESTAMP Creates a time-stamped message
%  example: 
function string = timeStamp( message )
    dateStringNow = datestr(now,'dd-mmm-yy HH:MM:SS');
    string = [message ' @' dateStringNow];
end

