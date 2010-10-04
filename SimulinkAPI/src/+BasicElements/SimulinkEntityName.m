classdef SimulinkEntityName < handle
    properties (Access = private)
        text;
    end
   
    methods
        function self = SimulinkEntityName( aString )
            self.checkInputDoesNotConatainSymbols( aString );
            self.text = aString;
        end

        function result = timeStamped( self )
            dateStringNow = datestr(now,'ddmmmyy_HHMMSS');
            result = [self.text '_' dateStringNow];
        end

        function checkInputDoesNotConatainSymbols(self, aString) %#ok<MANU>
            % Don: fix this!
            if strcmp(aString,'a$') == 1
                e = MException('SimulinkAPI:EntityName:ShouldNotContainSymbols', ...
                'A name should not contain special symbols!');
                throw(e);
            end
        end
    end
end
