package se.kth.md.simulinkExchange.conversion.tasks.ToEast;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;

import se.kth.md.simulinkExchange.conversion.tasks.RunATLTask;
import se.kth.md.simulinkExchange.conversion.tasks.TasksExecutor;

/**
 * This class builds an executor, with all tasks needed 
 * for a conversion from simulink to EAST.
 * 
 * @author alex
 */ 
public class ExecutorBuilder {

	public static TasksExecutor doIt(IPath selectedFilename) {
		URI simulinkModel = URI.createFileURI( selectedFilename.toString() );
		
		TasksExecutor executor = new TasksExecutor();
		executor.addTask( new ATLConfigurationBuilderTask( simulinkModel ) );
		executor.addTask( new RunATLTask() );
		return executor;
	}
	
}
