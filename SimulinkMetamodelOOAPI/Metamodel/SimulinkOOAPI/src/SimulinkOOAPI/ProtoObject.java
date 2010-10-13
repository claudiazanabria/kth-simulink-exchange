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
 * A representation of the model object '<em><b>Proto Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link SimulinkOOAPI.ProtoObject#getIdentity <em>Identity</em>}</li>
 * </ul>
 * </p>
 *
 * @see SimulinkOOAPI.SimulinkOOAPIPackage#getProtoObject()
 * @model abstract="true"
 * @generated
 */
public interface ProtoObject extends EObject {
	/**
	 * Returns the value of the '<em><b>Identity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identity</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identity</em>' reference.
	 * @see #setIdentity(Identity)
	 * @see SimulinkOOAPI.SimulinkOOAPIPackage#getProtoObject_Identity()
	 * @model required="true"
	 * @generated
	 */
	Identity getIdentity();

	/**
	 * Sets the value of the '{@link SimulinkOOAPI.ProtoObject#getIdentity <em>Identity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identity</em>' reference.
	 * @see #getIdentity()
	 * @generated
	 */
	void setIdentity(Identity value);
	
	/**
	 * The element adds itself to list only if it is instance of GainBlock.	  
	 * @param list
	 * @generated NOT
	 */
	public void ifGainBlockAddToList(ReflectionList<GainBlock> list);
	
	/**
	 * The element adds itself to list only if it is instance of System.	  
	 * @param list
	 * @generated NOT
	 */
	public void ifSystemAddToList(ReflectionList<System> list);
	
	/**
	 * The element adds itself to list only if it is instance of Line.	  
	 * @param list
	 * @generated NOT
	 */
	public void ifLineAddToList(ReflectionList<Line> list);
	
	/**
	 * The element adds itself to list only if it is instance of Port.	  
	 * @param list
	 * @generated NOT
	 */
	public void ifPortAddToList(ReflectionList<Port> list);

} // ProtoObject
