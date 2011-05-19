package se.kth.md.simulinkExchange.popup.actions.validation;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.ui.statushandlers.StatusManager;

import se.kth.md.simulinkExchange.Activator;
import se.kth.md.simulinkExchange.management.ModelManager;
import se.kth.md.simulinkExchange.management.exceptions.InvalidModelException;

public abstract class TheJob extends Job {

	protected IPath inModelPath;
	protected Activator plugin;
	protected ModelManager modelManager;

	protected TheJob(String name, IPath aPath) {
		super(name);
		this.inModelPath = aPath;
		plugin = Activator.getDefault();
	}
	
	@Override
	protected IStatus run(IProgressMonitor monitor) {
		plugin.log("Validation job started.", Status.INFO);
		int activitiesTotal = 2;
		int scale = 100;

		try {
			monitor.beginTask("Validating", activitiesTotal*scale);

			if (monitor.isCanceled()) return Status.CANCEL_STATUS;			
			monitor.subTask("Opening model");
			modelManager.loadIt();
			monitor.worked(1*scale);
			plugin.log("Model opened.", Status.INFO);
			
			if (monitor.isCanceled()) return Status.CANCEL_STATUS;
			monitor.subTask("checking the model");
			modelManager.validateIt();
			monitor.worked(1*scale);
			plugin.log("Model validated.", Status.INFO);
			
		} catch (InvalidModelException e) {
			// FIXME: InvalidObjects do not show nicely.
			plugin.log("Invalid Model. Double click for details.", Status.ERROR, e);			
			Status status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Invalid model. See Error log for details."); 
			StatusManager.getManager().handle(status, StatusManager.SHOW);
			e.printStackTrace();
			
		} finally {
			monitor.done();
		}
		
		return Status.OK_STATUS;
	}

}

