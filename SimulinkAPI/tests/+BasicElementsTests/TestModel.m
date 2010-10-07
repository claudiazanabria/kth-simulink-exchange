classdef TestModel < TestCase
    
    properties (Access=private)
        yorkModel;
    end
    
    properties
        aModel;
    end 
        
    methods (Static)
        function closeAllSystems()
            sysList = find_system();
            for x=1:size(sysList)
                close_system( sysList(x), 0 );
                delete([sysList(x) '.mdl']);
            end
        end     
    end
    
    methods
        function self = TestModel(name)
            self = self@TestCase(name);   
        end
   
        function setUp( self )            
            BasicElementsTests.TestModel.closeAllSystems();           
            self.yorkModel = BasicElementsTests.YorkModel();
            self.aModel = BasicElements.Model( self.yorkModel.modelName );
        end

        function tearDown(self) 
            disp('Teardown');
            modName = self.yorkModel.modelName;
            libName = self.yorkModel.libraryName;
            
            close_system(modeName,0);
            delete([modName '.mdl']);
            close_system(libName,0);
            delete([libName '.mdl']);
        end

        function testGetChildren( self )
            children = self.aModel.children;
            assertEqual(3,children.size );            
            assertEqual(1,children.ofTypeGainBlock );
            assertEqual(1,children.ofTypeSystem );
            assertEqual(1,children.ofTypeRefBlock );
        end
        
        function testModelContainmentWithName( self )
            assertTrue( self.aModel.contains( self.yorkModel.F2Name ) );
            assertFalse( self.aModel.contains( self.yorkModel.wrongName ));
            block = self.aModel.child( self.yorkModel.F2Name );
            assertEquals(self.yorkModel.F2UUID, block.UUID );
        end
        
        function testModelContainmentWithUUID( self )
            assertTrue( self.aModel.contains( self.yorkModel.F2UUID ) );
            assertFalse( self.aModel.contains( self.yorkModel.UUID ));
            block = self.aModel.child( self.yorkModel.F2UUID );
            assertEquals(self.yorkModel.F2Name, block.name );            
        end
        
        function testFindCorrectLine(self)
%             line1 = self.aModel.lines( self.yorkModel.line1UUID );
%             assertEqual(self.yorkModel.RF1OutportUUID, line1.source.UUID);
        end
                        
    end    
end
