package se.kth.md.simulinkExchange.popup.actions;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

import se.kth.md.simulinkExchange.Activator;
import se.kth.md.simulinkExchange.conversion.tasks.ITasksExecutor;

/**
 * This class will execute tasks in the background, through a tasksExecutor.
 * 
 * @author alex
 *
 */
public class BackgroundJob extends Job {

	protected ITasksExecutor converter;
	protected Activator plugin;
	
	public BackgroundJob(ITasksExecutor converter) {
		super( converter.name() );
		this.converter = converter;
		plugin = Activator.getDefault();
	}
	
	@Override
	protected IStatus run(IProgressMonitor monitor) {
		IStatus result = Status.CANCEL_STATUS;
		
		plugin.log("started job", Status.INFO);  
		try {
			result = converter.executeAllTasksNotifyingMonitor( new JobMonitor(monitor) );			
		} catch (Exception e) {
			plugin.log(e.getMessage(), Status.ERROR, e);
		} finally {
			monitor.done();
		}
		
		return result;	
	}

}
