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
 * @see se.kth.md.SimulinkOOAPI.ISimulinkOOAPIPackage#getChildrenSupport()
 * @model
 * @generated
 */
public interface IChildrenSupport extends EObject {
	
	/**
	 * Adds a ProtoObject to children list.	
	 */
	public void addChild(IProtoObject child);
	
	/**
	 * Returns a number of all children.	
	 */
	public int getNumberOfChildren();
	
	/**
	 * Returns EList of all children.	
	 */
	public ISimulinkList<IProtoObject> getChildren();
	
	/**
	 * Returns a list of children of IGainBlock type.	
	 */
	public ISimulinkList<IGainBlock> getChildrenOfTypeGainBlock();
	
	/**
	 * Returns al ist of children of ILine type.
	 */
	public ISimulinkList<ILine> getChildrenOfTypeLine();
	
	/**
	 * Returns a list of children of IPort type.	
	 */
	public ISimulinkList<IPort> getChildrenOfTypePort();
	
	/**
	 * Returns a list of children of IInport type.	
	 */	
	public ISimulinkList<IInport> getChildrenOfTypeInport();
	
	/**
	 * Returns a list of children of IOutport type.
	 */	
	public ISimulinkList<IOutport> getChildrenOfTypeOutport();
	
	/**
	 * Returns a list of children of ISystem type.	
	 */
	public ISimulinkList<ISystem> getChildrenOfTypeSystem();
	
	/**
	 * Returns a list of children of ISystemReference type.	
	 */
	public ISimulinkList<ISystemReference> getChildrenOfTypeSystemReference();
} 
