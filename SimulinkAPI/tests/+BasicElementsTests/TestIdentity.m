classdef TestIdentity < TestCase
        
    properties(Access=private)
        yorkModel;
    end
    
    methods
        function self = TestIdentity(name)
            self = self@TestCase(name);   
        end

        function setUp( self )
            self.yorkModel = BasicElementsTests.YorkModel();
            self.yorkModel.loadModel();
        end
        
        function tearDown( self )
            self.yorkModel.deleteFiles();            
        end

        function testValidHandle( self )
            handle = get_param(self.yorkModel.modelName, 'Handle');
            identity = BasicElements.Identity.from( handle );
            assertEqual(handle, identity.handle);
            assertEqual(self.yorkModel.modelName, identity.name);
        end

        function testValidName( self )
            handle = get_param(self.yorkModel.modelName, 'Handle');
            identity = BasicElements.Identity.from( self.yorkModel.modelName );
            assertEqual(handle, identity.handle);
            assertEqual(self.yorkModel.modelName, identity.name);
        end
        
        function testInvalidHandle( self ) %#ok<MANU>
            f = @() BasicElements.Identity.from( 0.1234 );
            assertExceptionThrown(f, 'Simulink:SL_InvSimulinkObjHandle');
        end
        
        function testInvalidName( self ) %#ok<MANU>
            f = @() BasicElements.Identity.from( 'IDontExists' );
            assertExceptionThrown(f, 'Simulink:SL_InvSimulinkObjectName');
        end
        
        function testIdentityFromIdentity( self )
            handle = get_param(self.yorkModel.modelName, 'Handle');
            identity1 = BasicElements.Identity.from( handle );
            identity2 = BasicElements.Identity.from( identity1 );
            assertEqual(identity1, identity2);
            %FIX are they the same element?
        end
    end    
end
