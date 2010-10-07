classdef Null
    methods
        function self=Null()
        end
        
        function list = initialiseAsListIfEmpty(self, aList) %#ok<MANU>
            list = BasicElements.List( aList );
        end
    end
end
