classdef ProtoObject < handle
    %PROTOOBJECT the base class for all Simulink objects with handle
    %   
        
    properties
        identity;
        mask;
    end
    
    methods (Access=protected)
        function self = ProtoObject( identityOrHandleOrName )
            self.identity = BasicElements.Identity(identityOrHandleOrName);
        end  
    end
    
    methods
        % Syntax sugar: p.identity.handle = p.handle
        function h = handle(self)
            h = self.identity.handle;
        end
        
        % Syntax sugar: p.identity.name = p.name
        function n = name(self)
            n = self.identity.name;
        end
        
        function selectGainBlocks( self, aList ) %#ok<INUSD,MANU>
        end
    end
end

