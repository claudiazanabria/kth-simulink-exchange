%**************************************************************************
%* Copyright (c) 2010 KTH, Mechatronics group and others.
%* All rights reserved. This program and the accompanying materials
%* are made available under the terms of the Eclipse Public License v1.0,
%* which accompanies this distribution, and is available at
%* http://www.eclipse.org/legal/epl-v10.html
%* 
%* Contributors: KTH, Mechatronics group
%**************************************************************************

classdef ExtendedPortConnectivity < handle
    methods (Static)
        function result=fromBlockName( name )
            aHandle = get_param( char(name), 'Handle');
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
