%**************************************************************************
%* Copyright (c) 2010 KTH, Mechatronics group and others.
%* All rights reserved. This program and the accompanying materials
%* are made available under the terms of the Eclipse Public License v1.0,
%* which accompanies this distribution, and is available at
%* http://www.eclipse.org/legal/epl-v10.html
%* 
%* Contributors: KTH, Mechatronics group
%**************************************************************************

classdef SystemLayouter < handle
    properties
        distanceBetweenPorts    = 60;
        distanceBetweenSystmes  = 90;
        blockSize               = 150;
        portSizeHoriz                = 30;
        portSizeVert                 = 14;
    end
    properties (Access=private)
        top     = 50;
        left    = 20;
        bottom  = 0;
        right   = 0;
    end
    
    methods
        function result = nextPort(self)
            self.top = self.top + self.distanceBetweenPorts;
            self.buildPositionArray('port');
            result = [self.left self.top self.right self.bottom];
        end
        
        function result = nextSystem(self)
            self.left = self.left + self.distanceBetweenSystmes + self.blockSize;
            self.buildPositionArray('system');
            result = [self.left self.top self.right self.bottom];
        end
        
        function startWithSystems(self)
            self.top    = 40;
            self.left   = -140;
        end
        
        function startWithOutports(self)
            self.left = self.left + self.distanceBetweenSystmes + self.blockSize;
            if (self.left < 0), self.left = 100; end;
            self.top = 50;
        end
        
        function buildPositionArray(self, componentType)
            switch lower( componentType )
                case 'system'
                    self.bottom = self.top + self.blockSize;
                    self.right = self.left + self.blockSize;
                case 'port'
                    self.bottom = self.top + self.portSizeVert;
                    self.right = self.left + self.portSizeHoriz;
            end
        end
    end
end