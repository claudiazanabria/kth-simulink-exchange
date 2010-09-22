package se.kth.md.simulinkExchange.conversion.ToSimulink.postprocessing;

import Simulink.Inport;
import Simulink.Line;
import Simulink.Model;
import Simulink.Outport;
import Simulink.Port;
import Simulink.System;
import Simulink.SystemReference;

/**
 * This class implements both the traversal strategy and the delegate.
 * 
 * The original design separates the traversal from the actual
 * actions carried on the leafs.
 * 
 * As this traversal strategy is not used anywhere else, 
 * we found that this was a simple approach.
 * 
 * The problem arised from the need to instantiate SystemLayouter once for each
 * containment level (simulink subsystems).
 * 
 * @author alex
 *
 */
public class TraversalForLayoutStrategy 
	implements ITraverserStrategy, ITraverserDelegate {

	public void doIt(Model model, ITraverserDelegate delegate) {
		delegate.doIt(model);
		doIt(model.getRoot(), delegate);
	}

	public void doIt(System system, ITraverserDelegate delegate) {
		// Keep layouter local, as individual instances are needed for each children level. 
		SystemLayouter layouter = new SystemLayouter();
		doOnSystem(system, layouter, delegate);
	}

	/**
	 * This method is separated from doIt(System) only for testing purposes.
	 */
	protected void doOnSystem(System system, ISystemLayouter layouter,
			ITraverserDelegate delegate) {
		
		delegate.doIt(system);
		for (Inport inport : system.getInports()) {
			delegate.doIt( inport );
			this.doOnPort(inport, layouter);
		}
		layouter.startWithSystems();
		for (SystemReference sysRef : system.getChildren()) {
			doIt( sysRef, delegate );
			this.doOnSysRef(sysRef, layouter);
			
		}
		layouter.startWithOutports();
		for (Outport outport : system.getOutports()) {
			delegate.doIt( outport );
			this.doOnPort(outport, layouter);
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

	protected void doOnSysRef(SystemReference sysRef, ISystemLayouter layouter) {
		String position = sysRef.getPosition(); 
		if ( (position==null) || (position.isEmpty()) ) {
			position = layouter.nextSystem();
			sysRef.setPosition(position);
		}	
	}

	protected void doOnPort(Port port, ISystemLayouter layouter) {
		String position = port.getPosition(); 
		if ( (position==null) || (position.isEmpty()) ) {
			position = layouter.nextPortPosition();
			port.setPosition( position );
		}
	}

	@Override
	public void doIt(SystemReference sysRef) {}

	@Override
	public void doIt(System system) {}

	@Override
	public void doIt(Model model) {}

	@Override
	public void doIt(Line line) {}
	
	@Override
	public void doIt(Inport port) {}

	@Override
	public void doIt(Outport port) {}	
}
