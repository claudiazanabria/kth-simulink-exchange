package se.kth.md.simulinkExchange.popup.actions.atl;


import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.Sequence;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.jmock.integration.junit4.JMock;

@RunWith(JMock.class)
public class PersonTest {

	Person aPerson;
	Mockery context = new JUnit4Mockery();
	
	@Before
	public void setUp() throws Exception {
		aPerson = new Person();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void aTest() {
		final IChild childMock = context.mock(IChild.class);
		final Sequence aSequence = context.sequence("aSequence");
		
		context.checking(new Expectations() {{
			oneOf (childMock).doSomething(); inSequence(aSequence);
			oneOf (childMock).doOther(); inSequence(aSequence);
		}} );
			
		aPerson.shout(childMock);
		assert( true );
	}
}
