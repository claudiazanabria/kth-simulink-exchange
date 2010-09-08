package se.kth.md.simulinkExchange.popup.actions.atl.east2simulink;


import se.kth.md.simulinkExchange.conversion.ToSimulink.postprocessing.TraversalForLayoutStrategy;
import se.kth.md.simulinkExchange.management.IModelManager;
import se.kth.md.simulinkExchange.popup.actions.atl.ITask;

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
