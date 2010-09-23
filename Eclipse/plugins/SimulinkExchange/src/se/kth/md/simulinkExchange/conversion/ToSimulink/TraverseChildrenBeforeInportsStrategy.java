package se.kth.md.simulinkExchange.conversion.ToSimulink;

import Simulink.Inport;
import Simulink.Line;
import Simulink.Model;
import Simulink.Outport;
import Simulink.System;
import Simulink.SystemReference;

public class TraverseChildrenBeforeInportsStrategy implements ITraverserStrategy {

	public void doIt(Model model, ITraverserDelegate delegate) {
		delegate.doIt(model);
		doIt(model.getRoot(), delegate);
	}

	public void doIt(System system, ITraverserDelegate delegate) {
		delegate.doIt(system);
		for (SystemReference sysRef : system.getChildren()) {
			doIt( sysRef, delegate );
		}		
		for (Inport inport : system.getInports()) {
			delegate.doIt( inport );
		}
		for (Outport outport : system.getOutports()) {
			delegate.doIt( outport );
		}
		for (Line line : system.getLines()) {
			delegate.doIt( line );
		}
		
	}

	public void doIt(SystemReference systemReference,
			ITraverserDelegate delegate) {

		doIt( systemReference.getTarget(), delegate );
		delegate.doIt( systemReference );

	}

}
