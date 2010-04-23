package se.kth.md.simulinkExchange.modelConversion.simulink.preprocessing;

import java.util.Collection;


import Simulink.Inport;
import Simulink.Port;
import Simulink.ProtoObject;
import Simulink.System;

/**
 * Gets the inports from a system, and adds them to the list.
 * @author Alex Schenkman
 *
 */
public class InportsProcessor extends PortProcessor {
	
	public static Collection<? extends ProtoObject> doIt(
			System aSystem, SystemLayouter layouter) {
	
		InportsProcessor pp = new InportsProcessor();
		pp.init(aSystem, layouter);
		return pp.process( aSystem.getInports() );		
	}

	@Override
	public String getParentName(Port port) {
		Inport inport = (Inport) port;
		return inport.getParent().getSimulinkName();
	}

	/**
	 * see PortProcessor.computeInstanceName()
	 */	
	@Override
	protected void addTypeSuffixIfNeeded(Port port) {
		String name = port.getName(); 
		if ( ! name.endsWith("In") ) {
			port.setName( name + "_In" );
		}		
	}

}
