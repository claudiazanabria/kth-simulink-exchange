package SimulinkOOAPI.impl;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
 
@RunWith(Suite.class)
@Suite.SuiteClasses({
	ChildrenSupportImplTest.class,
	GainBlockImplTest.class,
	LibraryImplTest.class,
	LineImplTest.class,
	ModelImplTest.class,
	PortImplTest.class,
	ReflectionListImplTest.class,
	SystemImplTest.class,
	SystemReferenceImplTest.class
})

public class AllTests {}
