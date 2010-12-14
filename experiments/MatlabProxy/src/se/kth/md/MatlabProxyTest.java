package se.kth.md;

import static org.junit.Assert.assertEquals;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JMock.class)
public class MatlabProxyTest {

	MatlabProxy matlabProxy;
	Mockery context = new JUnit4Mockery();
	IHTTPEventListener listenerMock = context.mock(IHTTPEventListener.class);
	IHTTPEvent eventMock = context.mock(IHTTPEvent.class);
	
	
	
	@Before
	public void setUp(){
		matlabProxy = new MatlabProxy();
	}
	
	
	@Test
	public void testNotifiedWhenListenerRegistered(){
		matlabProxy.addHTTPGETEventListener(listenerMock);	
		
		context.checking(new Expectations() {{
			
			oneOf(listenerMock).GETRequestArrived(with(any(IHTTPEvent.class)));
			
		}});	
		
			
		matlabProxy.fireHTTPGetEvent(new Object());
	}
	
	@Test
	public void testIgnoringWhenListenerNotRegistered(){
		context.checking(new Expectations() {{
			
			never(listenerMock).GETRequestArrived(with(any(IHTTPEvent.class)));
			
		}});		
			
		matlabProxy.fireHTTPGetEvent(null);		
	}
	
	@Test
	public void testDataPassedWithNotified(){
		Object data = new Integer(42);		
		DummyListener dummyListener = new DummyListener();
		matlabProxy.addHTTPGETEventListener(dummyListener);			
		matlabProxy.fireHTTPGetEvent(data);
		assertEquals(data, dummyListener.getData());
	}
	
	class DummyListener implements IHTTPEventListener{
		IHTTPEvent event;
		
		@Override
		public Object GETRequestArrived(IHTTPEvent event) {
			this.event = event;
			return null;
		}
		
		public Object getData(){
			return event.getData();
		}
	}
	
	
	
}
