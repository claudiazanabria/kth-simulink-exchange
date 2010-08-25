package se.kth.md.simulinkExchange.popup.actions.atl.east2simulink;

import org.eclipse.emf.common.util.URI;

import se.kth.md.simulinkExchange.atl.ATLrunConfiguration;
import se.kth.md.simulinkExchange.atl.URInotFound;
import se.kth.md.simulinkExchange.popup.actions.atl.IConverterTask;

public class ConfigureATLConverterTask 
	extends se.kth.md.simulinkExchange.popup.actions.atl.ConfigureATLConverterTask 
	implements IConverterTask {

	public ConfigureATLConverterTask(URI clickedFile) {
		super(clickedFile);
		ATL_BINARY = "./resources/ATL/east2simulink.asm";
		ATL_SOURCE = "./resources/ATL/east2simulink.atl";
	}
	
	@Override
	protected void addSources(ATLrunConfiguration config) throws URInotFound {
		config.addSource(srcModel, ATLrunConfiguration.umlMetaModel);
		config.addSource(srcModel, ATLrunConfiguration.eastMetaModel);
	}

	@Override
	protected void addDestination(ATLrunConfiguration config) throws URInotFound {
		URI simulinkModel = srcModel.trimFileExtension().appendFileExtension("simulink");
		config.addDestination(simulinkModel, ATLrunConfiguration.simulinkMetaModel);
	}

}
