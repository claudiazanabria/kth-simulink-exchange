package se.kth.md.simulinkExchange.modelConversion.simulink;

import se.kth.md.simulinkExchange.modelManagement.exceptions.InvalidModelException;
import se.kth.md.simulinkExchange.modelManagement.simulink.SimulinkModelManager;

import Simulink.Model;
import Simulink.SimulinkFactory;
import Simulink.System;

/**
 * A utility class to create a known model used for testing.
 * TODO: it uses an older API:
 * @author Alex Schenkman.
 *
 */
public class SimulinkDemoModelCreator {

	String pathName = "testWorkspace/demo.simulink";
	SimulinkModelManager modelManager;
	SimulinkEcoreCreator simulinkEcoreCreator;
	System root;
	
	public static void main(String [] args) {
		SimulinkDemoModelCreator mc = new SimulinkDemoModelCreator();
		mc.getNewModelAndNewFile();
		mc.createF1System();
		mc.createF2System();
		mc.createF3System();
		mc.createF2Subsystems();
		mc.createLines();
		mc.save();
	}

	private void save() {
		try {
			Model theModel = simulinkEcoreCreator.getTopElement();
			modelManager.setTopElement( theModel );
			modelManager.validateIt();
			modelManager.saveIt();
		} catch (InvalidModelException e) {
			e.dumpInvalidObjectsToConsole();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void createLines() {
		System f1 = simulinkEcoreCreator.findSystem("F1");
		System f2 = simulinkEcoreCreator.findSystem("F2");
		System f3 = simulinkEcoreCreator.findSystem("F3");
		simulinkEcoreCreator.addLineBetween("L1", f1, f2, root);
		simulinkEcoreCreator.addLineBetween("L2", f2, f3, root);
		System f21 = simulinkEcoreCreator.findSystem("F21");
		System f22 = simulinkEcoreCreator.findSystem("F22");
		simulinkEcoreCreator.addLineBetween("L3", f21, f22, f2);
	}

	private void createF1System() {
		System sys = simulinkEcoreCreator.addSystem("F1", root);
		simulinkEcoreCreator.addOutPort("F1Out", sys);
	}

	private void createF2System() {
		System sys = simulinkEcoreCreator.addSystem("F2", root);
		simulinkEcoreCreator.addOutPort("F2Out", sys);
		simulinkEcoreCreator.addInPort("F2In", sys);
	}
	
	private void createF2Subsystems() {
		System f2 = simulinkEcoreCreator.findSystem("F2");
		System sys = simulinkEcoreCreator.addSystem("F21", f2);
		simulinkEcoreCreator.addOutPort("F21Out", sys);
		simulinkEcoreCreator.addInPort("F21In", sys);

		sys = simulinkEcoreCreator.addSystem("F22", f2);
		simulinkEcoreCreator.addOutPort("F22Out", sys);
		simulinkEcoreCreator.addInPort("F22In", sys);
	}

	private void createF3System() {
		System sys = simulinkEcoreCreator.addSystem("F3", root);
		simulinkEcoreCreator.addOutPort("F3Out", sys);
		simulinkEcoreCreator.addInPort("F3In", sys);
	}
	
	private void getNewModelAndNewFile() {
		modelManager = new SimulinkModelManager(pathName);
		SimulinkFactory factory = modelManager.getFactory();
		simulinkEcoreCreator = new SimulinkEcoreCreator( factory );	
		simulinkEcoreCreator.newModel("York");
		root = simulinkEcoreCreator.addRootSystem("RootSys");
	}
}
