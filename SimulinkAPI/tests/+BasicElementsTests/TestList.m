classdef TestList < TestCase

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
            self.aList = List([1 2 'alex' ]);
        end

        function tearDown(self)
        end

        function testSize(self)
            assertEqual(3,self.aList.size);
        end
        
        function testAccesingAnElement(self)
            assertEqual( 1,self.aList.at(1) );
        end
    end    
end
