classdef SimulinkEnv
    methods (Static)
        
        function closeAllSystems()
            sysList = BasicElements.SimulinkEnv.findAllOpenedModelNames();
            for x=1:size(sysList)
                close_system( sysList(x), 0 );
            end
        end 
        
        function list = findAllOpenedModelNames()
            list = find_system('FollowLinks','on','Type','block_diagram');
        end
        
        function handleList = findAllLinesWithin( aHandle )
            handleList = find_system(aHandle,'SearchDepth',1,...
                'FollowLinks','on','FindAll','on','Type','line');
        end
        
        function handleList = findAllBlocksWithin( aHandle )
            result = find_system(aHandle,'SearchDepth',1,...
                'FollowLinks','on');
            handleList = BasicElements.SimulinkEnv.removeParentFromList(result);
        end
        
    end
    methods (Static, Access=private)
        function result = removeParentFromList(list)
            result = list(2:end);
        end
    end
    
end