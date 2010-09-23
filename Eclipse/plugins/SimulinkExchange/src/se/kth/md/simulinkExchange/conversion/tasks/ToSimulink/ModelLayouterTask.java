package se.kth.md.simulinkExchange.conversion.tasks.ToSimulink;


import se.kth.md.simulinkExchange.conversion.ToSimulink.TraversalForLayoutStrategy;
import se.kth.md.simulinkExchange.conversion.tasks.ITask;
import se.kth.md.simulinkExchange.management.IModelManager;

public class ModelLayouterTask extends StrategyBasedTraversalTask implements ITask {

	@Override
	public String name() {
		return "Model layouter";
	}

	@Override
	public Object run(Object modelManager) throws Exception {
		TraversalForLayoutStrategy strategyAndDelegate = new TraversalForLayoutStrategy();
		return runAfterInit((IModelManager) modelManager, strategyAndDelegate, strategyAndDelegate);
	}

}
