classdef GainBlock < BasicElements.ProtoObject
    
    properties
        parent
    end
    
    methods (Static)
        function result = findWithin( parent )
            import BasicElements.GainBlock;
            import BasicElements.List;
            handleList = GainBlock.findCommand( parent.handle);
            list = List( handleList );
            result = list.collect( @GainBlock.convertHandleToClass );
        end
        
        function list = findCommand( ParentHandle )
            list = find_system( ParentHandle, ...
            'SearchDepth',1, ...
            'FollowLinks','on', ...
            'BlockType','Gain');
        end
        
        function gainBlockClass = convertHandleToClass( handle )
            import BasicElements.GainBlock;
            gainBlockClass = GainBlock(handle, %parent !?!)
        end
    end
    
    methods
        function self = GainBlock( identity, parent )
            self = self@BasicElements.ProtoObject( identity );
            self.parent = parent;
        end        
       
        function  aList = ifGainBlockAddToList( self, aList )
            aList.add( self );            
        end
        
        function str = asString( self )
            str = sprintf('Gain:\t%s', ...
                asString@BasicElements.ProtoObject(self));
        end

    end
    
end

