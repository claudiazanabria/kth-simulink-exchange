package SimulinkOOAPI;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	SimulinkOOAPI.impl.AllTests.class,
	SimulinkOOAPI.util.AllTests.class
})

public class AllTests {}
