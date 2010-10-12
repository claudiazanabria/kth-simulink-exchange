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
        
        function dump( self )
            self.list.dump;
        end
                
        function result = ofTypeGainBlock( self )
            result = BasicElements.GainBlock.findWithin( self.parent );
        end
        
        function result = ofTypeSystem( self )
            result = BasicElements.System.findWithin( self.parent );
        end
        
        function result = ofTypeSystemReference( self )
            result = BasicElements.SystemReference.findWithin( self.parent );
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
