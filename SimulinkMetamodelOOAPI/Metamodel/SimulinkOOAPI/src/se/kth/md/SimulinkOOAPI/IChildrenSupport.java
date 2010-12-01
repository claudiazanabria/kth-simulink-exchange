/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package se.kth.md.SimulinkOOAPI;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Children Support</b></em>'.
 * <!-- end-user-doc -->
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
	public IReflectionList<IProtoObject> getChildren();
	
	/**
	 * Returns EList of children of GainBlock type.	
	 */
	public IReflectionList<IGainBlock> getChildrenOfTypeGainBlock();
	
	/**
	 * Returns EList of children of Line type.
	 */
	public IReflectionList<ILine> getChildrenOfTypeLine();
	
	/**
	 * Returns EList of children of Port type.	
	 */
	public IReflectionList<IPort> getChildrenOfTypePort();
	
	/**
	 * Returns EList of children of Inport type.	
	 */	
	public IReflectionList<IInport> getChildrenOfTypeInport();
	
	/**
	 * Returns EList of children of Outport type.
	 */	
	public IReflectionList<IOutport> getChildrenOfTypeOutport();
	
	/**
	 * Returns EList of children of System type.	
	 */
	public IReflectionList<ISystem> getChildrenOfTypeSystem();
	
	/**
	 * Returns EList of children of SystemReference type.	
	 */
	public IReflectionList<ISystemReference> getChildrenOfTypeSystemReference();
} 
