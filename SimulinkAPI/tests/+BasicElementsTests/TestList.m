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
    end    
end
