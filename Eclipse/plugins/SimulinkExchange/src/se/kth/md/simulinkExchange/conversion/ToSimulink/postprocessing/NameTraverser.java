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

import org.eclipse.emf.common.util.EList;

import se.kth.md.simulinkExchange.management.IModelVisitor;
import Simulink.Inport;
import Simulink.Line;
import Simulink.Model;
import Simulink.Outport;
import Simulink.Port;
import Simulink.ProtoObject;
import Simulink.System;
import Simulink.SystemReference;

/**
 * This class will traverse the whole model and fix names so they
 * are ready for simulink.
 * @author alex
 *
 */
public class NameTraverser 
	implements IModelVisitor {
	
	protected void visit(Model model) {
		renameFAA( model );
		computeGenericSimulinkName( model );
		visit( model.getRoot() );
	}
	
	protected void renameFAA(Model model) {
		model.getRoot().setName( model.getName() );
	}

	protected void visit(Simulink.System system) {
		computeGenericSimulinkName( system );
		computeSystemFileName( system );
		visitChildren	( system.getChildren() 	);
		visitInports	( system.getInports() 	);
		visitOutports	( system.getOutports() 	);
		visitLines		( system.getLines() 	);
	}
	
	protected void visitLines(EList<Line> lines) {
		for(Line line : lines) {
			visit( line );
		}
	}
	
	
	protected void visit(Line line) {
		String simulinkName = null;
		simulinkName = processPort(line, line.getSource());
		line.setSimuNameSrc(simulinkName);
		simulinkName = processPort(line, line.getDestination());
		line.setSimuNameDst(simulinkName);
	}

	protected String processPort(Line aLine, Port port) {
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

	protected Integer findPosInBlock(System aSystem, Port port) {
		int index = aSystem.getInports().indexOf(port);
		if ( index == -1 ) {
			index = aSystem.getOutports().indexOf(port);
		}		
		return index+1;
	}

	protected System obtainPortParent(Port port) {
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

	protected SystemReference findBlockNameWithinReferences(Line aLine, System portParentSys) {
		for (SystemReference sysRef : aLine.getParent().getChildren()) {
			if ( sysRef.getTarget() == portParentSys ) {
				return sysRef; 
				}
		}
		return null;
	}

	protected boolean portBelongsToSubsystem(Line aLine, System portParentSys) {
		if ( aLine.getParent() == portParentSys ) { 
			return false;}
		else { 
			return true; }
	}

	protected void visitChildren(EList<SystemReference> children) {
		for (SystemReference systemReference : children) {
			visit( systemReference );
		}
	}

	protected void visit(SystemReference systemReference) {
		String parentName = systemReference.getParent().getSimulinkName();
		computeEnclosingSimulinkName( systemReference, parentName );
		visit( systemReference.getTarget() );
	}

	
	protected void visitOutports(EList<Outport> outports) {
		String parentName;
		for (Outport outport : outports) {
			parentName = outport.getParent().getSimulinkName();
			addTypeSuffixIfNeeded( outport, "_Out" );
			visit(outport, parentName);
		}
		
	}

	protected void visitInports(EList<Inport> inports) {
		String parentName;
		for (Inport inport : inports) {
			parentName = inport.getParent().getSimulinkName();
			addTypeSuffixIfNeeded( inport, "_In" );
			visit(inport, parentName);
		}
	}

	protected void visit(Port port, String parentName) {
		computeEnclosingSimulinkName(port, parentName);	
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
	
	
	@Override
	public void visit(Object anObject) {
		//You should not be here
		assert( false );
	}
}
