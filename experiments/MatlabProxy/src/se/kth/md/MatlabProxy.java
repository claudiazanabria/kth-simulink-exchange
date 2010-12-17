package se.kth.md;

import java.util.EventObject;
import java.util.Vector;

/**
 * 
 
 *
 */
public class MatlabProxy implements IMatlabProxy{
	
	private Vector<IHTTPEventListener> listeners = new Vector<IHTTPEventListener>();
	
	public synchronized void addHTTPGETEventListener(IHTTPEventListener listener) {		
		listeners.add(listener);		
	}

	public synchronized void removeHTTPGETEventListener(IHTTPEventListener listener) {
		listeners.remove(listener);		
	}

	public void fireHTTPGetEvent(Object data) {
		HTTPGETEvent event = new HTTPGETEvent(this, data);
		for (IHTTPEventListener listener: listeners){
			listener.GETRequestArrived(event);
		}				
	}
	
	public class HTTPGETEvent extends EventObject implements IHTTPEvent {
		
		public Object data;
		
		public Object getData() {
			return data;
		}

		public HTTPGETEvent(Object source, Object data) {
			super(source);
			this.data = data;
		}	
		private static final long serialVersionUID = 1L;

	}


}
