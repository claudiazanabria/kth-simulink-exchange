classdef TestSimulinkEnv < TestCase
        
    properties(Access=private)
        yorkModel
    end
    
    methods
        function self = TestSimulinkEnv(name)
            self = self@TestCase(name);   
        end

        function setUp( self )
            BasicElements.SimulinkEnv.closeAllSystems();   
            self.yorkModel = BasicElementsTests.YorkModel();
            self.yorkModel.loadAll();
        end
        
        function tearDown( self )
            self.yorkModel.deleteFiles();            
        end
        
        function testCloseAllSystems( self ) %#ok<MANU>
            BasicElements.SimulinkEnv.closeAllSystems();
            list = find_system();
            assertEqual(0, length(list) );            
        end
        
        function testFindAllOpenedModelNames( self ) %#ok<MANU>
            list = BasicElements.SimulinkEnv.findAllOpenedModelNames();
            assertEqual(2, length(list) );
        end
        
        function testFindAllLinesWithin( self ) %#ok<MANU>
            handle = get_param(self.yorkModel.modelName,'Handle');
            list = BasicElements.SimulinkEnv.findAllLinesWithin(handle);
            assertEqual(2, length(list) );
        end
        
        function testFindAllBlocksWithin( self ) %#ok<MANU>
            handle = get_param(self.yorkModel.modelName,'Handle');
            list = BasicElements.SimulinkEnv.findAllBlocksWithin(handle);
            assertEqual(3, length(list) );
        end
    end    
end
