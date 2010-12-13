classdef System < BasicElements.Container
    
    properties
        parent
    end
    methods (Static)
        function result = findWithin( parent )
            import BasicElements.System;
            import BasicElements.List;
            handleList = System.findCommand( parent.handle );
            list = List( handleList );
            result = list.collectWith( ...
                @System.convertHandleToClass, parent.handle );
        end
        
        function list = findCommand( ParentHandle )
            list = find_system( ParentHandle, ...
            'regexp', 'off', ...
            'SearchDepth',1, ...
            'FollowLinks','on', ...
            'BlockType','SubSystem', ...
            'ReferenceBlock','' );
        end
        
        function gain = convertHandleToClass( each, parentHandle )
            gain = BasicElements.System(each, parentHandle);
        end
    end
    
    methods
        function self = System( identity, parent )
            self = self@BasicElements.Container( identity );
            self.parent = parent;
        end        
       
        function  aList = ifSystemAddToList( self, aList )
            aList.add( self );            
        end
        
        function str = asString( self )
            str = sprintf('System:\t%s', ...
                asString@BasicElements.ProtoObject(self));
        end

    end
    
end

