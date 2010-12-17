package se.kth.md.oslc;

public interface IServer {
	
	/**
	 * Runs Server
	 */
	public void run();
	
	/**
	 * Stops server
	 */
	public void kill();
	
	public void fireHTTPGetEvent(Object data);
	
    public void addHTTPGETEventListener(IHTTPEventListener listener);
	
	public void removeHTTPGETEventListener(IHTTPEventListener listener);

}
