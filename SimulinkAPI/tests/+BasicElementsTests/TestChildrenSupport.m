classdef TestChildrenSupport < TestCase
    
    properties (Access=private)
        yorkModel;
        children;
    end
        
    methods
        function self = TestChildrenSupport(name)
            self = self@TestCase(name);   
        end
   
        function setUp( self )  
            import BasicElements.Model;
            self.yorkModel = BasicElementsTests.YorkModel();
            self.yorkModel.loadModel();
            aModel = Model.from( self.yorkModel.modelName );
            self.children = aModel.children;
        end

        function tearDown(self) 
            self.yorkModel.deleteFiles();
        end

        function testGetChildren( self )            
%            assertEqual(5, self.children.size );            
% Lines are missing!
            assertEqual(1,self.children.ofTypeGainBlock.size );
            assertEqual(1,self.children.ofTypeSystem.size );
            assertEqual(1,self.children.ofTypeSystemReference.size );
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
