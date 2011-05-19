package se.kth.md.simulinkExchange.popup.actions.validation;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;

import se.kth.md.simulinkExchange.management.east.EastModelManager;

public class TheJob4East extends TheJob {

	protected TheJob4East(String name, IPath aPath) {
		super( name, aPath);
		URI modelFile = URI.createFileURI( inModelPath.toString() );
		modelManager = new EastModelManager( modelFile );
	}

}
