/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package Simulink;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Simulink.System#getChildren <em>Children</em>}</li>
 *   <li>{@link Simulink.System#getLines <em>Lines</em>}</li>
 *   <li>{@link Simulink.System#getInports <em>Inports</em>}</li>
 *   <li>{@link Simulink.System#getOutports <em>Outports</em>}</li>
 *   <li>{@link Simulink.System#getFilename <em>Filename</em>}</li>
 * </ul>
 * </p>
 *
 * @see Simulink.SimulinkPackage#getSystem()
 * @model
 * @generated
 */
public interface System extends ProtoObject {
	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link Simulink.SystemReference}.
	 * It is bidirectional and its opposite is '{@link Simulink.SystemReference#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see Simulink.SimulinkPackage#getSystem_Children()
	 * @see Simulink.SystemReference#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
	EList<SystemReference> getChildren();

	/**
	 * Returns the value of the '<em><b>Lines</b></em>' containment reference list.
	 * The list contents are of type {@link Simulink.Line}.
	 * It is bidirectional and its opposite is '{@link Simulink.Line#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lines</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lines</em>' containment reference list.
	 * @see Simulink.SimulinkPackage#getSystem_Lines()
	 * @see Simulink.Line#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
	EList<Line> getLines();

	/**
	 * Returns the value of the '<em><b>Inports</b></em>' containment reference list.
	 * The list contents are of type {@link Simulink.Inport}.
	 * It is bidirectional and its opposite is '{@link Simulink.Inport#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inports</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inports</em>' containment reference list.
	 * @see Simulink.SimulinkPackage#getSystem_Inports()
	 * @see Simulink.Inport#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
	EList<Inport> getInports();

	/**
	 * Returns the value of the '<em><b>Outports</b></em>' containment reference list.
	 * The list contents are of type {@link Simulink.Outport}.
	 * It is bidirectional and its opposite is '{@link Simulink.Outport#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outports</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outports</em>' containment reference list.
	 * @see Simulink.SimulinkPackage#getSystem_Outports()
	 * @see Simulink.Outport#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
	EList<Outport> getOutports();

	/**
	 * Returns the value of the '<em><b>Filename</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Filename</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Filename</em>' attribute.
	 * @see #setFilename(String)
	 * @see Simulink.SimulinkPackage#getSystem_Filename()
	 * @model
	 * @generated
	 */
	String getFilename();

	/**
	 * Sets the value of the '{@link Simulink.System#getFilename <em>Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filename</em>' attribute.
	 * @see #getFilename()
	 * @generated
	 */
	void setFilename(String value);

} // System
