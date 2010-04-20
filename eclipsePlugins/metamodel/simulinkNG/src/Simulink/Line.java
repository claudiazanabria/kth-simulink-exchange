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
 *   <li>{@link Simulink.Line#getSimuNameSrc <em>Simu Name Src</em>}</li>
 *   <li>{@link Simulink.Line#getSimuNameDst <em>Simu Name Dst</em>}</li>
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
	 * It is bidirectional and its opposite is '{@link Simulink.Port#getConnections <em>Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Port)
	 * @see Simulink.SimulinkPackage#getLine_Source()
	 * @see Simulink.Port#getConnections
	 * @model opposite="connections" required="true"
	 * @generated
	 */
	Port getSource();

	/**
	 * Sets the value of the '{@link Simulink.Line#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Port value);

	/**
	 * Returns the value of the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Destination</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destination</em>' reference.
	 * @see #setDestination(Port)
	 * @see Simulink.SimulinkPackage#getLine_Destination()
	 * @model required="true"
	 * @generated
	 */
	Port getDestination();

	/**
	 * Sets the value of the '{@link Simulink.Line#getDestination <em>Destination</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destination</em>' reference.
	 * @see #getDestination()
	 * @generated
	 */
	void setDestination(Port value);

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

	/**
	 * Returns the value of the '<em><b>Simu Name Src</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simu Name Src</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simu Name Src</em>' attribute.
	 * @see #setSimuNameSrc(String)
	 * @see Simulink.SimulinkPackage#getLine_SimuNameSrc()
	 * @model
	 * @generated
	 */
	String getSimuNameSrc();

	/**
	 * Sets the value of the '{@link Simulink.Line#getSimuNameSrc <em>Simu Name Src</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simu Name Src</em>' attribute.
	 * @see #getSimuNameSrc()
	 * @generated
	 */
	void setSimuNameSrc(String value);

	/**
	 * Returns the value of the '<em><b>Simu Name Dst</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simu Name Dst</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simu Name Dst</em>' attribute.
	 * @see #setSimuNameDst(String)
	 * @see Simulink.SimulinkPackage#getLine_SimuNameDst()
	 * @model
	 * @generated
	 */
	String getSimuNameDst();

	/**
	 * Sets the value of the '{@link Simulink.Line#getSimuNameDst <em>Simu Name Dst</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simu Name Dst</em>' attribute.
	 * @see #getSimuNameDst()
	 * @generated
	 */
	void setSimuNameDst(String value);

} // Line
