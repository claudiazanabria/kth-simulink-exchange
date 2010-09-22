package se.kth.md.simulinkExchange.popup.actions.east2simulink;

import se.kth.md.simulinkExchange.conversion.ToSimulink.postprocessing.NameTraverserDelegate;
import se.kth.md.simulinkExchange.conversion.ToSimulink.postprocessing.TraverseChildrenBeforeInportsStrategy;
import se.kth.md.simulinkExchange.management.IModelManager;
import se.kth.md.simulinkExchange.popup.actions.ITask;

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
