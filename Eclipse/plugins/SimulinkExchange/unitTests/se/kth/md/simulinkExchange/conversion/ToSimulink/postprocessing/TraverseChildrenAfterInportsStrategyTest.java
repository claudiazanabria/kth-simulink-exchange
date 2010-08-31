package se.kth.md.simulinkExchange.conversion.ToSimulink.postprocessing;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JMock;
import org.junit.Before;
import org.junit.runner.RunWith;

@RunWith(JMock.class)
public class TraverseChildrenAfterInportsStrategyTest extends
		TraverseStrategyBasicTest {
	@Before
	public void setUp() {
		traverseStrategy = new TraverseChildrenAfterInportsStrategy();
	}

	@Override
	public void sequenceTest() {
		inportsChildrenOutportsLineSequenceTest();
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
		}});
		
		traverseStrategy.doIt(systemMock, delegateMock);
	}


}
