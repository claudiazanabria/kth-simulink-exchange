classdef List < handle
    properties(Access=private)
        elements;
    end
    
    methods
        function self=List( aList )
            %FIXME: Case where aList is a []
            self.elements = aList;
        end
                
        function result = size( self )
            result = length(self.elements);
        end
        
        function result = at(self, position)
            result = self.elements{ position };
        end
        
        function element = atPut(self, position, element)
            self.elements{ position } = element;
        end
        
        function add(self, newElement)
            position = self.size + 1;
            self.atPut(position, newElement);
        end
        
        function result = selectGainBlocks( self )
            result = BasicElements.List( [] );
            for i=1:self.elements.size
                self.elements(i).selectGainBlock( result );
            end
        end
    end
end
