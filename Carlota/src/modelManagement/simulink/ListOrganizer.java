package modelManagement.simulink;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Simulink.ProtoObject;
import Simulink.SimulinkPackage;

class ListOrganizer {
	ArrayList<ProtoObject> reorderedElements = new ArrayList<ProtoObject>();
	ArrayList<ProtoObject> originalList;
	
	int systemStart;
	int systemEnd;
	
	public ListOrganizer(ArrayList<ProtoObject> allElements) {
		originalList = allElements;
		int size = originalList.size();
		systemEnd 	= size;
		systemStart = size;
	}
	
	public static ArrayList<ProtoObject> reorder(
			ArrayList<ProtoObject> allElements) {

		ListOrganizer lo = new ListOrganizer( allElements );
		return lo.doIt();
		
	}

	private ArrayList<ProtoObject> doIt() {
		
		addTheModelElement();
		findAllSystems();
		findAllSystemReferences();
		finaAllLines();
		
		return reorderedElements;
	}
	
	private void addTheModelElement() {
		reorderedElements.add( originalList.get(0));
	}

	private void findAllSystemReferences() {
		int type;
		ProtoObject obj;
		
		for (int x=originalList.size()-1 ; x >= 1 ; x--) {
			obj = originalList.get(x);
			type = obj.eClass().getClassifierID();
			if ( type == SimulinkPackage.SYSTEM_REFERENCE ) {
				reorderedElements.add( obj );
			}
		}
	}

	private void finaAllLines() {
		int type;
		
		for (ProtoObject obj : originalList) {
			type = obj.eClass().getClassifierID();
			if ( type == SimulinkPackage.LINE ) {
				reorderedElements.add( obj );				
			} 
		}
	}

	private void findAllSystems() {
		List<ProtoObject> subList;
		while ( findNextSystemBackwards() ) {
			subList = originalList.subList(systemStart, systemEnd);
			reorderedElements.addAll( subList );
		}
	}

	private boolean findNextSystemBackwards() {
		List<ProtoObject> subList = originalList.subList(1, systemStart);
		
		boolean foundSystem = findNextSystemStart( subList ) 
								&& findEndOfSystem( systemStart );
		return foundSystem;
	}
	
	private boolean findEndOfSystem(int start) {
		List<ProtoObject> subList = originalList.subList(start+1, systemEnd);

		int type;
		ProtoObject obj;
		
		for (int x=0; x < subList.size() ; x ++) {
			obj = subList.get(x);
			type = obj.eClass().getClassifierID();
			switch ( type ) {
			case SimulinkPackage.SYSTEM_REFERENCE:
			case SimulinkPackage.LINE:
			case SimulinkPackage.SYSTEM:
				systemEnd = start+1+x;
				return true;
			}
		}
		systemEnd = subList.size();
		return true;
	}

	private boolean findNextSystemStart(List<ProtoObject> subList) {
		int type;
		ProtoObject obj;
		
		for (int x=subList.size()-1 ; x >= 0 ; x--) {
			obj = subList.get(x);
			type = obj.eClass().getClassifierID();
			if ( type == SimulinkPackage.SYSTEM ) { 
				systemStart = x;
				return true;
				}
		}
		return false;
	}
}
