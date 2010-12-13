classdef Container < BasicElements.ProtoObject
    properties
        children;
    end
    
    methods
        function self = Container( identity )
            self = self@BasicElements.ProtoObject( identity );
            self.children = BasicElements.ChildrenSupport( self );            
        end        

        function result = findSystemNamed( self, name )
            list = BasicElements.System.findWithin( self.handle );
            result = Container.filterByName( list, name );
        end
        
        function result = findOutportNamed( self, name )
            list = BasicElements.Outport.findWithin( self.handle );
            result = Container.filterByName( list, name );
        end

        function result = findInportNamed( self, name )
            list = BasicElements.Inport.findWithin( self.handle );
            result = Container.filterByName( list, name );
        end
        
    end
    
    methods (Access=private, Static)
        function result = filterByName( list, name )
            elementsNamed = @(element, aName) element.identity.hasSameName( aName );
            result = list.collectWith(elementsNamed, name).first;
        end

    end
end