classdef Model < BasicElements.Container
    %MODEL The phantom class of a model loaded in memory
    %   
        
    methods (Static)
        
        function model=from( loadedModelName )
            import BasicElements.Model;
            Model.checkModelIsLoaded( loadedModelName );
            model = Model( loadedModelName );
        end
        
        function checkModelIsLoaded( modelName )
            if ( ~ bdIsLoaded(modelName) )
                errRecord = MException('Model:InvalidModelName', ...
                    'Model not loaded: %s', modelName);
                throw(errRecord);
            end            
        end
    end
    
    methods (Access=private)
        function self = Model( identityOrHandleOrName )
            self = self@BasicElements.Container(identityOrHandleOrName);
        end        
       
    end
    
end

