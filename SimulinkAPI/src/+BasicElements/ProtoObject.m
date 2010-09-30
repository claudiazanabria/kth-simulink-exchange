classdef ProtoObject < handle
    %PROTOOBJECT the base class for all Simulink objects with handle
    %   
    
    properties (Access = private)
        entityName
    end
    
    properties
        name; % syntax sugar, only for convenice.
        handle;
    end
    
    methods
        function self = ProtoObject( name )
            self.entityName = SimulinkEntityName( name );
            self.name = self.entityName.string;
            self.handle = get_param(name,'Handle');            
        end        
    end
end

