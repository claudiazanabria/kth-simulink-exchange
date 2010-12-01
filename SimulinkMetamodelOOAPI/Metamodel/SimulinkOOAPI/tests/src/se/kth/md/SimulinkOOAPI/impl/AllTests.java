package se.kth.md.SimulinkOOAPI.impl;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
 
@RunWith(Suite.class)
@Suite.SuiteClasses({
	ChildrenSupportTest.class,
	GainBlockTest.class,
	IdentityTest.class,
	InportTest.class,
	LibraryTest.class,
	LineTest.class,
	ModelTest.class,
	OutportTest.class,	
	ReflectionListTest.class,	
	SystemTest.class,
	SystemReferenceTest.class
})

public class AllTests {}
