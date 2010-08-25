package se.kth.md.simulinkExchange.popup.actions.atl;

public interface IJobMonitor {
	
	public boolean operationHasBeenCanceled();


	public void beginTaskList(String name, int taskCount);

	public void taskStarted(IConverterTask aTask);
	public void taskCompleted(IConverterTask aTask);
}
