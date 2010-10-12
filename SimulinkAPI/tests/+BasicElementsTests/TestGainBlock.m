classdef TestGainBlock < BasicElementsTests.TestProtoObject
    methods
        function self = TestGainBlock(name)
            self = self@BasicElementsTests.TestProtoObject(name);   
        end
        
        function setUp( self )
            %FIXME: call super class setUp instead!
            parentMock = 1;
            identityMock = BasicElementsTests.IdentityMock();
            self.proto = BasicElements.GainBlock(identityMock, parentMock);
            self.list = BasicElements.List.newEmptyList();
        end

% Unused !?!        
%         function testIfGainBlockAddToList( self )
%             self.proto.ifGainBlockAddToList( self.list );
%             assertEqual(1, self.list.size);
%         end
    end
end