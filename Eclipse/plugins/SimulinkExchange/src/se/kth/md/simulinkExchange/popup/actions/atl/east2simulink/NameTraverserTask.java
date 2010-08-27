package se.kth.md.simulinkExchange.popup.actions.atl.east2simulink;

import org.eclipse.emf.common.util.URI;

import se.kth.md.simulinkExchange.conversion.ToSimulink.postprocessing.NameTraverser;
import se.kth.md.simulinkExchange.management.IModelManager;
import se.kth.md.simulinkExchange.management.simulink.SimulinkModelManager;
import se.kth.md.simulinkExchange.popup.actions.atl.ITask;

/**
 * This task will run the name traverser on the given filename (model).
 * 
 * @author alex
 *
 */
public class NameTraverserTask implements ITask {

	@Override
	public String finalMessage() {
		return name() + ", completed.";
	}

	@Override
	public String name() {
		return "Name traverser";
	}

	@Override
	public Object run(Object simulinkModel) throws Exception {
		IModelManager manager = new SimulinkModelManager( (URI) simulinkModel );
		manager.loadIt();
		manager.acceptVisitor( new NameTraverser() );
		//manager.traverseWith( new NameTraverser() );
		manager.saveIt();
		return null;
	}

}
