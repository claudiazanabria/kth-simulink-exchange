package se.kth.md.simulinkExchange.popup.actions.atl;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;

import se.kth.md.simulinkExchange.atl.ATLrunConfiguration;
import se.kth.md.simulinkExchange.atl.URInotFound;

public class TheJobEast2Simulink extends TheJob {

	public TheJobEast2Simulink(IPath aPath) {
		super("Converting to Simlink", aPath);
		atlSource = URI.createFileURI("./resources/ATL/east2simulink.atl");
	}

	public void addSources(ATLrunConfiguration config) throws URInotFound {
		umlModel = URI.createFileURI( inModelPath.toString() );
		config.addSource(umlModel, ATLrunConfiguration.umlMetaModel);
		config.addSource(umlModel, ATLrunConfiguration.eastMetaModel);
	}

	public void addDestination(ATLrunConfiguration config) throws URInotFound {
		simulinkModel = umlModel.trimFileExtension().appendFileExtension("simulink");
		config.addDestination(simulinkModel, ATLrunConfiguration.simulinkMetaModel);
	}

}
