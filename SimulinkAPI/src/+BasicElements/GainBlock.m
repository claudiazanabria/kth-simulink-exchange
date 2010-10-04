classdef GainBlock < ProtoObject
    
    methods
        function self = GainBlock()
            self = self@ProtoObject();
            self.children = ChildrenNOTSupported();
        end        
       
    end
    
end

