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
            list = BasicElements.List( {} );
            list.concatenate( self.ofTypeGainBlock );
            list.concatenate( self.ofTypeSystem );
            list.concatenate( self.ofTypeSystemReference );
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
end
