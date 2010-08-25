package se.kth.md.simulinkExchange.popup.actions.atl;


import java.io.IOException;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.Sequence;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;

import se.kth.md.simulinkExchange.management.IModelManager;
import se.kth.md.simulinkExchange.management.exceptions.InvalidModelException;

@RunWith(JMock.class)
public class TheJobEast2SimulinkTest {

	Mockery context = new JUnit4Mockery();
	se.kth.md.simulinkExchange.management.Traverser nameTraverserMock = context.mock(se.kth.md.simulinkExchange.management.Traverser.class);
	IModelManager modelManagerMock = context.mock(IModelManager.class);
	IPath aPath = new Path("/IdoNotExists.yes");
	TheJobEast2Simulink theJob = new TheJobEast2Simulink( aPath );
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void runNameTraverser() throws InvalidModelException, IOException {
		final Sequence aSequence = context.sequence("aSequence");
		// Should load the model once
		context.checking(new Expectations() {{
			oneOf (modelManagerMock).loadIt();
			oneOf (modelManagerMock).traverseWith(nameTraverserMock);
			oneOf (modelManagerMock).saveIt();
		}} );
						
		theJob.runNameTraverser( modelManagerMock );

	}
}
