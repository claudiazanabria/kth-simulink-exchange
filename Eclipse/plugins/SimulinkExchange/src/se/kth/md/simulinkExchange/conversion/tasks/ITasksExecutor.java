package se.kth.md.simulinkExchange.conversion.tasks;

import java.util.List;

import org.eclipse.core.runtime.IStatus;  

import se.kth.md.simulinkExchange.popup.actions.IJobMonitor;

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
