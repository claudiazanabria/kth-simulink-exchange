classdef ProtoObject < handle
    %PROTOOBJECT the base class for all Simulink objects with handle
    %   
        
    properties
        identity;
        mask;
    end
    
    methods (Access=protected)
        function self = ProtoObject( identity )
            self.identity = identity;
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
        
    end
end

