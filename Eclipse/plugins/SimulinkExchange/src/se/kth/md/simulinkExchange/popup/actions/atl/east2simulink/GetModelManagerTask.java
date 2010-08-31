package se.kth.md.simulinkExchange.popup.actions.atl.east2simulink;

import org.eclipse.emf.common.util.URI;

import se.kth.md.simulinkExchange.atl.ATLrunConfiguration;
import se.kth.md.simulinkExchange.management.IModelManager;
import se.kth.md.simulinkExchange.management.simulink.SimulinkModelManager;
import se.kth.md.simulinkExchange.popup.actions.atl.ITask;

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
