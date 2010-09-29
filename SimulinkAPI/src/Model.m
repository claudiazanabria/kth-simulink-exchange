classdef Model < HandleObject
    %MODEL The phantom class of a model loaded in memory
    %   
    
    properties
    end
    
    methods(Access = private)


    end
    
    
    methods
        function self = Model(modelName)
            %Model constructor
            %   Model(rootName) constructs a Model object
            if (bdisloaded(modeName))
                self.name = modelName;
                self.handle = get_param(modelName,'Handle');
            else
                errRecord = MException('Model:InvalidModelName', ...
                    'Model not loaded: %s', modelName);
                throw(errRecord);
            end
        end
        
    end
    
end

