package se.kth.md.SimulinkOOAPI.exceptions;

import se.kth.md.SimulinkOOAPI.IProtoObject;

/**
 * Exception thrown when a child of the given type cannot be added to a container of such type.
 * 
 */
public class AddChildException extends Exception {
	
	private static final long serialVersionUID = 1L;
	IProtoObject child;
	//TODO: IContainer
	IProtoObject container;
	
	public AddChildException(IProtoObject child, IProtoObject container){
		this.child = child;
		this.container = container;
	}
	
	@Override
	public String getMessage() {		
		return child.getClass() + " cannot be added to " + container.getClass();
	}

}
