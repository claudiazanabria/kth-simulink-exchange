package se.kth.md.simulinkExchange.modelConversion.simulink.preprocessing;

import java.util.Collection;


import Simulink.Outport;
import Simulink.Port;
import Simulink.ProtoObject;
import Simulink.System;

/**
 * Gets the outports from a system, and adds them to the list.
 * @author Alex Schenkman
 *
 */
public class OutportsProcessor extends PortProcessor {
	
	public static Collection<? extends ProtoObject> doIt(
			System aSystem, SystemLayouter layouter) {
				
		OutportsProcessor pp = new OutportsProcessor();
		pp.init(aSystem, layouter);
		layouter.startWithOutports();
		return pp.process( aSystem.getOutports() );		
	}
	
	@Override	
	public String getParentName(Port port) {
		Outport outport = (Outport) port;
		return outport.getParent().getSimulinkName();
	}

	/**
	 * see PortProcessor.computeInstanceName()
	 */
	@Override
	protected void addTypeSuffixIfNeeded(Port port) {
		String name = port.getName(); 
		if ( ! name.endsWith("Out") ) {
			port.setName( name + "_Out" );
		}		
	}
	
}
