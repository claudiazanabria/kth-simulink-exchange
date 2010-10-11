classdef IdentityMock < BasicElements.Identity
    properties (Constant)
        fakeHandle = 0.1234;
    end
    methods
        function self = IdentityMock()
            import BasicElementsTests.IdentityMock;
            self=self@BasicElements.Identity(IdentityMock.fakeHandle) ;
        end
        
% FIXME: Waiting for support.        
%         function name = get.name(self)
%             name = 'IdentityMock';
%         end
        
    end
end
