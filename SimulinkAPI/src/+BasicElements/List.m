classdef List < handle
    properties(Access=private)
        elements;
    end
    
    methods (Static)
        function list = newWithSize( size )
            list = BasicElements.List( cell(1,size) );
        end  
        
        function list = newEmptyList()
            list = BasicElements.List({});
        end        
        
    end
    
    methods
        function self=List( aList )
            import BasicElements.List;
            if iscell( aList )
                self.elements = aList;
            else
                self.elements = List.cellsFomArray( aList );
            end
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
        
        function result = collect( self, aFunction )
            result = BasicElements.List.newWithSize( self.size );
            for i = 1:self.size;
                result.atPut(i, aFunction( self.at(i) ));
            end            
        end

        function do( self, aFunction )
            for i = 1:self.size;
                aFunction( self.at(i) );
            end            
        end
        
        function cells = asCells( self )
            cells = cell(1,self.size);
            for i = 1:self.size;
                cells{i} = self.at(i);
            end            
        end
        
        function result = injectInto(self, startValue, aFunction)
            result = startValue;
            for i = 1:self.size;
                result = aFunction(result, self.at(i));
            end
        end
        
        function dump( self )
            f = @(each) each.dump;
            self.do( f );
            fprintf('%i %s\n', self.size, ' elements.');
        end
    end
    
    methods (Static, Access=private)
        function cells = cellsFomArray( array )
            size = length(array);
            cells = cell( 1,size );
            for i=1:size
                cells{i} = array(i);
            end
        end
    end
end
