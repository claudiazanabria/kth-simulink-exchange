package se.kth.md.simulinkExchange.conversion.tasks.ToSimulink;

import org.eclipse.emf.common.util.URI;

import se.kth.md.simulinkExchange.atlHelper.ATLrunConfiguration;
import se.kth.md.simulinkExchange.conversion.tasks.ITask;
import se.kth.md.simulinkExchange.management.IModelManager;
import se.kth.md.simulinkExchange.management.simulink.SimulinkModelManager;

public class GetModelManagerTask implements ITask {

	@Override
	public String finalMessage() {
		return name() + ", completed.";
	}

	@Override
	public String name() {
		return "Run ATL transformation";
	}

	/**
	 * Obtain the filename from the ATL configuration, this is a newly
	 * created file.
	 * 
	 */
	@Override
	public Object run(Object argument) throws Exception {
		ATLrunConfiguration config = (ATLrunConfiguration) argument;
		URI simulinkModel = config.getSimulinkFileNameHack();
		IModelManager manager = new SimulinkModelManager( simulinkModel );
		return manager;
	}

}
