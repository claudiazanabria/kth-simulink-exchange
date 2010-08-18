%add code directory to path based on current path
addpath( fullfile(pwd,'code') );

%Run ClassPathSetter 
ClassPathSetter( fullfile(pwd,'libs') );

%Register the Ecore menus using sl_customization.m
%(to unregister, run sl_refresh_customizations in a folder not containing sl_customization.m)
sl_refresh_customizations;

docPath = fullfile(pwd, '/code/html/');
disp('Welcome to the Simulink to Ecore exchange plugin, developed by KTH in the ATESST2 project.')
disp(['It is licenced under the <a href="matlab: web(' char(39) docPath 'epl-v10.html' char(39) ')">Eclipse Public License 1.0</a>.'])

disp(['Please read the <a href="matlab: web(' char(39) docPath 'Docroot.html' char(39) ')">documentation</a>!'])
disp('');
