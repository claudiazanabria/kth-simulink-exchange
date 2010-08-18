function test_suite = testAddToEcoreLibrary %#ok<STOUT,*DEFNU>
initTestSuite;

function setup
closeAll
new_system('systemundertest');
open_system('systemundertest')
new_system('FunctionTypes','Library')
add_block('built-in/subsystem', 'systemundertest/Subsystem');
%The library link is broken for empty subsystems, so a block is added
add_block('built-in/gain', 'systemundertest/Subsystem/Gain');



function teardown
close_system('systemundertest',0);
close_system('FunctionTypes',0);

function testAddToEcoreLibary 
Utils.AddToEcoreLibrary('systemundertest/Subsystem');
referenceBlockName = get_param('systemundertest/Subsystem','ReferenceBlock');
assertEqual(referenceBlockName,'FunctionTypes/Subsystem');
% doesSystemsExistsInFunctionLibrary?

