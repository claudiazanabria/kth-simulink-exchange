package se.kth.md.simulinkExchange.popup.actions.atl;

import org.eclipse.emf.common.util.URI;

import se.kth.md.simulinkExchange.PluginServices;
import se.kth.md.simulinkExchange.atl.ATLrunConfiguration;
import se.kth.md.simulinkExchange.atl.URInotFound;

public abstract class ConfigureATLConverterTask {

	protected String ATL_SOURCE;
	protected String ATL_BINARY;
	
	protected URI srcModel;
	
	public ConfigureATLConverterTask(URI clickedFile) {
		this.srcModel = clickedFile;
	}
	
	public String finalMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	public String name() {
		return "Creating an ATL configration";
	}

	public Object run(Object argument) throws URInotFound {
		URI atlSource 	= PluginServices.lookUpAbsolutePathWithinPlugin(ATL_SOURCE);
		URI atlCompiled = PluginServices.lookUpAbsolutePathWithinPlugin(ATL_BINARY);

		ATLrunConfiguration config = new ATLrunConfiguration( atlSource, atlCompiled );
		addSources(config);
		addDestination(config);		
		return config;
	}

	abstract protected void addDestination(ATLrunConfiguration config) throws URInotFound;
	abstract protected void addSources(ATLrunConfiguration config) throws URInotFound;

}
