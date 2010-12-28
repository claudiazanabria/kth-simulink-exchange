classdef YorkModel < handle
    properties
        modelName;
        libraryName;
    end
    
    properties (Access=private)
        F2FullName;
        tempPrefix;
    end
    
    properties (Constant)
        wrongName = 'I do not exists';        
    end

    methods (Static)
        function self = onTempFolder()
             BasicElementsTests.YorkModel.workOnTempDir();
             self = BasicElementsTests.YorkModel();             
        end
    end
    
    methods (Static, Access=private)
        function workOnTempDir()
            if isempty( regexp(pwd,'temp$','end') )
                try
                    cd 'temp';
                catch e %#ok<NASGU>
                    mkdir 'temp';
                    BasicElementsTests.YorkModel.workOnTempDir;
                end
            end
        end
                
    end
    methods
        function self=YorkModel()
           
            self.setupNames();
            self.setupLibrary();
            self.setupModel();
            self.setupRF1withinLibrary();
            self.setupF1withinModel();
            self.setupF2();
            self.setupF21();
            self.setupF22();
            self.addLinesInsideF22();
            self.setupF2GainBlock();
            self.addLinesInRootModel();
            self.saveAndClose();
        end
        
        function openAll( self )
            self.openModel();
            self.openLibrary();
        end
        
        function openModel( self )
            open_system( self.modelName );
        end
        
        function openLibrary( self )
            open_system( self.libraryName );
        end
        
        function closeAll( self )
            self.closeModel();
            self.closeLibrary();
        end
        
        function closeModel( self )
            close_system( self.modelName, 0 );
        end
        
        function closeLibrary( self )
            close_system( self.libraryName, 0 );
        end

        function saveAll( self )
            self.saveModel();
            self.saveLibrary();
        end
        
        function saveModel( self )
            save_system( self.modelName, 0 );
        end
        
        function saveLibrary( self )
            save_system( self.libraryName, 0 );
        end
        
        function loadAll( self )
            self.loadModel();
            self.loadLibrary();
        end
        
        function loadModel( self )
            load_system( self.modelName );
        end
        
        function loadLibrary( self )
            load_system( self.libraryName );
        end

        function deleteFiles( self )
            self.closeAll();
            delete([self.modelName '.mdl']);            
            delete([self.libraryName '.mdl']);            
        end
        
        function h=f2Handle( self )
            h = self.F2FullName;
        end
    end
    methods (Access=private)
            
        function setupNames( self )
            import BasicElements.SimulinkEntityName;
            self.libraryName = SimulinkEntityName('Library').timeStamped();
            self.modelName = SimulinkEntityName('yorkDummy').timeStamped();
            self.F2FullName=[self.modelName '/F2'];
        end
        
        function setupLibrary( self )
            new_system(self.libraryName,'Library');
            load_system(self.libraryName);
            set_param(self.libraryName,'Lock','off');
        end
        
        function setupModel( self )
            new_system(self.modelName,'Model');
            load_system(self.modelName);
        end
        
        
        function setupRF1withinLibrary( self )
            add_block('built-in/subsystem', [self.libraryName '/rF1'], 'Position',[200 110 300 230]);
            add_block('built-in/Inport', [self.libraryName '/rF1/Inport1'], 'Position',[170 110 190  130]);
            add_block('built-in/Outport', [self.libraryName '/rF1/Outport1'],'Position',[170 110 190  130]);             
            save_system( self.libraryName );            
        end
        
        function setupF1withinModel( self )
            add_block([self.libraryName '/rF1'], [self.modelName '/F1'],'Position',[45 85 140 235]);
        end
                
        function setupF2( self )
            add_block('built-in/subsystem', self.F2FullName,'Position',[210 82 300 233]);
            add_block('built-in/Inport', [self.F2FullName '/Inport1'],'Position',[25  95  45  115]);
            add_block('built-in/Outport', [self.F2FullName '/Outport1'],'Position',[465 95 485 115]);
            add_block('built-in/Outport', [self.F2FullName '/Outport2'],'Position',[465 220 485 240]);                     
        end
        
        function setupF21( self )
            add_block('built-in/subsystem', [self.F2FullName '/F21'],'Position',[305 36 405 174]);
            add_block('built-in/Inport', [self.F2FullName '/F21/Inport1'],'Position',[170 110 190  130]);
            add_block('built-in/Outport', [self.F2FullName '/F21/Outport1'],'Position',[340 110 360  130]);
        end
        
        function setupF22( self )
            % A reference block (!)
            add_block([self.libraryName '/rF1'], [self.modelName '/F2/F22'],'Position',[140 157 245 303]);
        end
        
        function addLinesInsideF22( self )
            add_line(self.F2FullName, 'Inport1/1','F21/1');
            add_line(self.F2FullName, 'Inport1/1','F22/1');
            add_line(self.F2FullName, 'F21/1','Outport1/1');
            add_line(self.F2FullName, 'F22/1','Outport2/1');
        end
        
        function setupF2GainBlock( self) 
            add_block('built-in/Gain', [self.modelName '/F3'],'Position',[370 102 410 140]);
        end
        
        function addLinesInRootModel( self )
            add_line(self.modelName,'F1/1','F2/1');
            add_line(self.modelName,'F2/1','F3/1');
        end       

        function saveAndClose( self )
            save_system( self.modelName );
            self.closeAll();
        end
    end
end
