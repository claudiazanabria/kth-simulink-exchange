classdef Line < BasicElements.ProtoObject

    %TODO: the name of the line does not show.
    
    properties
        parent
    end
    
    methods (Static)
        function result = findWithin( parent )
            import BasicElements.Line;
            import BasicElements.List;
            handleList = Line.findCommand( parent.handle );
            list = List( handleList );
            result = list.collectWith( ...
                @Line.convertHandleToClass, parent.handle );
        end
        
        function list = findCommand( ParentHandle )
            list = find_system( ParentHandle, ...
            'regexp', 'off', ...
            'SearchDepth',1, ...
            'FollowLinks','on', ...
            'FindAll', 'on', ...
            'Type','Line');
        end
        
        function gain = convertHandleToClass( each, parentHandle )
            gain = BasicElements.Line(each, parentHandle);
        end
    end
    
    methods
        function self = Line( identity, parent )
            self = self@BasicElements.ProtoObject( identity );
            self.parent = parent;
        end
        
        function str = asString( self )
            str = sprintf('Line:\t%s', ...
                asString@BasicElements.ProtoObject(self));
        end
    end
    
end

