package se.kth.md.simulinkExchange.popup.actions;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;

import se.kth.md.simulinkExchange.atl.ATLrunConfiguration;
import se.kth.md.simulinkExchange.atl.URInotFound;

public class ATLjobEast2Simulink extends ATLjob {

	public ATLjobEast2Simulink(IPath aPath) {
		super("Converting to Simlink", aPath);
		atlSource = URI.createFileURI("./resources/ATL/east2simulink.atl");
	}

	public void addSources(ATLrunConfiguration config) throws URInotFound {
		umlModel = URI.createFileURI( inModelPath.toString() );
		config.addSource(umlModel, ATLrunConfiguration.umlMetaModel);
		config.addSource(umlModel, ATLrunConfiguration.eastMetaModel);
	}

	public void addDestination(ATLrunConfiguration config) throws URInotFound {
		// TODO: Ugly hack to create a copy...
		simulinkModel = URI.createURI( umlModel.toString() );
		simulinkModel.trimFileExtension().appendFileExtension("simulink"); 
		config.addDestination(simulinkModel, ATLrunConfiguration.simulinkMetaModel);
	}

}
