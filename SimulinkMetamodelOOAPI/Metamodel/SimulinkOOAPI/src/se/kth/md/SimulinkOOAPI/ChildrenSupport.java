/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package se.kth.md.SimulinkOOAPI;

import org.eclipse.emf.ecore.EObject;

/**
 * A representation of the model object '<em><b>Children Support</b></em>'.
 * The class is responsible for the children storying within a container.
 *
 *
 * @see se.kth.md.SimulinkOOAPI.SimulinkOOAPIPackage#getChildrenSupport()
 * @model
 * @generated
 */
public interface ChildrenSupport extends EObject {
	
	/**
	 * Adds a ProtoObject to children list.	
	 */
	public void addChild(ProtoObject child);
	
	/**
	 * Returns a number of all children.	
	 */
	public int getNumberOfChildren();
	
	/**
	 * Returns EList of all children.	
	 */
	public SimulinkList<ProtoObject> getChildren();
	
	/**
	 * Returns a list of children of IGainBlock type.	
	 */
	public SimulinkList<GainBlock> getChildrenOfTypeGainBlock();
	
	/**
	 * Returns al ist of children of ILine type.
	 */
	public SimulinkList<Line> getChildrenOfTypeLine();
	
	/**
	 * Returns a list of children of IPort type.	
	 */
	public SimulinkList<Port> getChildrenOfTypePort();
	
	/**
	 * Returns a list of children of IInport type.	
	 */	
	public SimulinkList<Inport> getChildrenOfTypeInport();
	
	/**
	 * Returns a list of children of IOutport type.
	 */	
	public SimulinkList<Outport> getChildrenOfTypeOutport();
	
	/**
	 * Returns a list of children of ISystem type.	
	 */
	public SimulinkList<System> getChildrenOfTypeSystem();
	
	/**
	 * Returns a list of children of ISystemReference type.	
	 */
	public SimulinkList<SystemReference> getChildrenOfTypeSystemReference();
} 
