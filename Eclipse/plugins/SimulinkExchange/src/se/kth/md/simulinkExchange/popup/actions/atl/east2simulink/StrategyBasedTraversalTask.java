package se.kth.md.simulinkExchange.popup.actions.atl.east2simulink;

import java.io.IOException;

import Simulink.Model;
import se.kth.md.simulinkExchange.conversion.ToSimulink.postprocessing.ITraverserDelegate;
import se.kth.md.simulinkExchange.conversion.ToSimulink.postprocessing.ITraverserStrategy;
import se.kth.md.simulinkExchange.management.IModelManager;
import se.kth.md.simulinkExchange.management.exceptions.InvalidModelException;
import se.kth.md.simulinkExchange.popup.actions.atl.ITask;

public abstract class StrategyBasedTraversalTask implements ITask {

	public StrategyBasedTraversalTask() {
		super();
	}

	public abstract Object run(Object modelManager) throws Exception;

	public abstract String name();

	@Override
	public String finalMessage() {
		return name()+ ", completed.";
	}

	protected Object runAfterInit(IModelManager manager, ITraverserStrategy strategy, ITraverserDelegate delegate)
			throws InvalidModelException, IOException {
				
				manager.loadIt();
				Model model = (Model) manager.getTopElement();
				strategy.doIt(model, delegate);
				manager.saveIt();
				return manager;
			}

}