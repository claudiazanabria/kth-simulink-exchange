package se.kth.md.simulinkExchange.conversion.ToSimulink;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
 
@RunWith(Suite.class)
@Suite.SuiteClasses({
  TraverseChildrenBeforeInportsStrategyTest.class,
  TraversalForLayoutStrategyTest.class,
  NameTraverserDelegateTest.class,
})

public class AllTests {
    // why on earth I need this class, I have no idea! 
}
