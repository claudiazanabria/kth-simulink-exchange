package se.kth.md.oslc;

import java.util.EventListener;

public interface IHTTPEventListener extends EventListener {

	public void GETRequestArrived(IHTTPEvent event);
	
	//public void POSTRequestArrived(IHTTPEvent event);
	
}
