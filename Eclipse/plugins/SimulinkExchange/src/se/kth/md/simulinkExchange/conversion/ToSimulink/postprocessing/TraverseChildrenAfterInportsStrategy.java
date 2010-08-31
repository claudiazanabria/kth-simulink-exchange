package se.kth.md.simulinkExchange.conversion.ToSimulink.postprocessing;

import Simulink.Inport;
import Simulink.Line;
import Simulink.Model;
import Simulink.Outport;
import Simulink.System;
import Simulink.SystemReference;

public class TraverseChildrenAfterInportsStrategy implements ITraverserStrategy {

	public void doIt(Model model, ITraverserDelegate delegate) {
		delegate.doIt(model);
		doIt(model.getRoot(), delegate);
	}

	public void doIt(System system, ITraverserDelegate delegate) {
		delegate.doIt(system);
		for (Inport inport : system.getInports()) {
			delegate.doIt( inport );
		}
		for (SystemReference sysRef : system.getChildren()) {
			doIt( sysRef, delegate );
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

		delegate.doIt( systemReference );
		doIt( systemReference.getTarget(), delegate );
	}
}
