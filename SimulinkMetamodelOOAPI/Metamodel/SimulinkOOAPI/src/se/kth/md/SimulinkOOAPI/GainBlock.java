/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package se.kth.md.SimulinkOOAPI;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gain Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link se.kth.md.SimulinkOOAPI.GainBlock#getGain <em>Gain</em>}</li>
 * </ul>
 * </p>
 *
 * @see se.kth.md.SimulinkOOAPI.SimulinkOOAPIPackage#getGainBlock()
 * @model
 * @generated
 */
public interface GainBlock extends ProtoObject {
	/**
	 * Returns the value of the '<em><b>Gain</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gain</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gain</em>' attribute.
	 * @see #setGain(int)
	 * @see se.kth.md.SimulinkOOAPI.SimulinkOOAPIPackage#getGainBlock_Gain()
	 * @model
	 * @generated
	 */
	int getGain();

	/**
	 * Sets the value of the '{@link se.kth.md.SimulinkOOAPI.GainBlock#getGain <em>Gain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gain</em>' attribute.
	 * @see #getGain()
	 * @generated
	 */
	void setGain(int value);

} // IGainBlock
