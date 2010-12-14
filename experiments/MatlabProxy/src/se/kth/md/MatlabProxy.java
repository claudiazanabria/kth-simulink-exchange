package se.kth.md;

import java.util.EventObject;
import java.util.Vector;

public class MatlabProxy{
	
	private Vector<IHTTPEventListener> listeners = new Vector<IHTTPEventListener>();
	
	public void addHTTPGETEventListener(IHTTPEventListener listener) {
		listeners.add(listener);		
	}

	public void removeHTTPGETEventListener(IHTTPEventListener listener) {
		listeners.remove(listener);		
	}

	public Object fireHTTPGetEvent(Object data) {
		HTTPGETEvent event = new HTTPGETEvent(this, data);
		if (!listeners.isEmpty()){
			return listeners.get(0).GETRequestArrived(event);
		}
		
		return null;		
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
