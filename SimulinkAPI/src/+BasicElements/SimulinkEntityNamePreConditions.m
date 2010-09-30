classdef SimulinkEntityNamePreConditions < TestCase
    methods
        function self = SimulinkEntityNamePreConditions( name )
            self = self@TestCase(name);
        end
        
        function preConditions( aString )
            assertTrue( doesNotStartWithANumber(aString) );
            assertTrue( dosNotContainsSpaces( aString ) );
            assertTrue( notEmpty( aString ) );
        end
        
    end
end
