/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package se.kth.md.SimulinkOOAPI;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Line</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link se.kth.md.SimulinkOOAPI.ILine#getSource <em>Source</em>}</li>
 *   <li>{@link se.kth.md.SimulinkOOAPI.ILine#getDestination <em>Destination</em>}</li>
 * </ul>
 * </p>
 *
 * @see se.kth.md.SimulinkOOAPI.ISimulinkOOAPIPackage#getLine()
 * @model
 * @generated
 */
public interface ILine extends IProtoObject {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(IPort)
	 * @see se.kth.md.SimulinkOOAPI.ISimulinkOOAPIPackage#getLine_Source()
	 * @model required="true"
	 * @generated
	 */
	IPort getSource();

	/**
	 * Sets the value of the '{@link se.kth.md.SimulinkOOAPI.ILine#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(IPort value);

	/**
	 * Returns the value of the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Destination</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destination</em>' reference.
	 * @see #setDestination(IPort)
	 * @see se.kth.md.SimulinkOOAPI.ISimulinkOOAPIPackage#getLine_Destination()
	 * @model required="true"
	 * @generated
	 */
	IPort getDestination();

	/**
	 * Sets the value of the '{@link se.kth.md.SimulinkOOAPI.ILine#getDestination <em>Destination</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destination</em>' reference.
	 * @see #getDestination()
	 * @generated
	 */
	void setDestination(IPort value);

} // ILine
