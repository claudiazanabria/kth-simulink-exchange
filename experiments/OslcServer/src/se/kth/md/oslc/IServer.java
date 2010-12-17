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
	
	
    void addRequestEventListener(Server.IRequestListener listener);

	void removeRequestEventListener(Server.IRequestListener listener);

	

}
