package se.kth.md.simulinkExchange.popup.actions.atl.simulink2east;

import org.eclipse.emf.common.util.URI;

import se.kth.md.simulinkExchange.atl.ATLrunConfiguration;
import se.kth.md.simulinkExchange.atl.URInotFound;
import se.kth.md.simulinkExchange.popup.actions.atl.IConverterTask;

public class ConfigureATLConverterTask 	
	extends se.kth.md.simulinkExchange.popup.actions.atl.ConfigureATLConverterTask 
	implements IConverterTask {
	
	public ConfigureATLConverterTask(URI clickedFile) {
		super(clickedFile);
		ATL_BINARY = "./resources/ATL/simulink2east.asm";
		ATL_SOURCE = "./resources/ATL/simulink2east.atl";
	}

	@Override
	protected void addSources(ATLrunConfiguration config) throws URInotFound {
		//simulinkModel = URI.createFileURI( inModelPath.toString() );
		config.addSource(srcModel, ATLrunConfiguration.simulinkMetaModel);
	}
	
	@Override
	protected void addDestination(ATLrunConfiguration config) throws URInotFound {
		boolean atl_Bug_cannotProduceSingleOutputFromTwoMetamodels = true;
		if ( atl_Bug_cannotProduceSingleOutputFromTwoMetamodels ) {
			useThisHackInstead( config ); 
		} else {
			// Original code
			URI umlModel = srcModel.trimFileExtension().appendFileExtension("uml");
			config.addDestination(umlModel, ATLrunConfiguration.umlMetaModel);
			config.addDestination(umlModel, ATLrunConfiguration.eastMetaModel);
		}
	}
	
	public void useThisHackInstead(ATLrunConfiguration config) throws URInotFound {
		URI umlModel1 = srcModel.trimFileExtension().appendFileExtension("1.uml");
		URI umlModel2 = srcModel.trimFileExtension().appendFileExtension("2.uml");
		//URI resultUML = simulinkModel.trimFileExtension().appendFileExtension("uml");
		config.addDestination(umlModel1, ATLrunConfiguration.umlMetaModel);
		config.addDestination(umlModel2, ATLrunConfiguration.eastMetaModel);
	}

}
