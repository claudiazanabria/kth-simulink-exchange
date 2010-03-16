/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package Simulink;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Line</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Simulink.Line#getSource <em>Source</em>}</li>
 *   <li>{@link Simulink.Line#getDestination <em>Destination</em>}</li>
 *   <li>{@link Simulink.Line#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @see Simulink.SimulinkPackage#getLine()
 * @model
 * @generated
 */
public interface Line extends ProtoObject {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link Simulink.Outport#getConnections <em>Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Outport)
	 * @see Simulink.SimulinkPackage#getLine_Source()
	 * @see Simulink.Outport#getConnections
	 * @model opposite="connections" required="true"
	 * @generated
	 */
	Outport getSource();

	/**
	 * Sets the value of the '{@link Simulink.Line#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Outport value);

	/**
	 * Returns the value of the '<em><b>Destination</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link Simulink.Inport#getConnections <em>Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Destination</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destination</em>' reference.
	 * @see #setDestination(Inport)
	 * @see Simulink.SimulinkPackage#getLine_Destination()
	 * @see Simulink.Inport#getConnections
	 * @model opposite="connections" required="true"
	 * @generated
	 */
	Inport getDestination();

	/**
	 * Sets the value of the '{@link Simulink.Line#getDestination <em>Destination</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destination</em>' reference.
	 * @see #getDestination()
	 * @generated
	 */
	void setDestination(Inport value);

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link Simulink.System#getLines <em>Lines</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(Simulink.System)
	 * @see Simulink.SimulinkPackage#getLine_Parent()
	 * @see Simulink.System#getLines
	 * @model opposite="lines" required="true" transient="false"
	 * @generated
	 */
	Simulink.System getParent();

	/**
	 * Sets the value of the '{@link Simulink.Line#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(Simulink.System value);

} // Line
