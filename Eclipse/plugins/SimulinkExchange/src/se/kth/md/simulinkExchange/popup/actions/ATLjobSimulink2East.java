/**
 * 
 */
package se.kth.md.simulinkExchange.popup.actions;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;

import se.kth.md.simulinkExchange.atl.ATLrunConfiguration;
import se.kth.md.simulinkExchange.atl.URInotFound;

public class ATLjobSimulink2East extends ATLjob {

	public ATLjobSimulink2East(IPath aPath) {
		super("Converting to EAST-ADL", aPath);
		atlSource = URI.createFileURI("./resources/ATL/simulink2east.atl");
	}

	public void addSources(ATLrunConfiguration config) throws URInotFound {
		simulinkModel = URI.createFileURI( inModelPath.toString() );
		config.addSource(simulinkModel, ATLrunConfiguration.simulinkMetaModel);
	}

	public void addDestination(ATLrunConfiguration config) throws URInotFound {
		// TODO: Ugly hack to create a copy...
		umlModel.trimFileExtension().appendFileExtension("uml");
		config.addDestination(umlModel, ATLrunConfiguration.umlMetaModel);
		config.addDestination(umlModel, ATLrunConfiguration.eastMetaModel);
		
	}
}
