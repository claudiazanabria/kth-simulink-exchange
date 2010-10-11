classdef TestProtoObject < TestCase
    properties
        proto;
        list;
    end
    methods
        function self = TestProtoObject(name)
            self = self@TestCase(name);   
        end
                
        function testIfGainBlockAddToList( self )
            self.proto.ifGainBlockAddToList( self.list );
            assertEqual(0, self.list.size);
        end                
        
        function testIfSystemAddToList( self )
            self.proto.ifSystemAddToList( self.list );
            assertEqual(0, self.list.size);
        end
        
        function testIfRefBlockAddToList( self )
            self.proto.ifRefBlockAddToList( self.list );
            assertEqual(0, self.list.size);
        end
    end
end
