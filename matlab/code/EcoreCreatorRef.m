%% Ecore creator using library blocks
% Creates a .simulink file, by recursively navigating a loaded model
%%
%**************************************************************************
%* Copyright (c) 2010 KTH, Mechatronics group and others.
%* All rights reserved. This program and the accompanying materials
%* are made available under the terms of the Eclipse Public License v1.0,
%* which accompanies this distribution, and is available at
%* http://www.eclipse.org/legal/epl-v10.html
%* 
%* Contributors: KTH, Mechatronics group
%**************************************************************************


classdef EcoreCreatorRef < handle
    properties(Access=private)
        sourceSystem;
        modelManager;
        javaEcoreCreator;        
    end
    methods (Static)
        function EC=fromModel( modelName , destFileName)
            %If destFileName is omitted [testcases
            if (nargin == 1) 
                destFileName = fullfile(cd(), modelName);
            end
            %Next line commented out - not needed?
            %Utils.checkMDLFileReadable( modelName );
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
            self.processSystem( rootSystem , 1);
            %Maybe nice to save system
            %save_system( modelName );
            self.saveIt(destFileName);
        end
        
    end
    methods (Access=private)
        
        function processSystem( self, parentSystem ,isroot)
            systemName = char( parentSystem.getName() );
            if ~(isroot)
                systemName = Utils.getLibraryName(systemName);
            end                  
            mdlBlks = find_system(systemName, 'regexp', 'on', 'SearchDepth',1, 'ReferenceBlock', Utils.getLibraryName('') );
            for x=1:size(mdlBlks)
                self.processBlock( mdlBlks{x}, parentSystem );
            end
            self.addLines( mdlBlks, parentSystem );
        end
        
        function processBlock( self, blockName, parentSystem )            
            referenceBlockName = get_param(blockName,'ReferenceBlock');
            %Remove the LibraryName/ from the name
            referenceBlockName  = Utils.extractOnlyName( referenceBlockName );
            instanceName        = Utils.extractOnlyName( blockName );
            sysAlreadyExists    = self.javaEcoreCreator.findSystem(referenceBlockName);
            import se.kth.md.simulinkExchange.conversion.ToEast.PropertyList;
            pList = PropertyList(referenceBlockName, parentSystem, instanceName);
            posArray = get_param(blockName,'position');
            position = Utils.posArray2String( posArray );
            aSystemRef = self.javaEcoreCreator.addSystem( pList );
            aSystemRef.setPosition( position );
            Utils.setUUIDinUserData( aSystemRef, blockName );
            %This will change the UUID of the block to the new one created
            %in Java. This is subject to change in a future release, Java
            %should not change UUID for the block (?)
            targetSystem = aSystemRef.getTarget();
            if isempty( sysAlreadyExists )
                self.addOutportsTo( targetSystem );
                self.addInportsTo( targetSystem );    
                self.processSystem( targetSystem,0);
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
            name = Utils.getLibraryName( char(aSystem.getName()));
            ports = find_system(name,'SearchDepth',1,...
                'FollowLinks','On','BlockType','Outport');
            for x=1:size(ports,1)                                
                portName = Utils.extractOnlyName( ports(x) );
                p = self.javaEcoreCreator.addOutPort(portName, aSystem);                
                Utils.setUUIDinUserData( p,  ports{x} );
                self.keepPosition(p, ports{x});
            end
        end

        function addInportsTo( self, aSystem )
            name = Utils.getLibraryName(char(aSystem.getName()));
            ports = find_system(name,'SearchDepth',1,...
                'FollowLinks','On','BlockType','Inport');
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
            import se.kth.md.simulinkExchange.management.simulink.SimulinkModelManager;
            import se.kth.md.simulinkExchange.conversion.ToEast.SimulinkEcoreCreator;
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
