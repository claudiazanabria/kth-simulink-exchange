package se.kth.md.simulinkExchange.popup.actions.atl;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.Sequence;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JMock.class)
public class ConverterTest {

	private static final int RESULT = 2;
	ITasksExecutor aConverter 	= new TasksExecutor();
	Mockery context 			= new JUnit4Mockery();

	IJobMonitor jobMonitorMock 	= context.mock(IJobMonitor.class); 
	ITask taskMock 	= context.mock(ITask.class);
	Sequence aSequence 			= context.sequence("aSequence");

	@Test
	public void interactionWtihJobMonitorTest() throws Exception {
		
		context.checking(new Expectations() {{
			oneOf (jobMonitorMock).beginTaskList(with(any(String.class)),with(any(Integer.class)));
				inSequence(aSequence);
			
			oneOf (jobMonitorMock).operationHasBeenCanceled();
				will( returnValue(false));
				inSequence(aSequence);
				
			oneOf (jobMonitorMock).taskStarted(with(taskMock));
				inSequence(aSequence);
			
			oneOf (taskMock).run(with(anything()));
			    will( returnValue(RESULT) );	
				inSequence(aSequence);
				
			oneOf (jobMonitorMock).taskCompleted(with(taskMock));
		    	inSequence(aSequence);			    	
		}} );		
		
		aConverter.addTask( taskMock ); 

		IStatus status = aConverter.executeAllTasksNotifyingMonitor( jobMonitorMock );
		
		assertEquals(status,Status.OK_STATUS);

	}
		
	@Test
	public void jobMonitorCancelsOperationTest() throws Exception {
	
		context.checking(new Expectations() {{			
			oneOf (jobMonitorMock).operationHasBeenCanceled();
				will( returnValue(true));
	
			never (jobMonitorMock).taskCompleted(with(taskMock));
			
			ignoring(jobMonitorMock);
				
			never (taskMock).run(anything());
			ignoring(taskMock);
			
		}} );		
		
		aConverter.addTask( taskMock ); 
	
		IStatus status = aConverter.executeAllTasksNotifyingMonitor( jobMonitorMock );
		
		assertEquals(status,Status.CANCEL_STATUS);
	
	}

	@Test
	public void executionOfAllTasktsTest() throws Exception {
		
		context.checking(new Expectations() {{
			exactly(3).of (taskMock).run(with(anything()));
			    will( returnValue(RESULT) );	
				
			ignoring (jobMonitorMock);
		}} );		
		
		aConverter.addTask( taskMock ); 
		aConverter.addTask( taskMock ); 
		aConverter.addTask( taskMock ); 

		assertEquals(3, aConverter.taskCount() );
		
		IStatus status = aConverter.executeAllTasksNotifyingMonitor( jobMonitorMock );
		
		assertEquals(status,Status.OK_STATUS);

	}

	@Test
	public void argumentPassingBetweenTasksTest() throws Exception {

		context.checking(new Expectations() {{			
			oneOf (taskMock).run(with(anything()));
			    will( returnValue(RESULT) );	
			    inSequence(aSequence);
			    
			oneOf (taskMock).run( RESULT );
				inSequence(aSequence);
				
			ignoring(taskMock);
			ignoring (jobMonitorMock);
			
		}} );		
		
		aConverter.addTask( taskMock ); 
		aConverter.addTask( taskMock ); 

		IStatus status = aConverter.executeAllTasksNotifyingMonitor( jobMonitorMock );
		
		assertEquals(status,Status.OK_STATUS);

	}

	@Test
	public void nameNotNullTest() {
		assertNotNull(aConverter.name());
	}
	
	@Test(expected=Exception.class)
	public void failingTaksShouldThrowExeception() throws Exception {
		
		context.checking(new Expectations() {{			
			oneOf (taskMock).run(with(anything()));
			    will(throwException(new Exception()));
			    
			never (jobMonitorMock).taskCompleted(with(taskMock));				
			ignoring (jobMonitorMock);
			
		}} );		

		aConverter.addTask( taskMock );
		aConverter.executeAllTasksNotifyingMonitor( jobMonitorMock );
	}
	
}
