package se.kth.md.simulinkExchange.popup.actions.atl.east2simulink;

import java.util.ArrayList;

import Simulink.Inport;
import Simulink.Line;
import Simulink.Model;
import Simulink.Outport;
import Simulink.ProtoObject;
import Simulink.System;
import Simulink.SystemReference;
import se.kth.md.simulinkExchange.conversion.ToSimulink.postprocessing.ITraverserDelegate;

public class ListCreatorDelegate implements ITraverserDelegate {

	private ArrayList<ProtoObject> theList = new ArrayList<ProtoObject>();
	
	@Override
	public void doIt(SystemReference sysRef) {
		theList.add( sysRef );
	}

	@Override
	public void doIt(Line line) {
		theList.add( line );
	}

	@Override
	public void doIt(System system) {
		theList.add( system );
	}

	@Override
	public void doIt(Model model) {
		theList.add( model );
	}

	@Override
	public void doIt(Inport inport) {
		theList.add(inport);
	}

	@Override
	public void doIt(Outport outport) {
		theList.add( outport );
	}

	public ArrayList<ProtoObject> allElementsList() {
		return theList;
	}

}
