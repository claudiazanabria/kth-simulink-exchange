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
        modelName = 'yorkDummy';
        RF1Name = 'RF1';
        F2Name = 'F2';
        wrongName = 'I do not exists';
        line1UUID
    end
    
    methods
        function self = TestModel(name)
            self = self@TestCase(name);
        end

        function setUp(self)
            new_system(self.modelName);
            open_system(self.modelName);
            add_block('built-in/subsystem', [self.modelName '/Subsystem']);
            add_block('built-in/Inport', [self.modelName '/Subsystem/Inport1']);
            add_block('built-in/Outport', [self.modelName '/Subsystem/Outport1']);
            
            add_block('built-in/subsystem', [self.modelName '/Subsystem1']);
            add_block('built-in/Inport', [self.modelName '/Subsystem1/Inport1']);
            add_block('built-in/Outport', [self.modelName '/Subsystem1/Outport1']);
            add_line(self.modelName,'Subsystem/1','Subsystem1/1')
            add_line(self.modelName,'Subsystem1/1','Subsystem/1')
            add_block('built-in/subsystem', [self.modelName '/Subsystem2']);
            add_block('built-in/Inport', [self.modelName '/Subsystem2/Inport1']);
            add_block('built-in/Outport', [self.modelName '/Subsystem2/Outport1']);
            add_block('built-in/subsystem', [self.modelName '/Subsystem2/Subsystem3']);
            add_block('built-in/Inport', [self.modelName '/Subsystem2/Subsystem3/Inport1']);
            add_block('built-in/Outport', [self.modelName '/Subsystem2/Subsystem3/Outport1']);
            self.RF1OutportHandle = 2323; % ports have two handles!?!
            self.aModel = Model.recreateFromModel(self.modelName);
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
