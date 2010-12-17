package se.kth.md.oslc;

import se.kth.md.oslc.Server.IRequestListener;

public interface IServer {
	
	/**
	 * Runs Server
	 */
	public void run();
	
	/**
	 * Stops server
	 */
	public void kill();
	
	
    void addRequestEventListener(IRequestListener listener);

	void removeRequestEventListener(IRequestListener listener);

	

}
