package se.kth.md.simulinkExchange.conversion.ToSimulink.preprocessing;

import java.util.ArrayList;
import java.util.Collection;


import Simulink.ProtoObject;
import Simulink.System;
import Simulink.SystemReference;

/**
 * Adds a SystemReference, or subsystem, or system instance to the list.
 * @author Alex Schenkman
 */
public class SysRefsProcessor {

	ArrayList<ProtoObject> list = new ArrayList<ProtoObject>();
	System theSystem;
	SystemLayouter layouter;
	
	public static Collection<? extends ProtoObject> doIt(
			System aSystem, SystemLayouter layouter) {

		SysRefsProcessor sp = new SysRefsProcessor();
		sp.theSystem = aSystem;
		sp.layouter = layouter;
		
		return sp.process();
	}


	private Collection<? extends ProtoObject> process() {
		layouter.startWithSystems();

		for (SystemReference sysRef : theSystem.getChildren()) {
			processSystemReference( sysRef );
		}
		return list;
	}

	private void processSystemReference(SystemReference sysRef) {
		computeInstanceName( sysRef );
		computePosition( sysRef );
		System aSystem = sysRef.getTarget();
		list.addAll( SystemProcessor.doIt( aSystem ));
		list.add( sysRef );
	}

	private void computePosition(SystemReference sysRef) {
		String position = sysRef.getPosition(); 
		if ( (position==null) || (position.isEmpty()) ) {
			position = layouter.nextSystem();
			sysRef.setPosition(position);
		}
	}


	private void computeInstanceName(SystemReference sysRef) {
		String parentName = sysRef.getParent().getSimulinkName();
		String instanceName = parentName + '/' + sysRef.getName();
		sysRef.setSimulinkName(instanceName);
		return;
	}


}
