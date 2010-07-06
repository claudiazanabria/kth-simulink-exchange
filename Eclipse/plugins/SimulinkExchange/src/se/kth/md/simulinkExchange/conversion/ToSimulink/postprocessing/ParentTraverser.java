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

import Simulink.Inport;
import Simulink.Line;
import Simulink.Model;
import Simulink.Outport;
import Simulink.System;
import Simulink.SystemReference;
import se.kth.md.simulinkExchange.management.ModelManager;
import se.kth.md.simulinkExchange.management.Traverser;
import se.kth.md.simulinkExchange.management.exceptions.InvalidModelException;
import se.kth.md.simulinkExchange.management.simulink.SimulinkModelManager;

@Deprecated
public class ParentTraverser implements Traverser {

	@Override
	public void doIt(ModelManager manager) {
		Model model = (Model) manager.getTopElement();
		visit( model );
	}

	private void visit(Model model) {
		visit( model.getRoot());
	}

	private void visit(System system) {
		visitChildren( system );
		visitLines( system );
		visitInports( system );
		visitOutports( system );
	}

	private void visitInports(System parentSystem) {
		EList<Inport> ports = parentSystem.getInports();
		for (Inport port : ports) {
			port.setParent( parentSystem );
		}
	}

	private void visitOutports(System parentSystem) {
		EList<Outport> ports = parentSystem.getOutports();
		for (Outport port : ports) {
			port.setParent( parentSystem );
		}
	}

	private void visitLines(System parentSystem) {
		EList<Line> lines = parentSystem.getLines();
		for (Line line : lines) {
			line.setParent( parentSystem );
		}
	}

	private void visitChildren(System parentSystem) {
		EList<SystemReference> children = parentSystem.getChildren();
		for (SystemReference systemReference : children) {
			systemReference.setParent( parentSystem );
			visit( systemReference );
		}
	}

	private void visit(SystemReference systemReference) {
		visit( systemReference.getTarget() );
	}

	@Test
	public void testMain() throws InvalidModelException, IOException {
		String demoFile = "./resources/testFiles/york2135.simulink";
		//String demoFile = "./resources/testFiles/demo.simulink";
		SimulinkModelManager manager = new SimulinkModelManager(demoFile);
		manager.loadIt();
		manager.traverseWith( new ParentTraverser() );
		manager.validateIt();
		manager.saveIt();
	}
	
}
