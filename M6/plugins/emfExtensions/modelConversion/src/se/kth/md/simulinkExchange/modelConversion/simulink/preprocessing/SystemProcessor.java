package se.kth.md.simulinkExchange.modelConversion.simulink.preprocessing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;


import Simulink.ProtoObject;
import Simulink.System;

/**
 * Adds this system to the list, then it adds the following in order:
 * 1) all of its inports
 * 2) all of its subsystems
 * 3) all of its ouports
 * 4) all of its lines
 * 
 * In this way we make sure that all references are defined before they are used.
 * The ordering of subsystems between the ports has to do with how SystemLayouter works.
 *  
 * @author Alex Schenkman
 */
public class SystemProcessor {
	
	System theSystem;
	static HashSet<System> sysRepository = new HashSet<System>();
	
	public static Collection<? extends ProtoObject> doIt(System aSystem) {
		SystemProcessor sp = new SystemProcessor();
		sp.theSystem = aSystem;
		return sp.process();
	}
	
	private Collection<? extends ProtoObject> process() {
		ArrayList<ProtoObject> list = new ArrayList<ProtoObject>();
		
		if ( ! sysRepository.contains( theSystem )) {
			sysRepository.add(theSystem);
			createSystem( list );
		}
		return list;
	}

	private void createSystem(ArrayList<ProtoObject> list) {
		SystemLayouter layouter = new SystemLayouter();
		
		computeFileName();
		computeSimulinkName();
		
		list.add( theSystem );
		list.addAll( InportsProcessor.doIt( theSystem, layouter ));
		list.addAll( SysRefsProcessor.doIt( theSystem, layouter ));
		list.addAll( OutportsProcessor.doIt( theSystem, layouter ));
		list.addAll( LinesProcessor.doIt( theSystem ));
	}

	private void computeSimulinkName() {
		theSystem.setSimulinkName( theSystem.getName() );
	}

	private void computeFileName() {
		theSystem.setFilename( theSystem.getName() + ".mdl" );
	}
}
