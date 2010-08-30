package se.kth.md.simulinkExchange.conversion.ToSimulink.postprocessing;

import Simulink.Inport;
import Simulink.Line;
import Simulink.Model;
import Simulink.Outport;
import Simulink.Port;
import Simulink.ProtoObject;
import Simulink.System;
import Simulink.SystemReference;

public class NameTraverserDelegate implements ITraverserDelegate {

	private static final String INPORT_SUFFIX = "_In";
	private static final String OUTPORT_SUFFIX = "_Out";

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
	public void doIt(Inport inport) {
		addTypeSuffixIfNeeded( inport, INPORT_SUFFIX );
		computePortName(inport);	
	}

	private void computePortName(Port port) {
		String parentName = port.getParent().getSimulinkName();
		computeEnclosingSimulinkName(port, parentName);
	}

	@Override
	public void doIt(Outport outport) {
		addTypeSuffixIfNeeded( outport, OUTPORT_SUFFIX );
		computePortName(outport);	
	}

	@Override
	public void doIt(Line line) {
		String simulinkName = null;
		simulinkName = processPort(line, line.getSource());
		line.setSimuNameSrc(simulinkName);
		simulinkName = processPort(line, line.getDestination());
		line.setSimuNameDst(simulinkName);
	}

	protected String processPort(Line aLine, Port port) {
		String simuName = null;
		if ( lineAndPortHaveTheSameParent(aLine, port) ) {
			simuName = port.getName() + "/1";  
		} else {
			System lineParent = aLine.getParent();
			SystemReference sysRef = findSysRefWhosTargetIsGivenSystem( lineParent, port.getParent() );
			simuName = sysRef.getName() + '/' + findPositionWithinSystem(sysRef.getTarget(), port); 			
		}
		return simuName;
	}
	

	/**
	 * Returns the position in the Inports or Ouports array for the given port
	 * @param aSystem
	 * @param port
	 * @return 0 if port is not found
	 */
	protected Integer findPositionWithinSystem(System aSystem, Port port) {
		int index = aSystem.getInports().indexOf(port);
		if ( index == -1 ) {
			index = aSystem.getOutports().indexOf(port);
		}		
		return index+1;
	}

	protected boolean lineAndPortHaveTheSameParent(Line aLine, Port port) {
		return aLine.getParent() == port.getParent();	
	}
	

	// TODO test
	protected SystemReference findSysRefWhosTargetIsGivenSystem(System lineParent, System portsParent) {
		for (SystemReference sysRef : lineParent.getChildren()) {
			if ( sysRef.getTarget() == portsParent ) {
				return sysRef; 
				}
		}
		return null;
	}
	
	protected void addTypeSuffixIfNeeded(Port port, String suffix) {
		String name = port.getName(); 
		if ( ! name.endsWith(suffix) ) {
			port.setName( name + suffix );
		}				
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
