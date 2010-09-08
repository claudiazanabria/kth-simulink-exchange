package se.kth.md.simulinkExchange.conversion.ToSimulink.preprocessing;

public interface ISystemLayouter {

	/**
	 * Lets the layouter know that you are done laying out inports, 
	 * and want to start laying out systems
	 */
	public abstract void startWithSystems();

	/**
	 * Lets the layouter know that you are done laying out systems, 
	 * and want to start laying out outports
	 */
	public abstract void startWithOutports();

	/**
	 * Get the position the next port.
	 * @return a suitable position string for MATLAB
	 */
	public abstract String nextPortPosition();

	/**
	 * Get the position the next system.
	 * @return a suitable position string for MATLAB
	 */
	public abstract String nextSystem();

}