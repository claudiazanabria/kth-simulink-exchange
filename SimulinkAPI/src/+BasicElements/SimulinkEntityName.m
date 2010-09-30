classdef SimulinkEntityName
    properties (Access = private)
        string;
    end
   
    methods
        function self = SimulinkEntityName( aString )
            %tc = SimulinkEntityNamePreConditions( aString );
            %tc.runIt();
            
            self.string = aString;
        end

        function result = timeStamped( self )
            dateStringNow = datestr(now,'ddmmmyy_HHMMSS');
            result = [self.string '_' dateStringNow];
        end

    end
end
