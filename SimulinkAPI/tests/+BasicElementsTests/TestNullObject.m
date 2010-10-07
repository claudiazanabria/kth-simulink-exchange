classdef TestNullObject < TestCase
    methods
        function self=TestNullObject(name)
            self=self@TestCase(name);
        end
        
        function testInitialiseAsListIfEmpty(self) %#ok<MANU>
            n = BasicElements.Null();
            array = [1 2 3];
            n.initialiseAsListIfEmpty( array );
            assertTrue(lentgth(array), n.size);
        end
    end
end
