classdef GainBlock < BasicElements.ProtoObject
    
    properties
        parent
    end
    
    methods (Static)
        function result = findWithin( parent )
            import BasicElements.GainBlock;
            import BasicElements.List;
            handleList = GainBlock.findCommand( parent.handle );
            list = List( handleList );
            result = list.collectWith( ...
                @GainBlock.convertHandleToClass, parent.handle );
        end
        
        function list = findCommand( ParentHandle )
            list = find_system( ParentHandle, ...
            'regexp', 'off', ...
            'SearchDepth',1, ...
            'FollowLinks','on', ...
            'BlockType','Gain');
        end
        
        function gain = convertHandleToClass( each, parentHandle )
            gain = BasicElements.GainBlock(each, parentHandle);
        end
    end
    
    methods
        function self = GainBlock( identity, parent )
            self = self@BasicElements.ProtoObject( identity );
            self.parent = parent;
        end        
               
        function str = asString( self )
            str = sprintf('Gain:\t%s', ...
                asString@BasicElements.ProtoObject(self));
        end

    end
    
end

