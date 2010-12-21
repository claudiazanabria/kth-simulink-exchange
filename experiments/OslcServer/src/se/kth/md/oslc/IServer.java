package se.kth.md.oslc;

import se.kth.md.oslc.Server.RequestEventListener;

public interface IServer {
	
	/**
	 * Runs Server
	 */
	public void run();
	
	/**
	 * Stops server
	 */
	public void kill();
	
	
    void addRequestEventListener(RequestEventListener listener);

	void removeRequestEventListener(RequestEventListener listener);

}
