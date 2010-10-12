classdef SupportedBlockTypes < handle
    properties
        list;
    end
    methods (Access=protected)
        function self = SupportedBlockTypes()
        end
    end
    methods (Static)
        function self = asList()
            import BasicElements.*;
            self = SupportedBlockTypes();
            self.list = List({...
                @GainBlock.findCommand( a ) ...
                @System.findCommnad() ...
            });
        end
    end
end