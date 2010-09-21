classdef TestModel < TestCase

    properties
        t
    end
    
    properties(Constant)
        modelName = 'systemundertest';
    end
    
    methods
        function self = TestModel(name)
            self = self@TestCase(name);
        end

        function setUp(self)
            new_system(self.modelName);
            self.t = Model(self.modelName);
        end

        function tearDown(self)
            close_system(self.modelName,0);
        end

        function testModelHandle(self)
            assertEqual(get_param(self.modelName,'handle'),self.t.handle)
        end
        
        function testUnknownModel(self)
            assertExceptionThrown(Model('noname'));
        end
            
    end    
end
