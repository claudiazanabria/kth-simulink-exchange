package SimulinkOOAPI.impl;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
 
@RunWith(Suite.class)
@Suite.SuiteClasses({
	ChildrenSupportImplTest.class,
	GainBlockImplTest.class,
	IdentityImplTest.class,
	InportImplTest.class,
	LibraryImplTest.class,
	LineImplTest.class,
	ModelImplTest.class,
	OutportImplTest.class,	
	ReflectionListImplTest.class,
	SimulinkOOAPIFactoryImplTest.class,
	SystemImplTest.class,
	SystemReferenceImplTest.class
})

public class AllTests {}
