package se.kth.md.simulinkExchange.atl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.m2m.atl.common.ATLLaunchConstants;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.launch.ILauncher;
import org.eclipse.m2m.atl.core.service.CoreService;
import org.eclipse.m2m.atl.core.service.LauncherService;

public class ATLrunner {
	
	protected ATLrunConfiguration config;
	
	public static void with(ATLrunConfiguration config) 
		throws NullPointerException, ATLCoreException, IOException {
		
		ATLrunner runner = new ATLrunner();
		runner.runWith(config);
	}
		
	public void runWith(ATLrunConfiguration config) 
		throws NullPointerException, ATLCoreException, IOException {
	
		this.config = config;
		
		Map<String, String> paths 			= config.getPathsMap();
		Map<String, String> inModels 		= config.getInModelsIDMap();
		Map<String, String> outModels 		= config.getOutModelsIDMap();
		Map<String, String> inoutModels 	= config.getInOutModelsIDMap();
		Map<String, Object> options 		= new HashMap<String, Object>();
		Map<String, String> modelHandlers 	= config.defineModelHandlers();
		Map<String, InputStream> libraries 	= Collections.emptyMap();
		
		options.put(ATLLaunchConstants.OPTION_MODEL_HANDLER, modelHandlers);		
		InputStream[] modules 	= this.compiledTransformations(); 
		ILauncher atlVM 		= this.initializeATLVM();

		LauncherService.launch("run", null, atlVM, inModels, inoutModels,
				outModels, paths, options, libraries, modules);
	}


	protected InputStream[] compiledTransformations() throws IOException {
		InputStream[] modules = new InputStream[1];
		modules[0] = config.getCompiledTransformationAsStream();
		return modules;
	}

	protected ILauncher initializeATLVM() throws NullPointerException, ATLCoreException {
		ILauncher atlVM = CoreService.getLauncher("EMF-specific VM");
		if (atlVM == null) {
			throw new NullPointerException("Could NOT get an EMF ATL-VM!");
		}
		return atlVM;
	}

}
