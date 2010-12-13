classdef TestLine < TestCase
    
    properties (Access=private)
        yorkModel;
        children;
        line1;
    end
        
    methods
        function self = TestLine(name)
            self = self@TestCase(name);   
        end
   
        function setUp( self )  
            import BasicElements.Model;
            self.yorkModel = BasicElementsTests.YorkModel();
            self.yorkModel.loadModel();
            aModel = Model.from( self.yorkModel.modelName );
            self.children = aModel.children;
            self.line1 = aModel.children.ofTypeLine.first;
        end

        function tearDown(self) 
            self.yorkModel.deleteFiles();
        end

        function testSourceForLine1( self )
            f1 = self.children.findSystemNamed('F1');
            outport1 = f1.children.findOutportNamed('Outport1');
            assertEqual(outport1,self.line1.source);
        end

                        
    end    
end
