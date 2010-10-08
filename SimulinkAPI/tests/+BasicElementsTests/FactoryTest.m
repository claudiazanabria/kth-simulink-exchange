classdef FactoryTest < TestCase
    
    properties (Access=private)
        yorkModel;
    end
        
    methods
        function self = FactoryTest(name)
            self = self@TestCase(name);   
        end
   
        function setUp( self )                       
            self.yorkModel = BasicElementsTests.YorkModel();
            self.yorkModel.loadModel();
        end

        function tearDown(self) 
            self.yorkModel.deleteFiles();
        end
        
        function testNewGainBlock( self )
        end
    end    
end
