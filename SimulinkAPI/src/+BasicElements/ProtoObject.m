classdef ProtoObject < handle
    %PROTOOBJECT the base class for all Simulink objects with handle
    %   
        
    properties
        identity;
        mask;
    end
    
    methods (Access=protected)
        function self = ProtoObject( identityOrHandleOrName )
            import BasicElements.Identity;
            self.identity = Identity.from(identityOrHandleOrName);
        end  
    end
    
    methods
        
        function str = asString( self )
            str = sprintf('%s (%g)',self.name, self.handle);
        end
        
        function dump( self )
            disp(self.asString);
        end
        
        % Syntax sugar: p.identity.handle = p.handle
        function h = handle(self)
            h = self.identity.handle;
        end
        
        % Syntax sugar: p.identity.name = p.name
        function n = name(self)
            n = self.identity.name;
        end
        
        function aList = ifGainBlockAddToList( self, aList ) %#ok<INUSD,MANU>
        end
        
        function aList = ifSystemAddToList( self, aList )  %#ok<INUSD,MANU>
        end
        
        function aList = ifRefBlockAddToList( self, aList )  %#ok<INUSD,MANU>
        end
    end
end

