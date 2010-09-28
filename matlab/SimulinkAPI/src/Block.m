classdef Block < HandleObject
    %BLOCK Phantom class for Simulink blocks
    %   Detailed explanation goes here
    
    properties
    end
    
    methods
        function self = Block(blockName)
            %Model constructor
            %   Model(rootName) constructs a Model object            
            self.name = modelName;
            self.handle = get_param(blockName,'Handle');
        end
    end
    
end

