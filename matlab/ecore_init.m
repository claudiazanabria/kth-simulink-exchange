%add code directory to path based on current path
path([pwd,'\code'], path);
%Run ClassPathSetter 
ClassPathSetter([pwd,'\libs'])
%Register the Ecore menus using sl_customization.m
%(to unregister, run sl_refresh_customizations in a folder not containing sl_customization.m)
sl_refresh_customizations