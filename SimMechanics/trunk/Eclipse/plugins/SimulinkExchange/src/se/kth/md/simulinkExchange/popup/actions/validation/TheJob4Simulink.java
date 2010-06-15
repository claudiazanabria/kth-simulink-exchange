package se.kth.md.simulinkExchange.popup.actions.validation;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;

import se.kth.md.simulinkExchange.management.simulink.SimulinkModelManager;

public class TheJob4Simulink extends TheJob {

	protected TheJob4Simulink(String name, IPath aPath) {
		super( name, aPath);
		URI modelFile = URI.createFileURI( inModelPath.toString() );
		modelManager = new SimulinkModelManager( modelFile );
	}
}
