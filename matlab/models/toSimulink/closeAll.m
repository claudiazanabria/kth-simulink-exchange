%% Close all systems
sysList = find_system();
for x=1:size(sysList)
    close_system( sysList(x), 1 );
end