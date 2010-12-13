classdef TestList < TestCase

    % check constructin with empty array.
    properties
        aList;
    end
    
    properties(Constant)
    end
    
    methods
        function self = TestList(name)
            self = self@TestCase(name);
        end

        function setUp(self)
            aCell = {1 2 'alex'};
            self.aList = BasicElements.List( aCell );
        end

        function testSize(self)
            assertEqual(3,self.aList.size);
        end
        
        function testAccesingAnElement(self)
            assertEqual( 1, self.aList.at(1) );
            assertEqual('alex', self.aList.at(3) );
        end
                
        function testAtWithWorngIndex( self )         
            f = @() self.aList.at(5);
            assertExceptionThrown(f, 'MATLAB:badsubscript');
        end
        
        function testAdd(self)
            self.aList.add(42);
            assertEqual(42, self.aList.at(4));
        end
        
        function testAtPut( self )
            self.aList.atPut(2,42);
            assertEqual(42, self.aList.at(2));
            assertEqual(3, self.aList.size);
        end
        
        function testInjectIntoOne( self ) %#ok<MANU>
            list =  BasicElements.List( {2 3 5} );
            sum = 0;
            formula = @(subTotal, element) subTotal + element;
            sum = list.injectInto(sum, formula);
            assertEqual(10,sum);            
        end

        function testInjectIntoTwo( self ) %#ok<MANU>
            list =  BasicElements.List( {'a' 'b' 'c'} );
            text = '';
            concatenateString = @(line, element) strcat(line,element);
            text = list.injectInto(text, concatenateString );
            assertEqual('abc',text);            
        end

        function testAsCells( self )
            assertEqual({1 2 'alex'}, self.aList.asCells);
        end
        
        %TODO: create tests for do and doWith
        
        function testCollect( self ) %#ok<MANU>
            list =  BasicElements.List( {2 6 8} );
            addOne = @(element) element + 1;
            result = list.collect( addOne );
            assertEqual({3 7 9},result.asCells);            
        end

        function testCollectWith( self ) %#ok<MANU>
            list =  BasicElements.List( {2 6 8} );
            addOne = @(element, arg1) element + arg1;
            result = list.collectWith( addOne, 3 );
            assertEqual({5 9 11},result.asCells);            
        end

        function testEmptyListCreation( self ) %#ok<MANU>
            list = BasicElements.List( {} );
            assertEqual(0, list.size);            
        end
        
        function testEmptyListCreationFromArray( self ) %#ok<MANU>
            list = BasicElements.List( [] );
            assertEqual(0, list.size);    
        end
        
        function testListCreationFromArray( self ) %#ok<MANU>
            list = BasicElements.List( [1 4 6] );
            assertEqual(3, list.size);                    
        end
        
        function testNewEmptyList( self )
            list = BasicElements.List.newEmptyList();
            assertEqual(0, list.size);
        end
        
        function testConcatenate( self )
            list2 = BasicElements.List({9 3 1});
            self.aList.concatenate( list2 );
            assertEqual(6, self.aList.size);
            assertEqual({1 2 'alex' 9 3 1}, self.aList.asCells);
        end
        
        function testfirst( self )
            assertEqual(1,self.aList.first);
        end
    end    
end
