classdef MockBlock < BasicElements.ProtoObject
    
    properties
        parent
    end
    
    methods
        function self = MockBlock( identity, parent )
            self = self@BasicElements.ProtoObject( identity );
            self.parent = parent;
        end        
       
        function aList = ifGainBlockAddToList( self, aList ) %#ok<INUSD,MANU>
        end

    end
    
end

