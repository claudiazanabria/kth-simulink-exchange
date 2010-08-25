package se.kth.md.simulinkExchange.popup.actions.atl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

public class Converter implements ITasksExecutor {

	List<IConverterTask> taskList;
	
	public Converter() {
		taskList = new ArrayList<IConverterTask>();
	}
	
	@Override
	public String name() {
		return "Subclass should implement";
	}

	@Override
	public List<IConverterTask> tasks() {
		return taskList;
	}

	@Override
	public void addTask(IConverterTask aTask) {
		taskList.add( aTask );
	}

	@Override
	public IStatus executeAllTasksNotifyingMonitor(IJobMonitor jobMonitor) throws Exception {

		jobMonitor.beginTaskList(this.name(), this.taskCount());
		
		Object result = null;
		for (IConverterTask aTask : taskList) {
			
			if ( jobMonitor.operationHasBeenCanceled() ) { 
				return Status.CANCEL_STATUS; }
			
			jobMonitor.taskStarted( aTask );
			result = aTask.run( result );
			jobMonitor.taskCompleted( aTask );
		}
		return Status.OK_STATUS;
	}

	@Override
	public int taskCount() {
		return taskList.size();
	}

}
