package se.kth.md.simulinkExchange.popup.actions.atl;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;

import se.kth.md.simulinkExchange.PluginServices;
import se.kth.md.simulinkExchange.atl.ATLrunConfiguration;
import se.kth.md.simulinkExchange.atl.ATLrunner;
import se.kth.md.simulinkExchange.atl.URInotFound;

public class EAST2SimulinkConverter extends Converter {
	
	//Three tasks
//	this.addTaks( new configureATLTask() );
//	this.addTask( new runATLTask() );
//	this.addTask( new workaroundBullshitTask() );
	
	private static final String ATL_COMPILED = "./resources/ATL/east2simulink.asm";
	private static final String ATL_SOURCE = "./resources/ATL/east2simulink.atl";
	
	protected URI umlModel;
	protected URI simulinkModel;

	public EAST2SimulinkConverter(IPath selectedFilename) {
		umlModel = URI.createFileURI( selectedFilename.toString() );
	}

	@Override
	public String name() {
		return "Converting to Simlink";
	}

	//	ATLrunner.with( config );		

	
}
