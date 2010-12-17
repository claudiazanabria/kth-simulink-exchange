package se.kth.md;

public interface IBottleServer {
	
	public void runServer(String localhost, int port);
	
	/**
	 * Runs Server on localhost, 8080 port
	 */
	public void runServer();
	
	public void wakeUp();

}
