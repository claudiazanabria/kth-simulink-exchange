package se.kth.md.simulinkExchange;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
 
@RunWith(Suite.class)
@Suite.SuiteClasses({
	se.kth.md.simulinkExchange.atl.AllTests.class,
	se.kth.md.simulinkExchange.conversion.ToSimulink.postprocessing.AllTests.class,
	se.kth.md.simulinkExchange.popup.actions.atl.AllTests.class,
	se.kth.md.simulinkExchange.popup.actions.atl.east2simulink.AllTests.class,
})

public class AllTests {
    // why on earth I need this class, I have no idea! 
}
