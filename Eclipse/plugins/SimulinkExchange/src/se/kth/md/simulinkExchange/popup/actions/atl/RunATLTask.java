package se.kth.md.simulinkExchange.popup.actions.atl;

import se.kth.md.simulinkExchange.atl.ATLrunConfiguration;
import se.kth.md.simulinkExchange.atl.ATLrunner;

public class RunATLTask implements ITask {

	//TODO this class is not tested
	
	@Override
	public String finalMessage() {
		return name() + ", completed.";
	}

	@Override
	public String name() {
		return "Run ATL transformation";
	}

	@Override
	public Object run(Object config) throws Exception {
		ATLrunner.with( (ATLrunConfiguration) config );	
		return config;
	}

}
