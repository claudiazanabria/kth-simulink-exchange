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
        
        function identity = from( handleOrNameOrIdentity )
            if ischar( handleOrNameOrIdentity )
                aHandle = get_param(handleOrNameOrIdentity,'Handle');
                identity = BasicElements.Identity( aHandle );
                
            elseif isfloat( handleOrNameOrIdentity )
                BasicElements.Identity.validateHandle(handleOrNameOrIdentity);                
                identity = BasicElements.Identity( handleOrNameOrIdentity );

            elseif isa(handleOrNameOrIdentity,'BasicElements.Identity')
                identity = handleOrNameOrIdentity;
                
            else 
                BasicElements.Identity.throwTypeException();
            end

        end
        
        function throwTypeException()
            error = MException('KTH:WrongArgumentType', ...
                'Argument should be: name, handle or Identity');
            throw( error );
        end
    end
    
    methods (Access=protected)
        function self = Identity( aHandle )
            self.handle = aHandle;
        end
    end
    methods
        function name = get.name(self)
            name = get_param(self.handle,'Name');
        end
        
        function boolean = isIdentity( self ) %#ok<MANU>
            boolean = true;
        end
    end
end

