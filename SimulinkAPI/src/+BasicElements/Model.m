classdef Model < ProtoObject
    %MODEL The phantom class of a model loaded in memory
    %   
    
    properties
        lines;
    end
    methods (Static)
        
        function checkModelIsLoaded( modelName )
            if ( ~ bdisloaded(modeName) )
                errRecord = MException('Model:InvalidModelName', ...
                    'Model not loaded: %s', modelName);
                throw(errRecord);
            end            
        end
    end
    
    methods
        function self = Model(modelName)
            % Model(rootName) constructs a Model object
            BasicElements.Model.checkModelIsLoaded( modelName );
            %self = self@ProtoObject( modelName );
        end        
       
        function getlines(self)
            if self.lines == null
                self.lines = 5;
            end
        end
    end
    
end

