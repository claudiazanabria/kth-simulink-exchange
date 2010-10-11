classdef GainBlock < BasicElements.ProtoObject
    
    properties
        parent
    end
    
    methods
        function self = GainBlock( identity, parent )
            self = self@BasicElements.ProtoObject( identity );
            self.parent = parent;
        end        
       
        function  aList = ifGainBlockAddToList( self, aList )
            aList.add( self );            
        end
        
        function str = asString( self )
            str = sprintf('Gain:\t%s', ...
                asString@BasicElements.ProtoObject(self));
        end

    end
    
end

