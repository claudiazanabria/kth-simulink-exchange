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
            %FIXME: part of this str shuld be built by the superclass.
            str = sprintf('Gain:\t %s (%g)',self.name, self.handle);
        end

    end
    
end

