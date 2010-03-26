package modelManagement.simulink;

import java.util.ArrayList;

import Simulink.Model;
import Simulink.ProtoObject;

public class ModelProcessor {
	
	Model theModel;
	
	public static ArrayList<ProtoObject> doIt(Model aModel ) {
		
		ModelProcessor mp = new ModelProcessor();
		mp.theModel = aModel;
		return mp.process();
	}
		
	private ArrayList<ProtoObject> process() {
		ArrayList<ProtoObject> list = new ArrayList<ProtoObject>();
		
		computeSimulinkName();
		
		list.add( theModel );
		list.addAll( SystemProcessor.doIt( theModel.getRoot() ));
		return list;
	}

	private void computeSimulinkName() {
		theModel.setSimulinkName( theModel.getName() );	}
}
