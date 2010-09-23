package se.kth.md.simulinkExchange.conversion.tasks;

import org.eclipse.emf.common.util.URI;

import se.kth.md.simulinkExchange.PluginServices;
import se.kth.md.simulinkExchange.atlHelper.ATLrunConfiguration;
import se.kth.md.simulinkExchange.atlHelper.URInotFound;

/**
 * This task builds an ATL configuration by creating 
 * a new ATLConfigurationObject, with proper src and dst references.
 * 
 * @author alex
 */
public abstract class ATLConfigurationBuilderTask {

	protected String ATL_SOURCE;
	protected String ATL_BINARY;
	
	protected URI srcModel;
	
	public ATLConfigurationBuilderTask(URI clickedFile) {
		this.srcModel = clickedFile;
	}
	
	public String finalMessage() {
		return name() + " completed.";
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
