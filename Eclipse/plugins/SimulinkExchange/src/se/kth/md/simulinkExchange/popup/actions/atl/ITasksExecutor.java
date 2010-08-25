package se.kth.md.simulinkExchange.popup.actions.atl;

import java.util.List;

import org.eclipse.core.runtime.IStatus;  

/**
 * An IConverter can execute all its tasks.
 * ITasksExecutor
 * @author alex
 *
 */
public interface ITasksExecutor {

	String name();

	List<ITask> tasks();

	void addTask(ITask taskOneMock);

	IStatus executeAllTasksNotifyingMonitor(IJobMonitor jobMonitor) throws Exception;

	int taskCount();

}
