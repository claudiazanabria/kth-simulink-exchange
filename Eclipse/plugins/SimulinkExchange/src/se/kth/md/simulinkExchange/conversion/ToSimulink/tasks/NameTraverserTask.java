package se.kth.md.simulinkExchange.conversion.ToSimulink.tasks;

import se.kth.md.simulinkExchange.conversion.ToSimulink.NameTraverserDelegate;
import se.kth.md.simulinkExchange.conversion.ToSimulink.TraverseChildrenBeforeInportsStrategy;
import se.kth.md.simulinkExchange.conversion.tasks.ITask;
import se.kth.md.simulinkExchange.management.IModelManager;

/**
 * This task will run the name traverser on the given filename (model).
 * 
 * @author alex
 *
 */
public class NameTraverserTask extends StrategyBasedTraversalTask implements ITask {

	@Override
	public String name() {
		return "Name traverser";
	}

	@Override
	public Object run(Object modelManager) throws Exception {
		TraverseChildrenBeforeInportsStrategy traverser = new TraverseChildrenBeforeInportsStrategy();
		NameTraverserDelegate delegate = new NameTraverserDelegate();

		return runAfterInit((IModelManager) modelManager, traverser, delegate);
	}

}
