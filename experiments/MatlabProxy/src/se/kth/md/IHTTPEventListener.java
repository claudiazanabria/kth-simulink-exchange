package se.kth.md;

import java.util.EventListener;

public interface IHTTPEventListener extends EventListener {

	public Object GETRequestArrived(IHTTPEvent event);
	
	//public void POSTRequestArrived(IHTTPEvent event);
	
}
