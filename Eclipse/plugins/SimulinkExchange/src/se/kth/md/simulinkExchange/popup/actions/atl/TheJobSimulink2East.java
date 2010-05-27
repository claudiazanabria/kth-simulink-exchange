/**
 * 
 */
package se.kth.md.simulinkExchange.popup.actions.atl;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;

import se.kth.md.simulinkExchange.atl.ATLrunConfiguration;
import se.kth.md.simulinkExchange.atl.URInotFound;

public class TheJobSimulink2East extends TheJob {

	public TheJobSimulink2East(IPath aPath) {
		super("Converting to EAST-ADL", aPath);
		atlSource = URI.createFileURI("./resources/ATL/simulink2east.atl");
	}

	public void addSources(ATLrunConfiguration config) throws URInotFound {
		simulinkModel = URI.createFileURI( inModelPath.toString() );
		config.addSource(simulinkModel, ATLrunConfiguration.simulinkMetaModel);
	}

	public void addDestination(ATLrunConfiguration config) throws URInotFound {
		umlModel = simulinkModel.trimFileExtension().appendFileExtension("uml");
		config.addDestination(umlModel, ATLrunConfiguration.umlMetaModel);
		config.addDestination(umlModel, ATLrunConfiguration.eastMetaModel);
		
	}
}
