classdef List < handle
    properties(Access=private)
        elements;
    end
    
    methods
        function self=List( aList )
            self.elements = aList;
        end
        
        function self=initialiseAsListIfEmpty( self, aList ) %#ok<INUSD>
        end
        
        function result = size( self )
            result = length(self.elements);
        end
        
        function result = at(self, position)
            result = self.elements( position );
        end
    end
end
