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
            self.aList = BasicElements.List([1 2 'alex' ]);
        end

        function tearDown(self)
        end

        function testSize(self)
            assertEqual(3,self.aList.size);
        end
        
        function testAccesingAnElement(self)
            assertEqual( 1,self.aList.at(1) );
            assertEqual(1, strcmp('alex',self.aList.at(3)) );
        end
    end    
end
