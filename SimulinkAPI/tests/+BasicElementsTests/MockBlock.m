classdef MockBlock < BasicElements.ProtoObject
    
    properties
        parent
    end
    
    methods
        function self = MockBlock( identity, parent )
            self = self@BasicElements.ProtoObject( identity );
            self.parent = parent;
        end
        
        function str = asString( self )
            %FIXME: part of this str shuld be built by the superclass.
            str = sprintf('Mock:\t %s (%g)',self.name, self.handle);
        end
       
    end
    
end

