package se.kth.md;

import java.io.File;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JMock.class)
public class BottleServerWrapperTest {
	
	Mockery context = new JUnit4Mockery();
	IMatlabProxy matlabProxyMock = context.mock(IMatlabProxy.class);
	BottleServerWrapper serverWrapper;
	
	@Before
	public void setUp() throws Exception {
		String path = new File(".").getCanonicalPath();
		serverWrapper = new BottleServerWrapper(path, matlabProxyMock);
	}
	
	
	@Test
	public void testServerIsAlive() throws Exception{
		assertFalse(serverWrapper.isAlive());
		serverWrapper.run();
		assertTrue(serverWrapper.isAlive());		 
		serverWrapper.stop();
		assertFalse(serverWrapper.isAlive());	
	}
	
	@After
	public void tearDown(){		 
		 serverWrapper.stop();		 
	}

}
