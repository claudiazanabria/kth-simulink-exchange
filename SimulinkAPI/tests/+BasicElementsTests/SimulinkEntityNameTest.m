classdef SimulinkEntityNameTest < TestCase
    methods
        function self=SimulinkEntityNameTest( name )
            self=self@TestCase( name );
        end
        
        function testInputShouldNotStartWithANumber(self) %#ok<MANU>
            import BasicElements.SimulinkEntityName;
            exceptionName = 'SimulinkAPI:EntityName:ShouldNotStartWithNumber';
            assertExceptionThrown(SimulinkEntityName('1aNme'), exceptionName);
        end
        
        function testInputShouldNotContainSpaces(self)  %#ok<MANU>
            import BasicElements.SimulinkEntityName;            
            exceptionName = 'SimulinkAPI:EntityName:ShouldNotContainSpaces';
            assertExceptionThrown(SimulinkEntityName('a Name'), exceptionName);
        end
        
        function testInputShouldNotContainSymbols(self)  %#ok<MANU>
            import BasicElements.SimulinkEntityName;            
            exceptionName = 'SimulinkAPI:EntityName:ShouldNotContainSymbols';
            f = @() SimulinkEntityName('a$');
            assertExceptionThrown(f, exceptionName);
            %assertExceptionThrown(SimulinkEntityName('-a'), exceptionName);
            %assertExceptionThrown(SimulinkEntityName('+a'), exceptionName);
            % Expand this list
        end
        
    end
end