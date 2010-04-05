package modelManagement.simulink;

import org.junit.Test;
import static org.junit.Assert.*;

public class SystemLayouter {

    Integer distanceBetweenPorts    = new Integer(60);
    Integer distanceBetweenSystmes  = new Integer(90);
    Integer blockSize               = new Integer(150);
    Integer portSizeHoriz           = new Integer(30);
    Integer portSizeVert            = new Integer(14);

    private Integer top     = new Integer(50);
    private Integer left    = new Integer(20);
    private Integer bottom  = new Integer(0);
    private Integer right   = new Integer(0);

	public void startWithSystems() {
        top    = 40;
        left   = -140;
	}

	public void startWithOutports() {
        left = left + distanceBetweenSystmes + blockSize;
        if (left < 0) {left = 100; }
        top = 50;
	}

	public String nextPort() {
        top = top + distanceBetweenPorts;
        bottom = top + portSizeVert;
        right = left + portSizeHoriz;
        String position = buildPositionString();         
		return position;
	}

	public String nextSystem() {
        left = left + distanceBetweenSystmes + blockSize;
        bottom = top + blockSize;
        right = left + blockSize;
        String position = buildPositionString();
		return position;
	}

	private String buildPositionString() {
		String format = "[%d %d %d %d]";
		String position = String.format(format, left, top, right, bottom);
		return position;
	}

	@Test
	public void testBuildPositionString() {
		SystemLayouter sl = new SystemLayouter();
		String pos = sl.buildPositionString();
		assertTrue(pos.equalsIgnoreCase("[20 50 0 0]"));
	} 

}
