classdef ChildrenNOTSupported < handle
    methods
        function self = ChildrenNOTSupported()
        end
        
        function size(self) %#ok<MANU>
            e = MException('KTH:ChildrenNOTSupportedForThisType', ...
                'This type cannot include any children!');
            throw(e);
        end
    end
end
