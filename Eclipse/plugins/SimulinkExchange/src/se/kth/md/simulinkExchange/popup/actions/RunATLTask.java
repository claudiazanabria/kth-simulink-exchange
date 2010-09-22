package se.kth.md.simulinkExchange.popup.actions;

import se.kth.md.simulinkExchange.atlHelper.ATLrunConfiguration;
import se.kth.md.simulinkExchange.atlHelper.ATLrunner;

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

	void alex() {
		//Transformation.
	}
}
