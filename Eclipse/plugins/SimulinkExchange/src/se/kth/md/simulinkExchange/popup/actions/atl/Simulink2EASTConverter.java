package se.kth.md.simulinkExchange.popup.actions.atl;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;

public class Simulink2EASTConverter extends Converter {

	protected URI umlModel;
	
	public Simulink2EASTConverter(IPath selectedFilename) {
		super();
		umlModel = URI.createFileURI( selectedFilename.toString() );
		
		//this.addTask( new ConfigureATLtransformationTask( umlModel ) );
		//this.addTask( new RunATLTask() );
		//TODO Add taks for combining UML and EAST files.
	}
	
}
