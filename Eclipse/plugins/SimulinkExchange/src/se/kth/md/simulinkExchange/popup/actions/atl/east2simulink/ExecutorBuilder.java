package se.kth.md.simulinkExchange.popup.actions.atl.east2simulink;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;

import se.kth.md.simulinkExchange.popup.actions.atl.RunATLTask;
import se.kth.md.simulinkExchange.popup.actions.atl.TasksExecutor;

/**
 * This class builds an executor, with all tasks needed 
 * for a conversion from EAST to simulink.
 * 
 * @author alex
 */ 
public class ExecutorBuilder {

	public static TasksExecutor doIt(IPath selectedFilename) {
		URI umlModel = URI.createFileURI( selectedFilename.toString() );
		
		TasksExecutor executor = new TasksExecutor();
		executor.addTask( new ATLConfigurationBuilderTask( umlModel ) );
		executor.addTask( new RunATLTask() );
		executor.addTask( new GetResultingModelTask() );
		executor.addTask( new NameTraverserTask() );
		
		return executor;
	}

	//	ATLrunner.with( config );		

	
}
