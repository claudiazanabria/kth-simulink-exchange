package se.kth.md.simulinkExchange.conversion.ToSimulink.postprocessing;

import Simulink.Inport;
import Simulink.Line;
import Simulink.Model;
import Simulink.Outport;
import Simulink.ProtoObject;
import Simulink.System;
import Simulink.SystemReference;

public class NameTraverserDelegate implements ITraverserDelegate {

	@Override
	public void doIt(SystemReference systemReference) {
		String parentName = systemReference.getParent().getSimulinkName();
		computeEnclosingSimulinkName( systemReference, parentName );
	}

	@Override
	public void doIt(System aSystem) {
		computeGenericSimulinkName( aSystem );
		computeSystemFileName( aSystem );
	}

	@Override
	public void doIt(Model model) {
		setRootSystemNameSameAsModel( model );
		computeGenericSimulinkName( model );
	}

	@Override
	public void doIt(Inport with) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doIt(Outport with) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doIt(Line with) {
		// TODO Auto-generated method stub

	}

	protected void computeGenericSimulinkName(ProtoObject pObject) {
		pObject.setSimulinkName( pObject.getName() );
	}

	protected void computeEnclosingSimulinkName(
			ProtoObject pObject, String parentName) {
		
		String simulinkName = parentName + '/' + pObject.getName();
		pObject.setSimulinkName( simulinkName );
	}

	
	protected void computeSystemFileName(Simulink.System system) {
		system.setFilename( system.getName() + ".mdl" );
	}

	protected void setRootSystemNameSameAsModel(Model model) {
		model.getRoot().setName( model.getName() );
	}

}
