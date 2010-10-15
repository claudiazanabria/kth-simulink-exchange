classdef Outport < BasicElements.ProtoObject
    
    properties
        parent
    end
    
    methods (Static)
        function result = findWithin( parent )
            import BasicElements.Outport;
            import BasicElements.List;
            handleList = Outport.findCommand( parent.handle );
            list = List( handleList );
            result = list.collectWith( ...
                @Outport.convertHandleToClass, parent.handle );
        end
        
        function list = findCommand( ParentHandle )
            list = find_system( ParentHandle, ...
            'regexp', 'off', ...
            'SearchDepth',1, ...
            'FollowLinks','on', ...
            'BlockType','Outport');
        end
        
        function gain = convertHandleToClass( each, parentHandle )
            gain = BasicElements.Outport(each, parentHandle);
        end
    end
    
    methods
        function self = Outport( identity, parent )
            self = self@BasicElements.ProtoObject( identity );
            self.parent = parent;
        end
        
        function str = asString( self )
            str = sprintf('Outport:\t%s', ...
                asString@BasicElements.ProtoObject(self));
        end
    end
    
end

