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

        function testGetChildrenSize( self ) 
            %Lines are missing !!
            assertEqual(5, self.children.size );            
        end
        
        function testChildrenOfTypeGainBlock( self )
            assertEqual(1,self.children.ofTypeGainBlock.size );
        end
        
        function testChildrenOfTypeSystem( self )
            assertEqual(1,self.children.ofTypeSystem.size );
        end
        
        function testChildrenOfTypeSystemReference( self ) 
            assertEqual(1,self.children.ofTypeSystemReference.size );
        end

        function testChildrenOfTypeLine( self ) 
            assertEqual(2,self.children.ofTypeLine.size );
        end

        function testChildrenOfTypeOutport( self )
            %FIXME: replace this with a find inside model
            f2 = self.children.ofTypeSystem.at(1);
            assertEqual(2,f2.children.ofTypeOutport.size);
        end

        function testChildrenOfTypeInport( self )
            %FIXME: replace this with a find inside model
            f2 = self.children.ofTypeSystem.at(1);
            assertEqual(1,f2.children.ofTypeInport.size);
        end

        
        
        % Should contain travel down the whole hierarchy? --> YES!
        
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
