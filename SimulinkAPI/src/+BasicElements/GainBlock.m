classdef GainBlock < ProtoObject
    
    methods
        function self = GainBlock( identity )
            self = self@ProtoObject( identity );
        end        
       
        function ifGainBlockAddToList( self, aList )
            aList.add( self );            
        end

    end
    
end

