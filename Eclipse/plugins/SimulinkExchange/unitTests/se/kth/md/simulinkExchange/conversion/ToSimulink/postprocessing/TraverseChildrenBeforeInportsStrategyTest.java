package se.kth.md.simulinkExchange.conversion.ToSimulink.postprocessing;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JMock;
import org.junit.Before;
import org.junit.runner.RunWith;

@RunWith(JMock.class)
public class TraverseChildrenBeforeInportsStrategyTest extends
		TraverseStrategyBasicTest {

	@Before
	public void setUp() {
		traverseStrategy = new TraverseChildrenBeforeInportsStrategy();
	}

	@Override
	public void sequenceTest() {
		childrenInportsOutportsLineSequenceTest();
	}

	private void childrenInportsOutportsLineSequenceTest() {

		context.checking(new Expectations() {{ 
			oneOf (systemMock).getChildren();
			will(returnValue( asEList(systemReferenceMock) ));

			oneOf (systemMock).getInports();
			will(returnValue( asEList(inportMock) ));

			oneOf (systemMock).getOutports();
			will(returnValue( asEList(outportMock) ));

			oneOf (systemMock).getLines();
			will(returnValue( asEList(lineMock) ));

			ignoring (systemMock);
			ignoring (systemReferenceMock);
		}} );

		context.checking(new Expectations() {{ 
			oneOf (delegateMock).doIt(systemMock);
			inSequence(aSequence);

			oneOf (delegateMock).doIt(systemReferenceMock);
			inSequence(aSequence);

			oneOf (delegateMock).doIt(inportMock);
			inSequence(aSequence);

			oneOf (delegateMock).doIt(outportMock);
			inSequence(aSequence);

			oneOf (delegateMock).doIt(lineMock);
			inSequence(aSequence);

			ignoring (delegateMock);
		}});

		traverseStrategy.doIt(systemMock, delegateMock);
	}


}
