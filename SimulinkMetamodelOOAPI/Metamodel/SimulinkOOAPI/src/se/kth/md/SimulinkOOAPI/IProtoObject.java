/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package se.kth.md.SimulinkOOAPI;

import org.eclipse.emf.ecore.EObject;

import se.kth.md.SimulinkOOAPI.exceptions.AddChildException;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Proto Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link se.kth.md.SimulinkOOAPI.IProtoObject#getIdentity <em>Identity</em>}</li>
 * </ul>
 * </p>
 *
 * @see se.kth.md.SimulinkOOAPI.ISimulinkOOAPIPackage#getProtoObject()
 * @model abstract="true"
 * @generated
 */
public interface IProtoObject extends EObject {
	/**
	 * Returns the value of the '<em><b>Identity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identity</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identity</em>' containment reference.
	 * @see #setIdentity(IIdentity)
	 * @see se.kth.md.SimulinkOOAPI.ISimulinkOOAPIPackage#getProtoObject_Identity()
	 * @model containment="true" required="true"
	 * @generated
	 */
	IIdentity getIdentity();

	/**
	 * Sets the value of the '{@link se.kth.md.SimulinkOOAPI.IProtoObject#getIdentity <em>Identity</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identity</em>' containment reference.
	 * @see #getIdentity()
	 * @generated
	 */
	void setIdentity(IIdentity value);
	
	/***
	 * Returns the object Simulink name
	 */
	public String getName();
	
	/***
	 * Returns the object uuid
	 */
	public String getUuid();
	
	/**
	 * The element adds itself to list only if it is instance of GainBlock.	  
	 * @param list
	 */
	public void ifGainBlockAddToList(ISimulinkList<IGainBlock> list);
	
	/**
	 * The element adds itself to list only if it is instance of System.	  
	 * @param list	 
	 */
	public void ifSystemAddToList(ISimulinkList<ISystem> list);
	
	/**
	 * The element adds itself to list only if it is instance of Line.	  
	 * @param list
	 */
	public void ifLineAddToList(ISimulinkList<ILine> list);
	
	/**
	 * The element adds itself to list only if it is instance of Port.	  
	 * @param list
	 */
	public void ifPortAddToList(ISimulinkList<IPort> list);
	
	/**
	 * The element adds itself to list only if it is instance of SystemReference.	  
	 * @param list
	 */
	public void ifSystemReferenceAddToList(ISimulinkList<ISystemReference> list);
	
	/**
	 * The element adds itself to list only if it is instance of Outport.	  
	 * @param list	
	 */	
	public void ifOutportAddToList(ISimulinkList<IOutport> list);
	
	/**
	 * The element adds itself to list only if it is instance of Inport.	  
	 * @param list	
	 */	
	public void ifInportAddToList(ISimulinkList<IInport> list);
	
	/**
	 * Adds the element to the model children list if the element can be added to the given parent.
	 * Throws {@link se.kth.md.SimulinkOOAPI.exceptions.AddChildException} otherwise.
	 */
	public void addTo(IModel parent) throws AddChildException;
	
	/**
	 * Adds the element to the system children list if the element can be added to the given parent.
	 * Throws {@link se.kth.md.SimulinkOOAPI.exceptions.AddChildException} otherwise. 
	 */
	public void addTo(ISystem parent) throws AddChildException;
	
	/**
	 * Adds the element to the library children list if the element can be added to the given parent.
	 * Throws {@link se.kth.md.SimulinkOOAPI.exceptions.AddChildException} otherwise.
	 */
	public void addTo(ILibrary parent) throws AddChildException;
	
	/**
	 * Returns the proto object whose name or uuid is equals to the given string.
	 * 
	 * The input string is compared with this instance first, then it search in children list.
	 */
	public IProtoObject searchInModel(String nameOrUuid);
	
	/**
	 * Returns a first child met with the given name or uuid.
	 * Returns null if there is no such child or the element is not container.
	 */
	public IProtoObject childWith(String nameOrUuid);
	
	/**
	 * Returns a list of all children for containers; empty list for non-containers.
	 */
	public ISimulinkList<IProtoObject> getAllChildren();

} // IProtoObject
