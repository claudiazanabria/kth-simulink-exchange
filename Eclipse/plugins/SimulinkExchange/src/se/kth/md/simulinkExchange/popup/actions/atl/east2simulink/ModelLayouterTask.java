package se.kth.md.simulinkExchange.popup.actions.atl.east2simulink;


import se.kth.md.simulinkExchange.conversion.ToSimulink.postprocessing.ITraverserDelegate;
import se.kth.md.simulinkExchange.conversion.ToSimulink.postprocessing.ITraverserStrategy;
import se.kth.md.simulinkExchange.conversion.ToSimulink.postprocessing.TraverseChildrenAfterInportsStrategy;
import se.kth.md.simulinkExchange.management.IModelManager;
import se.kth.md.simulinkExchange.popup.actions.atl.ITask;

public class ModelLayouterTask extends StrategyBasedTraversalTask implements ITask {

	@Override
	public String name() {
		return "Model layouter";
	}

	@Override
	public Object run(Object modelManager) throws Exception {
		ITraverserStrategy strategy = new TraverseChildrenAfterInportsStrategy();
		ITraverserDelegate delegate = new LayouterDelegate();
		return runAfterInit((IModelManager) modelManager, strategy, delegate);
	}

}
