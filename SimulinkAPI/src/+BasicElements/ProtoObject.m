classdef ProtoObject < handle
    %PROTOOBJECT the base class for all Simulink objects with handle
    %   
        
    properties
        identity;
        children;
        mask;
    end
    
    methods
        function self = ProtoObject( name )
            self.identity = BasicElements.SimulinkEntityName( name );
        end  
        
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

