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
            list.concatenate( self.ofTypeInport);
            list.concatenate( self.ofTypeOutport);
            list.concatenate( self.ofTypeLine );
        end
        
        function result = size( self )
            result = self.list.size;
        end
        
        function dump( self )
            self.list.dump;
        end
          
        function result = ofTypeLine( self )
            result =  BasicElements.Line.findWithin( self.parent );
        end
        
        function result = ofTypeOutport( self )
            result = BasicElements.Outport.findWithin( self.parent );
        end
        
        function result = ofTypeInport( self )
            result = BasicElements.Inport.findWithin( self.parent );
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
