package SimulinkOOAPI.util;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	AssertionRunnerTest.class,
	YorkModelTest.class,
	EMFCompareWrapperTest.class,
	EqualityHelperTest.class
})

public class AllTests {}


