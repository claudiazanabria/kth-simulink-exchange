package modelManagement.test;

import java.util.ArrayList;

import org.junit.Test;

import Simulink.Model;
import Simulink.ProtoObject;

import modelManagement.exceptions.InvalidModelException;
import modelManagement.simulink.ModelProcessor;
import modelManagement.simulink.SimulinkModelManager;


public class ModelProcessorTest {

	ModelProcessor modelProcessor = new ModelProcessor();
	
	@Test
	public void testModelCreator() {
		String file = "testWorkspace/yorkest.simulink";
		SimulinkModelManager mm = new SimulinkModelManager( file );
		try {
			mm.loadIt();
		} catch (InvalidModelException e) {
			e.printStackTrace();
		}
		Model model = (Model) mm.getTopElement();
		ArrayList<ProtoObject> aList = ModelProcessor.doIt(model);
		aList.size();
		for (ProtoObject obj : aList) {
			String type = obj.eClass().getName();
			System.out.format("%s: %s\n", type, obj);
			//System.out.println( obj );
		}
	}
}
