/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package SimulinkOOAPI;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Library</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link SimulinkOOAPI.Library#getChildren <em>Children</em>}</li>
 * </ul>
 * </p>
 *
 * @see SimulinkOOAPI.SimulinkOOAPIPackage#getLibrary()
 * @model
 * @generated
 */
public interface Library extends ProtoObject {

	/**
	 * Returns the value of the '<em><b>Children</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' reference.
	 * @see #isSetChildren()
	 * @see #unsetChildren()
	 * @see #setChildren(ChildrenSupport)
	 * @see SimulinkOOAPI.SimulinkOOAPIPackage#getLibrary_Children()
	 * @model unsettable="true"
	 * @generated
	 */
	ChildrenSupport getChildren();

	/**
	 * Sets the value of the '{@link SimulinkOOAPI.Library#getChildren <em>Children</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Children</em>' reference.
	 * @see #isSetChildren()
	 * @see #unsetChildren()
	 * @see #getChildren()
	 * @generated
	 */
	void setChildren(ChildrenSupport value);

	/**
	 * Unsets the value of the '{@link SimulinkOOAPI.Library#getChildren <em>Children</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetChildren()
	 * @see #getChildren()
	 * @see #setChildren(ChildrenSupport)
	 * @generated
	 */
	void unsetChildren();

	/**
	 * Returns whether the value of the '{@link SimulinkOOAPI.Library#getChildren <em>Children</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Children</em>' reference is set.
	 * @see #unsetChildren()
	 * @see #getChildren()
	 * @see #setChildren(ChildrenSupport)
	 * @generated
	 */
	boolean isSetChildren();
} // Library
