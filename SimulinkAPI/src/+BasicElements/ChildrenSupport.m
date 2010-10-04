classdef ChildrenSupport < handle
    properties (Access=private)
        parent;
        list;
    end
    methods
        function self = ChildrenSupport( parent )
            self.parent = parent;
            self.list = Null();
        end
        
        function result = size( self )
            self.list.initialiseAsListIfEmpty( self.childrenOfParent() );
            result = self.list.size;
        end
    end
    
    methods (Access=private)
        function children = childrenOfParent( self )
            handle = self.parent.handle;
            %TODO: fine tune this command!
            children = find_system(handle);
        end
    end
end
