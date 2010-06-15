package se.kth.md.simulinkExchange.simulink.preprocessing;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.util.EList;


import Simulink.Port;
import Simulink.ProtoObject;
import Simulink.System;

public abstract class PortProcessor {

	ArrayList<ProtoObject> list = new ArrayList<ProtoObject>();
	System theSystem;
	SystemLayouter layouter;

	protected void init(System aSystem, SystemLayouter layouter) {
		this.theSystem = aSystem;
		this.layouter = layouter;
	}

	protected <P extends Port> Collection<? extends ProtoObject> process(EList<P> ports) {
		for (P port : ports ) {
			processPort( port );
			list.add( port );
		}
		return list;
	}

	protected <P extends Port> void processPort(P port) {
		computeInstanceName( port );
		computePosition( port );
	}

	protected void computePosition(Port port) {
		String position = port.getPosition(); 
		if ( (position==null) || (position.isEmpty()) ) {
			position = layouter.nextPort();
			port.setPosition(position);
		}
	}
	
	protected <P extends Port> void computeInstanceName(Port port) {
		String parentName = this.getParentName( port );
		this.addTypeSuffixIfNeeded( port );
		String simuName = parentName + '/' + port.getName();
		port.setSimulinkName(simuName);	
}

	protected abstract void addTypeSuffixIfNeeded(Port port);
	
	protected String getParentName(Port port) {
		return "subClass responsibility";
	}
}
