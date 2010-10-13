package SimulinkOOAPI.impl;

import static org.junit.Assert.assertEquals;
import junit.framework.AssertionFailedError;

import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import SimulinkOOAPI.Identity;

@RunWith(JMock.class)
public class LibraryImplTest {
	
	Mockery context = new JUnit4Mockery();
	Identity identityMock = context.mock(Identity.class);
    LibraryImpl library;
	
	@Before
	public void setUp(){		
		library = new LibraryImpl(identityMock);				
	}
	
	@Test
	public void testDefaultConstructorIsNotAllowed(){
		try{
			new LibraryImpl();
			//if constructor was called successfully, the test has not passed
			throw new AssertionFailedError();
		}catch(UnsupportedOperationException e){
			//test passed
		}
	}	
	
	@Test
	//TODO: check some other elements cannot be added into library
	public void testAddChild(){
		assertEquals(0, library.getNumberOfChildren());
		library.addChild(new SystemImpl(identityMock));
		assertEquals(1, library.getNumberOfChildren());
	}
	
	@Test
	public void testGetChildrenOfTypeGainBlock(){
		library.addChild(new GainBlockImpl(identityMock, 2));
		library.addChild(new GainBlockImpl(identityMock, 3));
		assertEquals(2, library.getChildrenOfTypeGainBlock().size());
	}
	
	@Test	
	public void testGetChildrenOfTypeLine(){
		library.addChild(new LineImpl(identityMock));
		assertEquals(1, library.getChildrenOfTypeLine().size());
	}
	
	@Test
	public void testGetChildrenOfTypePort(){
		library.addChild(new PortImpl(identityMock));
		assertEquals(1, library.getChildrenOfTypePort().size());
	}

	
	@Test
	public void testGetChildrenOfTypeSystem(){
		library.addChild(new SystemImpl(identityMock));
		assertEquals(1, library.getChildrenOfTypeSystem().size());
	}

}
