package modelManagement.simulink;

import java.util.Collection;

import Simulink.Inport;
import Simulink.Port;
import Simulink.ProtoObject;
import Simulink.System;

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

}
