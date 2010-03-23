%% Close all systems
sysList = find_system();
for x=1:size(sysList)
    save_system( sysList(x) );
    close_system( sysList(x) );
end