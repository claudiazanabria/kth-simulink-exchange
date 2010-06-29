package se.kth.md.simulinkExchange.conversion.simulink.preprocessing;

import java.util.ArrayList;

import org.junit.Test;

import se.kth.md.simulinkExchange.conversion.simulink.preprocessing.ModelProcessor;
import se.kth.md.simulinkExchange.management.exceptions.InvalidModelException;
import se.kth.md.simulinkExchange.management.simulink.SimulinkModelManager;

import Simulink.Line;
import Simulink.Model;
import Simulink.ProtoObject;
import Simulink.SimulinkPackage;


/**
 * This is not really a test, it just dumps the created list.
 * @author Alex Schenkman
 *
 */
public class ModelProcessorTest {

	ModelProcessor modelProcessor = new ModelProcessor();
	
	@Test
	public void testModelCreator() throws InvalidModelException {
		
		//String file = "testWorkspace/yorkest.simulink";
		String file = "F:/Documents/matlab/models/kalle/sldemo_absbrake_ATESST.simulink";
		SimulinkModelManager mm = new SimulinkModelManager( file );
		mm.loadIt();
		mm.validateIt();
		Model model = (Model) mm.getTopElement();
		ArrayList<ProtoObject> aList = ModelProcessor.doIt(model);
		aList.size();
		int x = 0;
		System.out.println("\nFinal Version");
		for (ProtoObject obj : aList) {
			String type = obj.eClass().getName();
			//System.out.format("%s: %s\n", type, obj);
			System.out.format("%2d: %s, %s\n", x, type, obj.getName());
			int id = obj.eClass().getClassifierID();
			switch (id) {
				case SimulinkPackage.LINE: {
					Line line = (Line) obj;
					System.out.format("\t%s --> %s\n", 
							line.getSimuNameSrc(), line.getSimuNameDst());
				}
			}
			x = x+1;
		}
	}
}
