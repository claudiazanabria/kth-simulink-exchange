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
                
    end    
end