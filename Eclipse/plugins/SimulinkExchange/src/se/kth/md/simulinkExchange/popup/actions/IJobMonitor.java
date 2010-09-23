package se.kth.md.simulinkExchange.popup.actions;

import se.kth.md.simulinkExchange.conversion.tasks.ITask;

public interface IJobMonitor {
	
	public boolean operationHasBeenCanceled();


	public void beginTaskList(String name, int taskCount);

	public void taskStarted(ITask aTask);
	public void taskCompleted(ITask aTask);
}
