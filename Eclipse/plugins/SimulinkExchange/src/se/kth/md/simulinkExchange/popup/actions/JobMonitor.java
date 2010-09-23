package se.kth.md.simulinkExchange.popup.actions;

import org.eclipse.core.runtime.IProgressMonitor;

import se.kth.md.simulinkExchange.conversion.tasks.ITask;

/**
 * This is a simple wrapper for an Eclipse job monitor.
 * It does not actually adds lots of functionality, only easier names.
 * The interface IJobMonitor is needed for jMock.
 * 
 * @author alex
 *
 */
public class JobMonitor implements IJobMonitor {

	IProgressMonitor monitor;
	final int SCALE = 100;
	
	public JobMonitor(IProgressMonitor monitor) {
		this.monitor = monitor;
	}
	
	@Override
	public boolean operationHasBeenCanceled() {
		return monitor.isCanceled();
	}

	@Override
	public void taskCompleted(ITask aTask) {
		monitor.worked(1*SCALE);
	}

	@Override
	public void beginTaskList(String name, int taskCount) {
		monitor.beginTask(name, taskCount*SCALE);
	}

	@Override
	public void taskStarted(ITask aTask) {
		monitor.subTask( aTask.name() );
		
	}

}
