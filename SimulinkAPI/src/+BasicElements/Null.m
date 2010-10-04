classdef Null < handle
    methods
        function self=Null()
        end
        
        function list = initialiseAsListIfEmpty(self, aList) %#ok<MANU>
            list = List( aList );
        end
    end
end
