classdef YorkModel < handle
    properties
        modelName;
        libraryName;
    end
    
    properties(Constant)
        RF1Name = 'RF1';
        F2Name = 'F2';
        wrongName = 'I do not exists';
        line1UUID = char( java.util.UUID.randomUUID() );
    end

    methods
        function self=YorkModel()
            self.libraryName = BasicElements.SimulinkEntityName('Library').timeStamped();
            self.modelName = BasicElements.SimulinkEntityName('yorkDummy').timeStamped();

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
        
        function replaceSystemWithSysReferenceFromLibrary(self, source, destination)
            self.copySystemToLibrary(source, destination);
            save_system( self.libraryName );
            sysRefHandle = get_param([self.libraryName destination],'Handle');
            replace_block(self.modelName, 'Handle', sysRefHandle, source, 'noprompt')            
        end
        
        function copySystemToLibrary(self, source, destination)
            add_block(source, [self.libraryName destination]);
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

        

    end
end
