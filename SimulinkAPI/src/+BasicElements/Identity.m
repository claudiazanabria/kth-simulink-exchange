classdef Identity < handle
        
    properties
        handle;
    end
    
    properties (Dependent = true)
        name;
    end
    
    methods (Static)
        function validateHandle( handle )
            % This will trow an exception if handle is invalid.
            get_param(handle,'Handle');
        end
    end
    
    methods
        function self = Identity( handleOrName )
            if ischar( handleOrName )
                self.handle = get_param(handleOrName,'Handle');
            elseif isnumeric( handleOrName )
                BasicElements.Identity.validateHandle(handleOrName);
                self.handle = handleOrName;
            else
                BasicElements.Identity.throwWrongArgumentType();
                error = MException('KTH:WrongArgumentType', ...
                    'Argument should be an elements name or handle');
                throw( error );
            end
        end
        
        function name = get.name(self)
            name = get_param(self.handle,'Name');
        end
        
    end
end

