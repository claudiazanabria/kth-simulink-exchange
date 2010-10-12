/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package SimulinkOOAPI;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Children Support</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see SimulinkOOAPI.SimulinkOOOAPIPackage#getChildrenSupport()
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
	public EList<ProtoObject> getChildren();
	
	/**
	 * Returns EList of children of GainBlock type.
	 * 
	 * @generated NOT
	 */
	public EList<GainBlock> getChildrenOfTypeGainBlock();
	
} // ChildrenSupport
