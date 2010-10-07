classdef ChildrenSupport < handle
    properties (Access=private)
        parent;
        list;
    end
    methods
        function self = ChildrenSupport( parent )
            self.parent = parent;
            self.list = BasicElements.Null();
        end
        
        function result = size( self )
            self.list = self.list.initialiseAsListIfEmpty( self.childrenOfParent() );
            result = self.list.size;
        end
    end
    
    methods (Access=private)
        function children = childrenOfParent( self )
            handle = self.parent.handle;
            blocks = BasicElements.SimulinkEnv.findAllBlocksWithin(handle);
            lines = BasicElements.SimulinkEnv.findAllLinesWithin(handle);
            children = [blocks ; lines];
        end
        
    end
end
