classdef EcoreCreatorRef < handle
    % From Matlab --> ecore using Library mechanism
    % Some old code left as comments
    properties(Access=private)
        sourceSystem;
        modelManager;
        javaEcoreCreator;        
    end
    methods (Static)
        function EC=fromModel( modelName , destFileName)
            %If destFileName is omitted [testcases
            if (nargin == 1) 
                destFileName = fullfile(cd(), systemName);
            end
            %Next line commented out - not needed?
            %Utils.checkMDLFileReadable( systemName );
            EC=EcoreCreatorRef();
            EC.sourceSystem = modelName;
            EC.doIt(modelName, destFileName);
        end        
    end
    
    methods
        function doIt(self , modelName, destFileName)
            self.initEcoreCreationClasses();
            %modelName = self.openModelInSimulink();
            self.javaEcoreCreator.newModel( modelName );
            rootSystem = self.javaEcoreCreator.addRootSystem(modelName);
            self.processSystem( rootSystem );
            %save_system( modelName );
            self.saveIt(destFileName);
        end
        
    end
    methods (Access=private)
        
        function processSystem( self, parentSystem )
            systemName = char( parentSystem.getName() );
            mdlBlks = find_system(systemName, 'regexp', 'on', 'SearchDepth',1, 'ReferenceBlock', 'FunctionTypes/' );
            for x=1:size(mdlBlks)
                self.processBlock( mdlBlks{x}, parentSystem );
            end
            %[refMdls, mdlBlks] = find_mdlrefs(systemName, false);
            %for x=1:size(refMdls,1)-1
            %    self.processBlock( mdlBlks{x}, parentSystem );
            %end
            self.addLines( mdlBlks, parentSystem );
        end
        
        function processBlock( self, blockName, parentSystem )            
            %name                = get_param(blockName,'ModelName');
            name                = get_param(blockName,'ReferenceBlock');
            %Will remove the FunctionTypes/ from the blockname, and remove
            %library structure. Perhaps a subject for deletion.
            instanceName        = Utils.extractOnlyName( blockName );
            sysAlreadyExists    = self.javaEcoreCreator.findSystem(name);
            import se.kth.md.simulinkExchange.modelConversion.simulink.PropertyList;
            pList = PropertyList(name, parentSystem, instanceName);
            posArray = get_param(blockName,'position');
            position = Utils.posArray2String( posArray );
            aSystemRef = self.javaEcoreCreator.addSystem( pList );
            aSystemRef.setPosition( position );
            Utils.setUUIDinUserData( aSystemRef, blockName );
            %This will change the UUID of the block to the new one created
            %in Java. This is subject to change in a future release.
            targetSystem = aSystemRef.getTarget();
            if isempty( sysAlreadyExists )
                self.addOutportsTo( targetSystem );
                self.addInportsTo( targetSystem );
                self.processSystem( targetSystem );
            end
        end
                
        function addLines( self, mdlBlks, parentSystem )
            lineBuilder = LineBuilder( parentSystem );
            for x=1:size(mdlBlks,1)
                ep = ExtendedPortConnectivity.fromBlockName(mdlBlks{x});
                lineBuilder.process( ep );
            end
            createdLines = lineBuilder.getCreatedLines();
            self.javaEcoreCreator.addLines( createdLines );
        end
                
        function addOutportsTo( self, aSystem )
            name = char(aSystem.getName());
            ports = find_system(name,'SearchDepth',1,...
                'BlockType','Outport');
            for x=1:size(ports,1)                                
                portName = Utils.extractOnlyName( ports(x) );
                p = self.javaEcoreCreator.addOutPort(portName, aSystem);                
                Utils.setUUIDinUserData( p,  ports{x} );
                self.keepPosition(p, ports{x});
            end
        end

        function addInportsTo( self, aSystem )
            name = char(aSystem.getName());
            ports = find_system(name,'SearchDepth',1,...
                'BlockType','Inport');
            for x=1:size(ports,1)
                portName = Utils.extractOnlyName( ports(x) );
                p = self.javaEcoreCreator.addInPort(portName, aSystem);
                Utils.setUUIDinUserData( p,  ports{x} );
                self.keepPosition(p, ports{x});
            end
        end

        function saveIt( self , destFileName)
            topElement = self.javaEcoreCreator.getTopElement();
            self.modelManager.setTopElement( topElement );
            % FIXME: the output of the validating cannot be seen.
            % self.modelManager.validateIt();
            % destFileName = fullfile(cd(), destFileName);
            self.modelManager.saveAsWithPropperExtension(destFileName);
        end
        
        function initEcoreCreationClasses(self)
            import se.kth.md.simulinkExchange.modelManagement.simulink.SimulinkModelManager;
            import se.kth.md.simulinkExchange.modelConversion.simulink.SimulinkEcoreCreator;
            self.modelManager = SimulinkModelManager();
            factory = self.modelManager.getFactory();
            self.javaEcoreCreator = SimulinkEcoreCreator( factory );
        end
                    
        function sysName = openModelInSimulink( self )
            fullPath = which( self.sourceSystem );
            load_system( fullPath );
            sysName = char( find_system('Filename', fullPath));
        end                
        
        function keepPosition(self, ecoreObj, matlabObj) %#ok<MANU>
            position = get_param(matlabObj, 'Position');
            if ~isempty( position )
                ecoreObj.setPosition( mat2str(position) );
            end
        end
    end
end
