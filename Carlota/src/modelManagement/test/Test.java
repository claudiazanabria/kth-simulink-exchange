package modelManagement.test;


import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EStructuralFeature;

import modelManagement.exceptions.InvalidModelException;
import modelManagement.simulink.SimulinkModelManager;
import Simulink.Model;
import Simulink.System;
import Simulink.SimulinkPackage;

public class Test {
	
	public static void main(String[] args) throws InvalidModelException {
		String path = "testWorkspace/demo.simulink";
		SimulinkModelManager mm = new SimulinkModelManager( path );
		mm.loadIt();
		Model top = (Model) mm.getTopElement();
		System root = top.getRoot();
		Observer observer = new Observer();
		EAttribute uuid = SimulinkPackage.eINSTANCE.getProtoObject_Uuid();
		uuid.eAdapters().add( observer );
		//root.eAdapters().add( observer );
		java.lang.System.out.println("Started!");
		root.setUuid("Ale");
		root.setUuid("Emma");
		java.lang.System.out.println("ended.");
	}

}
