/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package SimulinkOOAPI;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Children Support</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see SimulinkOOAPI.SimulinkOOAPIPackage#getChildrenSupport()
 * @model
 * @generated
 */
public interface ChildrenSupport extends EObject {
	
	/**
	 * Adds a ProtoObject to children list.
	 * 
	 * @generated NOT
	 */
	public void addChild(ProtoObject child);
	
	/**
	 * Returns a number of all children.
	 * 
	 * @generated NOT
	 */
	public int getNumberOfChildren();
	
	/**
	 * Returns EList of all children.
	 * 
	 * @generated NOT
	 */
	public ReflectionList<ProtoObject> getChildren();
	
	/**
	 * Returns EList of children of GainBlock type.
	 * 
	 * @generated NOT
	 */
	public ReflectionList<GainBlock> getChildrenOfTypeGainBlock();
	
	/**
	 * Returns EList of children of Line type.
	 * 
	 * @generated NOT
	 */
	public ReflectionList<Line> getChildrenOfTypeLine();
	
	/**
	 * Returns EList of children of Port type.
	 * 
	 * @generated NOT
	 */
	public ReflectionList<Port> getChildrenOfTypePort();
	
	/**
	 * Returns EList of children of System type.
	 * 
	 * @generated NOT
	 */
	public ReflectionList<System> getChildrenOfTypeSystem();
	
} // ChildrenSupport
