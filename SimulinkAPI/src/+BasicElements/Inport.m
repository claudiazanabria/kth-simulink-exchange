classdef Inport < BasicElements.ProtoObject
    
    properties
        parent
    end
    
    methods (Static)
        function result = findWithin( parent )
            import BasicElements.Inport;
            import BasicElements.List;
            handleList = Inport.findCommand( parent.handle );
            list = List( handleList );
            result = list.collectWith( ...
                @Inport.convertHandleToClass, parent.handle );
        end
        
        function list = findCommand( ParentHandle )
            list = find_system( ParentHandle, ...
            'regexp', 'off', ...
            'SearchDepth',1, ...
            'FollowLinks','on', ...
            'BlockType','Inport');
        end
        
        function gain = convertHandleToClass( each, parentHandle )
            gain = BasicElements.Inport(each, parentHandle);
        end
    end
    
    methods
        function self = Inport( identity, parent )
            self = self@BasicElements.ProtoObject( identity );
            self.parent = parent;
        end
        
        function str = asString( self )
            str = sprintf('Inport:\t%s', ...
                asString@BasicElements.ProtoObject(self));
        end
    end
    
end

