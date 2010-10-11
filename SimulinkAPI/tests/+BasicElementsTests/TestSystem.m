classdef TestSystem < BasicElementsTests.TestProtoObject
    methods
        function self = TestSystem(name)
            self = self@BasicElementsTests.TestProtoObject(name);   
        end
        
        function setUp( self )
            %FIXME: call super class setUp instead!
            parentMock = 1;
            identityMock = BasicElementsTests.IdentityMock();
            self.proto = BasicElements.System(identityMock, parentMock);
            self.list = BasicElements.List.newEmptyList();
        end

        function testIfSystemAddToList( self )
            self.proto.ifSystemAddToList( self.list );
            assertEqual(1, self.list.size);
        end
    end
end