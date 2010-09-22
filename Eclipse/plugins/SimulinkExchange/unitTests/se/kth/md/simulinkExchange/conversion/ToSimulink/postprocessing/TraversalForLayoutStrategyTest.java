package se.kth.md.simulinkExchange.conversion.ToSimulink.postprocessing;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import Simulink.SystemReference;


@RunWith(JMock.class)
public class TraversalForLayoutStrategyTest extends
		TraverseStrategyBasicTest {
	@Before
	public void setUp() {
		traverseStrategy = new TraversalForLayoutStrategy();
		layouterMock = context.mock(ISystemLayouter.class);
	}

	@Override
	public void sequenceTest() {
		inportsChildrenOutportsLineSequenceTest();
	}

	
	//TODO Test that doIt(System) is creating new instances each time. How?
	
	ISystemLayouter layouterMock;

	@Test
	public void systemLayouterWithtChildrenSequenceTest() {
		addSystemBehaviourToContext();

		context.checking(new Expectations() {{ 
			oneOf (systemMock).getChildren();
			will(returnValue( asEList(systemReferenceMock) ));
			
			ignoring (systemReferenceMock);
		}} );
		
		context.checking(new Expectations() {{ 
		
			oneOf (layouterMock).nextPortPosition();
				inSequence( aSequence );
				
			oneOf (layouterMock).startWithSystems();
				inSequence( aSequence );

			oneOf (layouterMock).nextSystem();
				inSequence( aSequence );

			oneOf (layouterMock).startWithOutports();
				inSequence( aSequence );

			oneOf (layouterMock).nextPortPosition();
				inSequence( aSequence );
				
			ignoring (delegateMock);
		}});

		((TraversalForLayoutStrategy) traverseStrategy).doOnSystem(systemMock, layouterMock, delegateMock);
	}
	
	@Test
	public void systemLayouterWithoutChildrenSequenceTest() {
		addSystemBehaviourToContext();

		context.checking(new Expectations() {{ 
			oneOf (systemMock).getChildren();
			will(returnValue( emptyEListWithType(SystemReference.class) ));
		}} );
		
		context.checking(new Expectations() {{ 
		
			oneOf (layouterMock).nextPortPosition();
				inSequence( aSequence );
				
			oneOf (layouterMock).startWithSystems();
				inSequence( aSequence );

//			oneOf (layouterMock).nextSystem();
//				inSequence( aSequence );

			oneOf (layouterMock).startWithOutports();
				inSequence( aSequence );

			oneOf (layouterMock).nextPortPosition();
				inSequence( aSequence );
				
			ignoring (delegateMock);
		}});

		((TraversalForLayoutStrategy) traverseStrategy).doOnSystem(systemMock, layouterMock, delegateMock);
	}

	private void addSystemBehaviourToContext() {
		context.checking(new Expectations() {{ 
			
			oneOf (systemMock).getInports();
				will(returnValue( asEList(inportMock) ));
								
			oneOf (systemMock).getOutports();
				will(returnValue( asEList(outportMock) ));
			
			allowing (systemMock).getLines();
			
			ignoring (inportMock);
			ignoring (outportMock);

		}} );
	}
	
	private void inportsChildrenOutportsLineSequenceTest() {
		
		context.checking(new Expectations() {{ 
			
			oneOf (delegateMock).doIt(systemMock);
				inSequence(aSequence);

			oneOf (systemMock).getInports();
				will(returnValue( asEList(inportMock) ));
				inSequence(aSequence);

			oneOf (delegateMock).doIt(inportMock);
				inSequence(aSequence);
				
			oneOf (systemMock).getChildren();
				will(returnValue( asEList(systemReferenceMock) ));
				inSequence(aSequence);

			oneOf (delegateMock).doIt(systemReferenceMock);
				inSequence(aSequence);

			oneOf (systemMock).getOutports();
				will(returnValue( asEList(outportMock) ));
				inSequence(aSequence);

			oneOf (delegateMock).doIt(outportMock);
				inSequence(aSequence);
				
			oneOf (systemMock).getLines();
				will(returnValue( asEList(lineMock) ));
				inSequence(aSequence);

			oneOf (delegateMock).doIt(lineMock);
				inSequence(aSequence);

			ignoring (systemMock);
			ignoring (delegateMock);
			ignoring (systemReferenceMock);
			ignoring (inportMock);
			ignoring (outportMock);
			ignoring (layouterMock);
		}});
		
		((TraversalForLayoutStrategy) traverseStrategy).doOnSystem(systemMock, layouterMock, delegateMock);
	}


}
