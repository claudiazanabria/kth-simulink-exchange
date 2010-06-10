/**
 * 
 */
package se.kth.md.simulinkExchange.popup.actions.atl;

import java.io.IOException;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;

import se.kth.md.simulinkExchange.atl.ATLrunConfiguration;
import se.kth.md.simulinkExchange.atl.URInotFound;
import se.kth.md.simulinkExchange.atl.XmlCombiner;

public class TheJobSimulink2East extends TheJob {

	/**
	 * Hack for ATL bug: Cannot produce a single file from two metamodels.
	 */
	URI umlModel1;
	URI umlModel2;
	URI resultUML;

	public TheJobSimulink2East(IPath aPath)  {
		super("Converting to EAST-ADL", aPath);
		this.initJob("./resources/ATL/simulink2east.atl");
	}

	public void addSources(ATLrunConfiguration config) throws URInotFound {
		simulinkModel = URI.createFileURI( inModelPath.toString() );
		config.addSource(simulinkModel, ATLrunConfiguration.simulinkMetaModel);
	}

	public void addDestination(ATLrunConfiguration config) throws URInotFound {
		boolean atl_Bug_cannotProduceSingleOutputFromTwoMetamodels = true;
		if ( atl_Bug_cannotProduceSingleOutputFromTwoMetamodels ) {
			useThisHackInstead( config ); 
		} else {
			// Original code
			umlModel = simulinkModel.trimFileExtension().appendFileExtension("uml");
			config.addDestination(umlModel, ATLrunConfiguration.umlMetaModel);
			config.addDestination(umlModel, ATLrunConfiguration.eastMetaModel);
		}
	}

	public void useThisHackInstead(ATLrunConfiguration config) throws URInotFound {
		umlModel1 = simulinkModel.trimFileExtension().appendFileExtension("1.uml");
		umlModel2 = simulinkModel.trimFileExtension().appendFileExtension("2.uml");
		resultUML = simulinkModel.trimFileExtension().appendFileExtension("uml");
		config.addDestination(umlModel1, ATLrunConfiguration.umlMetaModel);
		config.addDestination(umlModel2, ATLrunConfiguration.eastMetaModel);
	}
	
	/**
	 * ATL bug hack. 
	 */
	@Override
	protected IStatus run(IProgressMonitor monitor) {
		super.run(monitor);
		try {
			XmlCombiner.doIt(umlModel2, umlModel1, resultUML);
		} catch (IOException e) {
			plugin.log("Error in XmlCombiner", Status.ERROR, e);
			return Status.CANCEL_STATUS;
		}
		return Status.OK_STATUS;
	}
}
