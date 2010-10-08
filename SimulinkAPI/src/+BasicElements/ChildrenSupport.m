classdef ChildrenSupport < handle
    properties (Access=private)
        parent;
    end
    
    properties (Dependent=true)
        list;
    end
    
    methods
        function self = ChildrenSupport( parent )
            self.parent = parent;
        end

        function list = get.list( self )
            import BasicElements.Factory;
            handlelist = BasicElements.List( self.childrenHandleList );
            convertHandleToObjects = @(each) Factory.newChildFromHandle(each, self.parent);
            list = handlelist.collect( convertHandleToObjects );
        end
        
        function result = size( self )
            result = self.list.size;
        end
        
        function result = ofTypeGainBlock( self )
            f = @(list, element) element.ifGainBlockAddToList(list); 
            result = self.injectInto( f );
        end
        
        function result = ofTypeSystem( self )
            f = @(list, element) element.ifSystemAddToList(list); 
            result = self.injectInto( f );
        end

        function result = ofTypeRefBlock( self )
            f = @(list, element) element.ifRefBlockAddToList(list); 
            result = self.injectInto( f );
        end

    end
    
    methods (Access=private)

        function result = injectInto( self, aFunction )
            result = BasicElements.List( {} );
            self.list.injectInto(result, aFunction);
        end
        
        function children = childrenHandleList( self )
            handle = self.parent.handle;
            blocks = BasicElements.SimulinkEnv.findAllBlocksWithin(handle);
            lines = BasicElements.SimulinkEnv.findAllLinesWithin(handle);
            children = [blocks ; lines];
        end
        
    end
end
