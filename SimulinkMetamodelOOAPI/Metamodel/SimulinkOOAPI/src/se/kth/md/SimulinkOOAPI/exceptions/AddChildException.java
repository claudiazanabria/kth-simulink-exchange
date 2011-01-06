package se.kth.md.SimulinkOOAPI.exceptions;

import se.kth.md.SimulinkOOAPI.ProtoObject;

/**
 * Exception thrown when a child of the given type cannot be added to a container of such type.
 * 
 */
public class AddChildException extends Exception {
	
	private static final long serialVersionUID = 1L;
	ProtoObject child;
	//TODO: IContainer
	ProtoObject container;
	
	public AddChildException(ProtoObject child, ProtoObject container){
		this.child = child;
		this.container = container;
	}
	
	@Override
	public String getMessage() {		
		return child.getClass() + " cannot be added to " + container.getClass();
	}

}
