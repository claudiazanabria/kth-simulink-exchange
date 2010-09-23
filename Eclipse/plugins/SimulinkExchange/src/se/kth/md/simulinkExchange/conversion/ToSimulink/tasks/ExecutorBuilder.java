package se.kth.md.simulinkExchange.conversion.ToSimulink.tasks;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;

import se.kth.md.simulinkExchange.conversion.tasks.RunATLTask;
import se.kth.md.simulinkExchange.conversion.tasks.TasksExecutor;

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
		executor.addTask( new GetModelManagerTask() );
		executor.addTask( new NameTraverserTask() );
		executor.addTask( new ModelLayouterTask() );
		return executor;
	}

	//	ATLrunner.with( config );		

	
}
