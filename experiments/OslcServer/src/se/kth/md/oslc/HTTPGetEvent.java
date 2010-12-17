package se.kth.md.oslc;

import java.util.EventObject;

public class HTTPGetEvent extends EventObject implements IHTTPEvent {
	
	public Object data;
	
	public Object getData() {
		return data;
	}

	public HTTPGetEvent(Object source, Object data) {
		super(source);
		this.data = data;
	}	
	
	private static final long serialVersionUID = 1L;
}