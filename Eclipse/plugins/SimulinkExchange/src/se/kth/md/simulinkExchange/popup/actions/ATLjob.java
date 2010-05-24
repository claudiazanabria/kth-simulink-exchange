/**
 * 
 */
package se.kth.md.simulinkExchange.popup.actions;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;

import se.kth.md.simulinkExchange.Activator;
import se.kth.md.simulinkExchange.atl.ATLrunConfiguration;
import se.kth.md.simulinkExchange.atl.ATLrunner;
import se.kth.md.simulinkExchange.atl.URInotFound;


/**
 * @author alesch
 *
 */
public abstract class ATLjob extends Job {

	protected IPath inModelPath;
	protected Activator plugin;
	
	protected URI atlSource;
	protected URI umlModel;
	protected URI simulinkModel;
	

	protected ATLjob(String name, IPath aPath) {
		super(name);
		this.inModelPath = aPath;
		plugin = Activator.getDefault();
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
