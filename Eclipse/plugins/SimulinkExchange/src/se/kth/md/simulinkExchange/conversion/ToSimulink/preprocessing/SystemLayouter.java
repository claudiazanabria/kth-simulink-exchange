/**************************************************************************
 * Copyright (c) 2010 KTH, Mechatronics group and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0,
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: KTH, Mechatronics group
 **************************************************************************/

package se.kth.md.simulinkExchange.conversion.ToSimulink.preprocessing;

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
public class SystemLayouter implements ISystemLayouter {

	//TODO this class is not tested. Is it worth testing it?
	
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

    /* (non-Javadoc)
	 * @see se.kth.md.simulinkExchange.conversion.ToSimulink.preprocessing.ISystemLayouter#startWithSystems()
	 */
	public void startWithSystems() {
        top    = 40;
        left   = -140;
	}

    /* (non-Javadoc)
	 * @see se.kth.md.simulinkExchange.conversion.ToSimulink.preprocessing.ISystemLayouter#startWithOutports()
	 */
	public void startWithOutports() {
        left = left + distanceBetweenSystmes + blockSizeHoriz;
        if (left < 0) {left = 100; }
        top = 50;
	}

	/* (non-Javadoc)
	 * @see se.kth.md.simulinkExchange.conversion.ToSimulink.preprocessing.ISystemLayouter#nextPortPosition()
	 */
	public String nextPortPosition() {
        top = top + distanceBetweenPorts;
        bottom = top + portSizeVert;
        right = left + portSizeHoriz;
        String position = buildPositionString();         
		return position;
	}

	
	/* (non-Javadoc)
	 * @see se.kth.md.simulinkExchange.conversion.ToSimulink.preprocessing.ISystemLayouter#nextSystem()
	 */
	public String nextSystem() {
        left = left + distanceBetweenSystmes + blockSizeHoriz;
        bottom = top + blockSizeVert;
        right = left + blockSizeHoriz;
        String position = buildPositionString();
		return position;
	}

	protected String buildPositionString() {
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
