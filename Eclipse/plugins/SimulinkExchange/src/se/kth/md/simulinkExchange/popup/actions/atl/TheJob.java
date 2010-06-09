/**
 * 
 */
package se.kth.md.simulinkExchange.popup.actions.atl;

import java.io.IOException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.ui.statushandlers.StatusManager;
import org.osgi.framework.Bundle;

import se.kth.md.simulinkExchange.Activator;
import se.kth.md.simulinkExchange.atl.ATLrunConfiguration;
import se.kth.md.simulinkExchange.atl.ATLrunner;
import se.kth.md.simulinkExchange.atl.URInotFound;


/**
 * @author alesch
 *
 */
public abstract class TheJob extends Job {

	protected IPath inModelPath;
	protected Activator plugin;
	protected Bundle pluginBundle;
	
	protected URI atlSource;
	protected URI umlModel;
	protected URI simulinkModel;
	

	protected TheJob(String name, IPath aPath) {
		super(name);
		this.inModelPath = aPath;
		plugin = Activator.getDefault();
		pluginBundle = Platform.getBundle(Activator.PLUGIN_ID);

	}

	protected void initJob(String atlSourcePath) {
		try {
			Path atlPath = new Path( atlSourcePath ); 
			URL urlWithBundleProtocol 	= FileLocator.find(pluginBundle, atlPath, null);
			URL urlWithFileProtocol 	= FileLocator.toFileURL( urlWithBundleProtocol );
			String fileURLAsString 		= urlWithFileProtocol.getFile();
			atlSource = URI.createFileURI( fileURLAsString );
		} catch (IOException e) {
			plugin.log("Internal error: ATL source not bundled within plugin.", Status.ERROR, e);
			Status status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, "ATL source not found. See Error log for details.");
			StatusManager.getManager().handle(status, StatusManager.SHOW);
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.jobs.Job#run(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	protected IStatus run(IProgressMonitor monitor) {
		ATLrunConfiguration config;
		int activitiesTotal = 2;
		int scale = 100;
		
		plugin.log("started job", Status.INFO);
		try {
			monitor.beginTask("Converting", activitiesTotal*scale);

			if (monitor.isCanceled()) return Status.CANCEL_STATUS;			
			monitor.subTask("Configure transformation");
			config = this.configureTransformation();
			monitor.worked(1*scale);
			plugin.log("ATL configuration ready", Status.INFO);
			
			if (monitor.isCanceled()) return Status.CANCEL_STATUS;
			monitor.subTask("Run transformation");
			ATLrunner.with( config );		
			monitor.worked(1*scale);
			plugin.log("ATL run done", Status.INFO);
			
		} catch (Exception e) {
			plugin.log("exception thrown", Status.ERROR, e);
			e.printStackTrace();
			
		} finally {
			monitor.done();
		}
		
		return Status.OK_STATUS;
	}

	protected ATLrunConfiguration configureTransformation() throws URInotFound {
		ATLrunConfiguration config = new ATLrunConfiguration( atlSource );
		addSources(config);
		addDestination(config);
		return config;
	}

	abstract void addDestination(ATLrunConfiguration config) throws URInotFound;
	abstract void addSources(ATLrunConfiguration config) throws URInotFound;

}
