package se.kth.md.simulinkExchange.modelConversion.simulink.preprocessing;

/*
import org.junit.Test;
import static org.junit.Assert.*;
*/

/**
 * This class can layout Simulink elements within a System.
 * We mean layout in the sense of position in the screen.
 * 
 * The layout algorithm starts from the top-left corner,
 * addind inports, in a vertical row.
 * Then systems are added in a horizontal row.
 * Lastly, outpots are added in a vertical row. 
 *
 */
public class SystemLayouter {

    final Integer distanceBetweenPorts    	= new Integer(60);
    final Integer distanceBetweenSystmes  	= new Integer(90);
    final Integer blockSizeHoriz          	= new Integer(250);
    final Integer blockSizeVert 			= new Integer(100);
    final Integer portSizeHoriz           	= new Integer(30);
    final Integer portSizeVert            	= new Integer(14);

    private Integer top     = new Integer(40);
    private Integer left    = new Integer(35);
    private Integer bottom  = new Integer(0);
    private Integer right   = new Integer(0);

    /**
     * Lets the layouter know that you are done laying out inports, 
     * and want to start laying out systems
     */
	public void startWithSystems() {
        top    = 40;
        left   = -140;
	}

    /**
     * Lets the layouter know that you are done laying out systems, 
     * and want to start laying out outports
     */
	public void startWithOutports() {
        left = left + distanceBetweenSystmes + blockSizeHoriz;
        if (left < 0) {left = 100; }
        top = 50;
	}

	/**
	 * Get the position the next port.
	 * @return a suitable position string for MATLAB
	 */
	public String nextPort() {
        top = top + distanceBetweenPorts;
        bottom = top + portSizeVert;
        right = left + portSizeHoriz;
        String position = buildPositionString();         
		return position;
	}

	
	/**
	 * Get the position the next system.
	 * @return a suitable position string for MATLAB
	 */
	public String nextSystem() {
        left = left + distanceBetweenSystmes + blockSizeHoriz;
        bottom = top + blockSizeVert;
        right = left + blockSizeHoriz;
        String position = buildPositionString();
		return position;
	}

	private String buildPositionString() {
		String format = "[%d %d %d %d]";
		String position = String.format(format, left, top, right, bottom);
		return position;
	}

/*	
	@Test
	public void testBuildPositionString() {
		SystemLayouter sl = new SystemLayouter();
		String pos = sl.buildPositionString();
		assertTrue(pos.equalsIgnoreCase("[20 50 0 0]"));
	} 
*/
}
