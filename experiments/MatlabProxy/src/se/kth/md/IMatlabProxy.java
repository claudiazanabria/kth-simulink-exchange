package se.kth.md;

public interface IMatlabProxy {
	
	public void addHTTPGETEventListener(IHTTPEventListener listener);
	
	public void removeHTTPGETEventListener(IHTTPEventListener listener);
	
	public void fireHTTPGetEvent(Object data);

}
