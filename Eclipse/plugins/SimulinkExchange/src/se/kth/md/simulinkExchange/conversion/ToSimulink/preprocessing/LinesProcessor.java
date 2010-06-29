package se.kth.md.simulinkExchange.conversion.ToSimulink.preprocessing;

import java.util.ArrayList;
import java.util.Collection;

import Simulink.Inport;
import Simulink.Line;
import Simulink.Outport;
import Simulink.Port;
import Simulink.ProtoObject;
import Simulink.System;
import Simulink.SystemReference;

/**
 * Adds lines to the list. Lines are complicated in Simulink.
 * @author Alex Schenkman
 *
 */
public class LinesProcessor {
	
	System theSystem;
	
	public static Collection<? extends ProtoObject> doIt(System aSystem) {
		
		LinesProcessor lp = new LinesProcessor();
		lp.theSystem = aSystem;
		return lp.process();
	}

	private Collection<? extends ProtoObject> process() {
		ArrayList<ProtoObject> list = new ArrayList<ProtoObject>();
		for (Line aLine : theSystem.getLines()) {
			process( aLine );
			list.add( aLine );
		}
		return list;
	}

	private void process(Line aLine) {
		String simuName = null;
		simuName = processPort(aLine, aLine.getSource());
		aLine.setSimuNameSrc(simuName);
		simuName = processPort(aLine, aLine.getDestination());
		aLine.setSimuNameDst(simuName);
	}
	
	
	private String processPort(Line aLine, Port port) {
		String simuName = null;
		System portParentSys = obtainPortParent( port );
		if ( portBelongsToSubsystem(aLine, portParentSys) ) {
			SystemReference block = findBlockNameWithinReferences( aLine, portParentSys );
			simuName = block.getName() + '/' + findPosInBlock(block.getTarget(), port); 
		} else {
			simuName = port.getName() + "/1";  
		}
		return simuName;
	}

	private Integer findPosInBlock(System aSystem, Port port) {
		int index = aSystem.getInports().indexOf(port);
		if ( index == -1 ) {
			index = aSystem.getOutports().indexOf(port);
		}		
		return index+1;
	}

	private System obtainPortParent(Port port) {
		// Hack to circumvent EMF inheritance issue:
		// getParent is defined for Inport and Outport, 
		// but it cannot be called from Port.
		System parent = null;
		String type = port.eClass().getName();
		if (type.equalsIgnoreCase("Inport")) {
			parent = ((Inport)port).getParent();
		} else {
			parent = ((Outport)port).getParent();
		}
		return parent;
	}

	private SystemReference findBlockNameWithinReferences(Line aLine, System portParentSys) {
		for (SystemReference sysRef : aLine.getParent().getChildren()) {
			if ( sysRef.getTarget() == portParentSys ) {
				return sysRef; 
				}
		}
		return null;
	}

	private boolean portBelongsToSubsystem(Line aLine, System portParentSys) {
		if ( aLine.getParent() == portParentSys ) { 
			return false;}
		else { 
			return true; }
	}

}
