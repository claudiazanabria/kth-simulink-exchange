classdef EcoreCreator < handle
    % From Matlab --> ecore
    properties(Access=private)
        sourceFilePath;
        modelManager;
        javaEcoreCreator;        
    end
    methods (Static)
        % do not use the whole path name. CD first!
        function EC=fromFile( path2mdlFile )
            EC=EcoreCreator();
            EcoreCreator.checkMDLFileReadable( path2mdlFile );            
            EC.sourceFilePath = path2mdlFile;
        end
                
    end
    methods (Static, Access=private)
        function checkMDLFileReadable( mdlPath )
            if (~EcoreCreator.isMDLFileReadable( mdlPath ))
                errRecord = MException('EcoreCreator:MDLnotReadable', ...
                    'MDL file is not readable: %s', mdlPath);
                throw(errRecord);
            end
        end
        
        function boolean = isMDLFileReadable( path2mdlFile )
            boolean = (exist(path2mdlFile,'file') == 4);
        end

        
%         function result = removeMyselfFromList(list, itemToRemove)
%             listSize = size(list,1);
%             result = cell(listSize-1,1);
%             finalIndex = 1;
%             for originalIndex=1:listSize 
%                 if strcmp(list(originalIndex),itemToRemove) == 0
%                     result(finalIndex) = list(originalIndex);
%                     finalIndex = finalIndex + 1;
%                 end
%             end
%         end
        
    end
    methods
        function doIt(self)
            self.initEcoreCreationClasses();
            self.openModelInSimulink();
            modelName = self.getModelName();
            self.javaEcoreCreator.newModel( modelName );
            rootSystem = self.javaEcoreCreator.addRootSystem( modelName );
            self.processSystem( modelName, rootSystem );
            self.saveIt();
        end
    end
    
    methods (Access=private)
        function processSystem( self, systemName, parentSystem)
            [refMdls, mdlBlks] = find_mdlrefs(systemName, false);
            for x=1:size(refMdls,1)-1
                name = char(refMdls(x));
                instanceName = char(mdlBlks(x));
                aNewSystem = self.javaEcoreCreator.addSystem(name,...
                    parentSystem,instanceName);
                self.processSystem(name, aNewSystem);
            end
        end
        
        function saveIt( self )
            topElement = self.javaEcoreCreator.getTopElement();
            self.modelManager.setTopElement( topElement );
            self.modelManager.validateIt();
            destFileName = fullfile(cd(), self.sourceFilePath);
            self.modelManager.saveAsWithPropperExtension(destFileName);
        end
        
        function initEcoreCreationClasses(self)
            self.modelManager = modelManagement.simulink.SimulinkModelManager();
            factory = self.modelManager.getFactory();
            self.javaEcoreCreator = modelManagement.simulink.SimulinkEcoreCreator( factory );
        end
                    
        function openModelInSimulink( self )
            load_system( self.sourceFilePath );
        end
        
        function name=getModelName( self )
            name = bdroot();
        end
        
        
    end
end
