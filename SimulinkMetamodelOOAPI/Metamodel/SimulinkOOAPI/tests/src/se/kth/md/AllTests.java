package se.kth.md;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	se.kth.md.SimulinkOOAPI.impl.AllTests.class,
	se.kth.md.SimulinkOOAPI.util.AllTests.class
})

public class AllTests {}
