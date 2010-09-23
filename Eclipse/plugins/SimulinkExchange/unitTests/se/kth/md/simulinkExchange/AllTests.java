package se.kth.md.simulinkExchange;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
 
@RunWith(Suite.class)
@Suite.SuiteClasses({
	//se.kth.md.simulinkExchange.atl.AllTests.class,
	se.kth.md.simulinkExchange.conversion.ToSimulink.AllTests.class,
	se.kth.md.simulinkExchange.conversion.tasks.AllTests.class,
	se.kth.md.simulinkExchange.conversion.ToSimulink.tasks.AllTests.class,
})

public class AllTests {
    // why on earth I need this class, I have no idea! 
}
