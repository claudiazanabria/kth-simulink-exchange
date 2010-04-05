package modelManagement.simulink;

import java.util.ArrayList;

import Simulink.Model;
import Simulink.ProtoObject;

public class ModelProcessor {
	
	Model theModel;
	ArrayList<ProtoObject> allElements = new ArrayList<ProtoObject>();
	
	public static ArrayList<ProtoObject> doIt(Model aModel ) {
		
		ModelProcessor mp = new ModelProcessor();
		mp.theModel = aModel;
		return mp.process();
	}
		
	private ArrayList<ProtoObject> process() {
		
		computeSimulinkName();
		
		allElements.add( theModel );
		allElements.addAll( SystemProcessor.doIt( theModel.getRoot() ));
		
		ArrayList<ProtoObject> reorderedList = ListOrganizer.reorder( allElements );
		return reorderedList;
	}
	
	private void computeSimulinkName() {
		theModel.setSimulinkName( theModel.getName() );	}
}
