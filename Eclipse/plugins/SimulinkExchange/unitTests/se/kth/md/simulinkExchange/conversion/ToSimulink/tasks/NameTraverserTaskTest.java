package se.kth.md.simulinkExchange.conversion.ToSimulink.tasks;

import org.junit.Before;

import se.kth.md.simulinkExchange.conversion.ToSimulink.tasks.NameTraverserTask;

public class NameTraverserTaskTest extends StrategyBasedTraversalTaskTest {

	@Before
	public void setUp() {
		task = new NameTraverserTask();
	}
}
