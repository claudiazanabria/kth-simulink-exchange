package se.kth.md.simulinkExchange.popup.actions.east2simulink;

import java.util.ArrayList;

import se.kth.md.simulinkExchange.conversion.ToSimulink.ITraverserStrategy;
import se.kth.md.simulinkExchange.conversion.ToSimulink.TraverseChildrenBeforeInportsStrategy;
import se.kth.md.simulinkExchange.management.IModelManager;
import se.kth.md.simulinkExchange.popup.actions.ITask;
import Simulink.ProtoObject;

/**
 * This task can be used with an ExcutorBuilder from Java,
 * or from MATLAB directly.
 * 
 * From MATLAB, create a new instance, and call the run method.
 * @author alex
 *
 */
public class ListCreatorTask extends StrategyBasedTraversalTask implements ITask {

	@Override
	public String name() {
		return "List creator";
	}

	@Override
	public Object run(Object modelManager) throws Exception {
		ITraverserStrategy strategy = new TraverseChildrenBeforeInportsStrategy();
		ListCreatorDelegate delegate = new ListCreatorDelegate();
		runAfterInit((IModelManager) modelManager, strategy, delegate);
		return delegate.allElementsList();
	}

	@SuppressWarnings("unchecked")
	public static ArrayList<ProtoObject> fromMATLAB(IModelManager modelManager) throws Exception {
		ListCreatorTask task = new ListCreatorTask();
		return (ArrayList<ProtoObject>) task.run( modelManager );
	}
}
