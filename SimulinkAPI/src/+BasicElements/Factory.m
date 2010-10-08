classdef Factory < handle
    methods (Static)
        function object = newChildFromHandle(handle, parent)
            import BasicElements.Factory;
            objectType = get_param(handle,'Type');
            switch objectType
                case 'block'
                    object = Factory.newChildBlockFromHandle(handle, parent);
                otherwise
                    object = Factory.newMockBlock(handle, parent);
            end
        end
        
        function block = newGainBlock( handle, parent )
            block = BasicElements.GainBlock( handle, parent );
        end

        function block = newSystem( handle, parent )
            block = BasicElements.System( handle, parent );
        end

    end
    methods (Static, Access=private)
        function object = newMockBlock( handle, parent)
            object = BasicElementsTests.MockBlock(handle, parent);
        end
        
        function object = newChildBlockFromHandle( handle, parent )
            import BasicElements.Factory;
            blockType = get_param(handle,'BlockType');
            switch blockType
                case 'Gain'
                    object = Factory.newGainBlock( handle, parent );
                case 'SubSystem'
                    object = Factory.newSystem( handle, parent );
                otherwise
                    object = Factory.newMockBlock(handle, parent);
            end
        end
    end
end