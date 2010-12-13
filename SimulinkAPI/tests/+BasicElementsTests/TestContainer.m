classdef TestContainer < TestCase
        
    properties(Access=private)
        yorkModel;
    end
    
    methods
        function self = TestContainer(name)
            self = self@TestCase(name);   
        end

        function setUp( self )
            self.yorkModel = BasicElementsTests.YorkModel();
            self.yorkModel.loadModel();
        end
        
        function tearDown( self )
            self.yorkModel.deleteFiles();            
        end

        
        %I'm here
    end
end
