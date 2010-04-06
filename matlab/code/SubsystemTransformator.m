classdef SubsystemTransformator
    properties
        systemName;
    end
    methods (Static)
        function ST=SubsystemTransformator( sysName )
            ST.systemName = sysName;
            ST.doIt();
        end
    end
    methods
        function doIt( self )
            self.fixModelSettings();
            blocks = find_system(self.systemName,'BlockType','SubSystem');
            zize = size(blocks,1);
            fprintf('Attemting to transform %d blocks.\n', zize);
            for x=1:zize
                block = blocks{x};
                atomic = get_param(block,'IsSubsystemVirtual');
                if strcmp(atomic, 'off')
                    fprintf('Block: %s\t',block);
                    mdlRef = Utils.extractOnlyName(block);
                    [success,mdlRefBlkH] = Simulink.SubSystem. ...
                        convertToModelReference(block, mdlRef);
                    if success
                        fprintf('succeded.\n');
                    else
                        fprintf('failed.\n');
                    end
                else
                    fprintf('Block %s is NOT atomic, ignoring it.\n',block);
                end
            end
        end
        
        function fixModelSettings( self )
            set_param(self.systemName, 'InlineParams', 'on');
            set_param(self.systemName, 'SignalResolutionControl', 'UseLocalSettings');
            set_param(self.systemName, 'StrictBusMsg', 'ErrorLevel1')
        end
    end
end