package se.kth.md.simulinkExchange.popup.actions.atl.east2simulink;

import org.eclipse.emf.common.util.URI;

import se.kth.md.simulinkExchange.atl.ATLrunConfiguration;
import se.kth.md.simulinkExchange.popup.actions.atl.ITask;

public class GetResultingModelTask implements ITask {

	@Override
	public String finalMessage() {
		return name() + ", completed.";
	}

	@Override
	public String name() {
		return "Run ATL transformation";
	}

	@Override
	public Object run(Object argument) throws Exception {
		ATLrunConfiguration config = (ATLrunConfiguration) argument;
		URI simulinkModel = config.getFirstDestinationFileName();
		return simulinkModel;
	}

}
