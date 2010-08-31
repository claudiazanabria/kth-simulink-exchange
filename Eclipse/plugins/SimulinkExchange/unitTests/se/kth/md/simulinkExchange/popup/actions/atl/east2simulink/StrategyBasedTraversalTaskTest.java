package se.kth.md.simulinkExchange.popup.actions.atl.east2simulink;


import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.Sequence;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Test;
import org.junit.runner.RunWith;

import se.kth.md.simulinkExchange.conversion.ToSimulink.postprocessing.ITraverserDelegate;
import se.kth.md.simulinkExchange.conversion.ToSimulink.postprocessing.ITraverserStrategy;
import se.kth.md.simulinkExchange.management.IModelManager;
import se.kth.md.simulinkExchange.management.exceptions.InvalidModelException;
import Simulink.Model;

@RunWith(JMock.class)
public abstract class StrategyBasedTraversalTaskTest {

	Mockery context 		= new JUnit4Mockery();
	Model	modelMock	= context.mock(Model.class);
	ITraverserDelegate delegateMock = context.mock(ITraverserDelegate.class);
	ITraverserStrategy strategyMock = context.mock(ITraverserStrategy.class);
	IModelManager managerMock = context.mock(IModelManager.class);
	
	Sequence aSequence 	= context.sequence("aSequence");
	
	StrategyBasedTraversalTask task;
	
	@Test
	public void runAfterInitTest() throws InvalidModelException, IOException {
		
		context.checking(new Expectations() {{
			
			oneOf (managerMock).loadIt();
				inSequence(aSequence);
				
			oneOf (managerMock).getTopElement();
				will(returnValue(modelMock));
				inSequence(aSequence);
			
			oneOf (strategyMock).doIt(with(modelMock), with(delegateMock));
				inSequence(aSequence);
				
			oneOf (managerMock).saveIt();
				inSequence(aSequence);
				
		}} );
		
		Object result = task.runAfterInit(managerMock, strategyMock, delegateMock);
		assertEquals( managerMock, result );
	}
}
