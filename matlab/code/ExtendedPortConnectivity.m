classdef ExtendedPortConnectivity < handle
    methods (Static)
        function result=fromBlockName( name )
            aHandle = get_param( name, 'Handle');
            result = ExtendedPortConnectivity.fromBlockHandle( aHandle );
        end
        
        function result=fromBlockHandle( aBlockHandle )
            portConnectivity = get_param( aBlockHandle, 'PortConnectivity');
            theSize = size( portConnectivity,1 );
            result = cell(1,theSize);
            for x=1:theSize
                ep = ExtendedPort.new(aBlockHandle, portConnectivity(x) );
                result(1,x) = { ep };
            end
        end
    end
end
