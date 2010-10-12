classdef SystemReference < BasicElements.ProtoObject
    
    properties
        parent
    end
    methods (Static)
        function result = findWithin( parent )
            import BasicElements.SystemReference;
            import BasicElements.List;
            handleList = SystemReference.findCommand( parent.handle );
            list = List( handleList );
            result = list.collectWith( ...
                @SystemReference.convertHandleToClass, parent.handle );
        end
        
        function list = findCommand( ParentHandle )
            list = find_system( ParentHandle, ...
            'regexp', 'on', ...
            'SearchDepth',1, ...
            'FollowLinks','on', ...
            'BlockType','SubSystem', ...            
            'ReferenceBlock','.+' );
        end
        
        function gain = convertHandleToClass( each, parentHandle )
            gain = BasicElements.SystemReference(each, parentHandle);
        end
    end
    
    methods
        function self = SystemReference( identity, parent )
            self = self@BasicElements.ProtoObject( identity );
            self.parent = parent;
        end        
       
        function  aList = ifSystemAddToList( self, aList )
            aList.add( self );            
        end
        
        function str = asString( self )
            %FIXME: part of this str shuld be built by the superclass.
            str = sprintf('SysRef:\t %s (%g)',self.name, self.handle);
        end

    end
    
end

