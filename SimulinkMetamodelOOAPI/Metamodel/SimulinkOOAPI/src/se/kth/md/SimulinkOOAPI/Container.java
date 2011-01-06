/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package se.kth.md.SimulinkOOAPI;

import org.eclipse.emf.common.util.EList;
import se.kth.md.SimulinkOOAPI.exceptions.AddChildException;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link se.kth.md.SimulinkOOAPI.Container#getChildren <em>Children</em>}</li>
 * </ul>
 * </p>
 *
 * @see se.kth.md.SimulinkOOAPI.SimulinkOOAPIPackage#getContainer()
 * @model
 * @generated
 */
public interface Container extends ProtoObject {
	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link se.kth.md.SimulinkOOAPI.ProtoObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see se.kth.md.SimulinkOOAPI.SimulinkOOAPIPackage#getContainer_Children()
	 * @model containment="true"
	 * @generated
	 */
	EList<ProtoObject> getChildren();

	/**
	 * Adds a ProtoObject to children list.
	 */
	public void addChild(ProtoObject child) throws AddChildException;
	
	/**
	 * Returns a number of all children.
	 */
	public int getNumberOfChildren();
	
	/**
	 * Returns a list of all children.
	 */
	public EList<ProtoObject> getAllChildren();
	
	/**
	 * Returns a first child met with the given name or uuid.
	 * Returns null if there is no such child.
	 */
	public ProtoObject childWith(String uuidOrName);
	
	/**
	 * Returns a list of children of GainBlock type.
	 */
	public SimulinkList<GainBlock> getChildrenOfTypeGainBlock();	
	
	/**
	 * Returns a list of children of System type.
	 */	
	public SimulinkList<System> getChildrenOfTypeSystem();

} // IContainer
