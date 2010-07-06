/**************************************************************************
 * Copyright (c) 2010 KTH, Mechatronics group and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0,
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: KTH, Mechatronics group
 **************************************************************************/

package se.kth.md.simulinkExchange.conversion.ToSimulink.postprocessing;

import java.io.IOException;

import org.eclipse.emf.common.util.EList;
import org.junit.Test;

import se.kth.md.simulinkExchange.management.ModelManager;
import se.kth.md.simulinkExchange.management.exceptions.InvalidModelException;
import se.kth.md.simulinkExchange.management.simulink.SimulinkModelManager;
import Simulink.Inport;
import Simulink.Line;
import Simulink.Model;
import Simulink.Outport;
import Simulink.Port;
import Simulink.ProtoObject;
import Simulink.System;
import Simulink.SystemReference;

public class NameTraverser implements se.kth.md.simulinkExchange.management.Traverser {
	
	private void visit(Model model) {
		renameFAA( model );
		computeGenericSimulinkName( model );
		visit( model.getRoot() );
	}
	
	private void renameFAA(Model model) {
		model.getRoot().setName( "__root__system__" );
	}

	private void visit(Simulink.System system) {
		computeGenericSimulinkName( system );
		computeSystemFileName( system );
		visitChildren	( system.getChildren() 	);
		visitInports	( system.getInports() 	);
		visitOutports	( system.getOutports() 	);
		visitLines		( system.getLines() 	);
	}
	
	private void visitLines(EList<Line> lines) {
		for(Line line : lines) {
			visit( line );
		}
	}
	
	
	private void visit(Line line) {
		String simulinkName = null;
		simulinkName = processPort(line, line.getSource());
		line.setSimuNameSrc(simulinkName);
		simulinkName = processPort(line, line.getDestination());
		line.setSimuNameDst(simulinkName);
	}

	private String processPort(Line aLine, Port port) {
		String simuName = null;
		System portParentSys = obtainPortParent( port );
		if ( portBelongsToSubsystem(aLine, portParentSys) ) {
			SystemReference block = findBlockNameWithinReferences( aLine, portParentSys );
			simuName = block.getName() + '/' + findPosInBlock(block.getTarget(), port); 
		} else {
			simuName = port.getName() + "/1";  
		}
		return simuName;
	}

	private Integer findPosInBlock(System aSystem, Port port) {
		int index = aSystem.getInports().indexOf(port);
		if ( index == -1 ) {
			index = aSystem.getOutports().indexOf(port);
		}		
		return index+1;
	}

	private System obtainPortParent(Port port) {
		// Hack to circumvent EMF inheritance issue:
		// getParent is defined for Inport and Outport, 
		// but it cannot be called from Port.
		System parent = null;
		String type = port.eClass().getName();
		if (type.equalsIgnoreCase("Inport")) {
			parent = ((Inport)port).getParent();
		} else {
			parent = ((Outport)port).getParent();
		}
		return parent;
	}

	private SystemReference findBlockNameWithinReferences(Line aLine, System portParentSys) {
		for (SystemReference sysRef : aLine.getParent().getChildren()) {
			if ( sysRef.getTarget() == portParentSys ) {
				return sysRef; 
				}
		}
		return null;
	}

	private boolean portBelongsToSubsystem(Line aLine, System portParentSys) {
		if ( aLine.getParent() == portParentSys ) { 
			return false;}
		else { 
			return true; }
	}

	private void visitChildren(EList<SystemReference> children) {
		for (SystemReference systemReference : children) {
			visit( systemReference );
		}
	}

	private void visit(SystemReference systemReference) {
		String parentName = systemReference.getParent().getSimulinkName();
		computeEnclosingSimulinkName( systemReference, parentName );
		visit( systemReference.getTarget() );
	}

	
	private void visitOutports(EList<Outport> outports) {
		String parentName;
		for (Outport outport : outports) {
			parentName = outport.getParent().getSimulinkName();
			addTypeSuffixIfNeeded( outport, "_Out" );
			visit(outport, parentName);
		}
		
	}

	private void visitInports(EList<Inport> inports) {
		String parentName;
		for (Inport inport : inports) {
			parentName = inport.getParent().getSimulinkName();
			addTypeSuffixIfNeeded( inport, "_In" );
			visit(inport, parentName);
		}
	}

	private void visit(Port port, String parentName) {
		computeEnclosingSimulinkName(port, parentName);	
	}

	private void addTypeSuffixIfNeeded(Port port, String suffix) {
		String name = port.getName(); 
		if ( ! name.endsWith(suffix) ) {
			port.setName( name + suffix );
		}				
	}

	private void computeGenericSimulinkName(ProtoObject pObject) {
		pObject.setSimulinkName( pObject.getName() );
	}

	private void computeEnclosingSimulinkName(
			ProtoObject pObject, String parentName) {
		
		String simulinkName = parentName + '/' + pObject.getName();
		pObject.setSimulinkName( simulinkName );
	}

	
	private void computeSystemFileName(Simulink.System system) {
		system.setFilename( system.getName() + ".mdl" );
	}
	
	
	@Test
	public void testMain() throws InvalidModelException, IOException {
		String demoFile = "F:/CheckOut/trunk/Eclipse/Demo Project/startingFromEAST/york2135.simulink";
		//String demoFile = "./resources/testFiles/demo.simulink";
		SimulinkModelManager manager = new SimulinkModelManager(demoFile);
		manager.loadIt();
		manager.traverseWith( new NameTraverser() );
		manager.saveIt();
	}

	@Override
	public void doIt(ModelManager manager) {
		Model model = (Model) manager.getTopElement();
		visit( model );
	}
}
