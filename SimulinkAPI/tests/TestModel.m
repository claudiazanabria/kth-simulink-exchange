classdef TestModel < TestCase

    properties
        aModel;
        refBloc;
        Block;
        GainBlock;
        RF1OutportHandle;
        F2Inport;
        line1;
    end
    
    properties(Constant)
        % Use consistent case
        libraryName = timeStamp('Library');
        modelName = timeStamp('yorkDummy');
        RF1Name = 'RF1';
        F2Name = 'F2';
        wrongName = 'I do not exists';
        line1UUID = char( java.util.UUID.randomUUID() );
    end
    
    methods
        function self = TestModel(name)
            self = self@TestCase(name);
        end

        function setUp(self)
            %close all systems
            sysList = find_system();
            for x=1:size(sysList)
                close_system( sysList(x), 0 );
            end
            %Setup system and library
            new_system(self.libraryName,'Library');
            open_system(self.libraryName);
            new_system(self.modelName);
            open_system(self.modelName);
            set_param(self.libraryName,'Lock','off');
            %Setup F1
            add_block('built-in/subsystem', [self.modelName '/F1']);
            add_block('built-in/Inport', [self.modelName '/F1/Inport1']);
            add_block('built-in/Outport', [self.modelName '/F1/Outport1']);
            add_block([self.modelName '/F1'], [self.libraryName '/rF1']);
            save_system(self.libraryName);
            replace_block(self.modelName, 'Handle', get_param([self.libraryName '/rF1'],'Handle'), [self.modelName '/F1'], 'noprompt')
            %Setup F2
            add_block('built-in/subsystem', [self.modelName '/F2']);
            add_block('built-in/Inport', [self.modelName '/F2/Inport1']);
            add_block('built-in/Outport', [self.modelName '/F2/Outport1']);
            add_block('built-in/Outport', [self.modelName '/F2/Outport2']);
            %setup F21
            add_block('built-in/subsystem', [self.modelName '/F2/F21']);
            add_block('built-in/Inport', [self.modelName '/F2/F21/Inport1']);
            add_block('built-in/Outport', [self.modelName '/F2/F21/Outport1']);
            %setup F22: A reference block (!)
            add_block([self.libraryName '/rF1'], [self.modelName '/F2/F22']);
            %add lines inside F2
            add_line([self.modelName '/F2'],'Inport1/1','F21/1');
            add_line([self.modelName '/F2'],'Inport1/1','F22/1');
            add_line([self.modelName '/F2'],'F21/1','Outport1/1');
            add_line([self.modelName '/F2'],'F22/1','Outport2/1');
            %setup Gainblock F3
            add_block('built-in/Gain', [self.modelName '/F3']);
            %add lines in root model
            add_line(self.modelName,'F1/1','F2/1');
            add_line(self.modelName,'F2/1','F3/1');
        end

        function tearDown(self)
            close_system(self.modelName,0);
        end

        function testGetChildren(self)
            children = self.aModel.children;
            assertEqual(3,children.size );            
            assertEqual(1,aModel.numberOfChildrenOfType( GainBlock.class ) );
            assertEqual(1,aModel.numberOfChildrenOfType( Block.class ) );
            assertEqual(1,aModel.numberOfChildrenOfType( refBlock.class ) );
        end
        
        function testModelContainmentWithName( self )
            assertTrue( aModel.contains( self.F2Name ) );
            assertFalse( aModel.contains( self.wrongName ));
            block = aModel.child( self.F2Name );
            assertEquals(self.F2UUID, block.UUID());
        end
        
        function testModelContainmentWithUUID( self )
            assertTrue( aModel.contains( self.F2UUID ) );
            assertFalse( aModel.contains( self.UUID ));
            block = aModel.child( self.F2UUID );
            assertEquals(self.F2Name, block.name());            
        end
        
        function testLines(self)
            line1 = self.aModel.lines( self.line1UUID );
            assertEqual(self.RF1OutportHandle, line1.source.handle);
            

        end
        
        
        function testModelHandle(self)
            assertEqual(get_param(self.modelName,'handle'),self.t.handle)
            
            
        end
        
        function testUnknownModel(self)
            assertExceptionThrown(Model('noname'));
        end
            
    end    
end
