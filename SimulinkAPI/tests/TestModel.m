classdef TestModel < TestCase
    
    properties
        aModel;
        refBloc;
        RF1OutportHandle;
        F2Inport;
        libraryName;
        modelName;
    end
    
    properties(Constant)
        RF1Name = 'RF1';
        F2Name = 'F2';
        wrongName = 'I do not exists';
        line1UUID = char( java.util.UUID.randomUUID() );
    end
    
    methods (Static)
        function closeAllSystems()
            sysList = find_system();
            for x=1:size(sysList)
                close_system( sysList(x), 0 );
            end
        end     
    end
    
    methods
        function self = TestModel(name)
            self = self@TestCase(name);
            disp('---- Constructor ----');
        end

        function setupLibrary( self )
            new_system(self.libraryName,'Library');
            load_system(self.libraryName);
            set_param(self.libraryName,'Lock','off');
        end
        
        function setupF1( self )
            add_block('built-in/subsystem', [self.modelName '/F1']);
            add_block('built-in/Inport', [self.modelName '/F1/Inport1']);
            add_block('built-in/Outport', [self.modelName '/F1/Outport1']);
            self.replaceSystemWithSysReferenceFromLibrary([self.modelName '/F1'], '/rF1');
        end
        
        function setupF2( self )
            add_block('built-in/subsystem', [self.modelName '/F2']);
            add_block('built-in/Inport', [self.modelName '/F2/Inport1']);
            add_block('built-in/Outport', [self.modelName '/F2/Outport1']);
            add_block('built-in/Outport', [self.modelName '/F2/Outport2']);            
        end
        
        function setupF21( self )
            add_block('built-in/subsystem', [self.modelName '/F2/F21']);
            add_block('built-in/Inport', [self.modelName '/F2/F21/Inport1']);
            add_block('built-in/Outport', [self.modelName '/F2/F21/Outport1']);
        end
        
        function setupF22( self )
            % A reference block (!)
            add_block([self.libraryName '/rF1'], [self.modelName '/F2/F22']);
        end
        
        function addLinesInsideF22( self )
            f2Name = [self.modelName '/F2'];
            add_line(f2Name, 'Inport1/1','F21/1');
            add_line(f2Name, 'Inport1/1','F22/1');
            add_line(f2Name, 'F21/1','Outport1/1');
            add_line(f2Name, 'F22/1','Outport2/1');
        end
        
        function setupF2GainBlock( self) 
            add_block('built-in/Gain', [self.modelName '/F3']);
        end
        
        function addLinesInRootModel( self )
            add_line(self.modelName,'F1/1','F2/1');
            add_line(self.modelName,'F2/1','F3/1');
        end
        
        % This should be part of an EAST-ADL layer, not model.
        function replaceSystemWithSysReferenceFromLibrary(self, source, destination)
            self.copySystemToLibrary(source, destination);
            save_system( self.libraryName );
            sysRefHandle = get_param([self.libraryName destination],'Handle');
            replace_block(self.modelName, 'Handle', sysRefHandle, source, 'noprompt')            
        end
        
        function copySystemToLibrary(self, source, destination)
            add_block(source, [self.libraryName destination]);
        end
        
        function setUp( self )
            disp('\nentering setup');
            self.libraryName = BasicElements.SimulinkEntityName('Library').timeStamped();
            self.modelName = BasicElements.SimulinkEntityName('yorkDummy').timeStamped();

            TestModel.closeAllSystems();
            self.setupLibrary();
            new_system(self.modelName,'Model');
            load_system(self.modelName);
            self.setupF1();
            self.setupF2();
            self.setupF21();
            self.setupF22();
            self.addLinesInsideF22();
            self.setupF2GainBlock();
            self.addLinesInRootModel();
            self.aModel = BasicElements.Model( self.modelName );
            disp('\nending setup');
        end

        function tearDown(self) 
            disp('teardown');
            close_system(self.modelName,0);
            delete([self.libraryName '.mdl']);
        end

        function testGetChildren(self)
            disp('test1')
            import BasicElements.*;
            children = self.aModel.children;
            assertEqual(3,children.size );            
            assertEqual(1,self.aModel.numberOfChildrenOfType( GainBlock.class() ));
            assertEqual(1,self.aModel.numberOfChildrenOfType( Block.class() ));
            assertEqual(1,self.aModel.numberOfChildrenOfType( RefBlock.class() ));
        end
        
        function testModelContainmentWithName( self )
            assertTrue( self.aModel.contains( self.F2Name ) );
            assertFalse( self.aModel.contains( self.wrongName ));
            block = self.aModel.child( self.F2Name );
            assertEquals(self.F2UUID, block.UUID());
        end
        
        function testModelContainmentWithUUID( self )
            assertTrue( self.aModel.contains( self.F2UUID ) );
            assertFalse( self.aModel.contains( self.UUID ));
            block = self.aModel.child( self.F2UUID );
            assertEquals(self.F2Name, block.name());            
        end
        
        function testLines(self)
            line1 = self.aModel.lines( self.line1UUID );
            assertEqual(self.RF1OutportHandle, line1.source.handle);
        end
                        
    end    
end
