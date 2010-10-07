classdef TestModel < TestCase
    
    properties (Access=private)
        yorkModel;
        aModel;
    end
        
    methods
        function self = TestModel(name)
            self = self@TestCase(name);   
        end
   
        function setUp( self )            
            import BasicElements.Model;
            self.yorkModel = BasicElementsTests.YorkModel();
            self.yorkModel.loadModel();
            self.aModel = Model.from( self.yorkModel.modelName );
        end

        function tearDown(self) 
            self.yorkModel.deleteFiles();
        end

        function testGetChildren( self )
            children = self.aModel.children;
            assertEqual(5,children.size );            
            assertEqual(1,children.ofTypeGainBlock );
            assertEqual(1,children.ofTypeSystem );
            assertEqual(1,children.ofTypeRefBlock );
        end
        
%         function testModelContainmentWithName( self )
%             assertTrue( self.aModel.contains( self.yorkModel.F2Name ) );
%             assertFalse( self.aModel.contains( self.yorkModel.wrongName ));
%             block = self.aModel.child( self.yorkModel.F2Name );
%             assertEquals(self.yorkModel.F2UUID, block.UUID );
%         end
%         
%         function testModelContainmentWithUUID( self )
%             assertTrue( self.aModel.contains( self.yorkModel.F2UUID ) );
%             assertFalse( self.aModel.contains( self.yorkModel.UUID ));
%             block = self.aModel.child( self.yorkModel.F2UUID );
%             assertEquals(self.yorkModel.F2Name, block.name );            
%         end
%         
%         function testFindCorrectLine(self)
% %             line1 = self.aModel.lines( self.yorkModel.line1UUID );
% %             assertEqual(self.yorkModel.RF1OutportUUID, line1.source.UUID);
%         end
                        
    end    
end
