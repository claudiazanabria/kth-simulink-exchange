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
            convertHandleToObjects = @(each) Factory.newChildFromHandle( self.parent, each );
            list = handlelist.collect( convertHandleToObjects );
        end
        
        function result = size( self )
            result = self.list.size;
        end
        
        function result = ofTypeGainBlock( self )
            result = BasicElements.List( [] );
            f = @(list, element) element.ifGainBlockAddToList(list); 
            self.list.injectInto(result, f);
        end
        
    end
    
    methods (Access=private)
        function children = childrenHandleList( self )
            handle = self.parent.handle;
            blocks = BasicElements.SimulinkEnv.findAllBlocksWithin(handle);
            lines = BasicElements.SimulinkEnv.findAllLinesWithin(handle);
            children = [blocks ; lines];
        end
        
    end
end
