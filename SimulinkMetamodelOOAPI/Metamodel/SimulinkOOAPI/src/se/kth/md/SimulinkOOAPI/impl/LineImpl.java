/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package se.kth.md.SimulinkOOAPI.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import se.kth.md.SimulinkOOAPI.Inport;
import se.kth.md.SimulinkOOAPI.Library;
import se.kth.md.SimulinkOOAPI.Line;
import se.kth.md.SimulinkOOAPI.Model;
import se.kth.md.SimulinkOOAPI.Outport;
import se.kth.md.SimulinkOOAPI.Port;
import se.kth.md.SimulinkOOAPI.SimulinkList;
import se.kth.md.SimulinkOOAPI.SimulinkOOAPIPackage;
import se.kth.md.SimulinkOOAPI.System;
import se.kth.md.SimulinkOOAPI.exceptions.AddChildException;
import se.kth.md.SimulinkOOAPI.exceptions.ErrorMessages;
import se.kth.md.SimulinkOOAPI.exceptions.ProtoObjectCreationException;
import se.kth.md.SimulinkOOAPI.util.AssertionRunner;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Line</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link se.kth.md.SimulinkOOAPI.impl.LineImpl#getSource <em>Source</em>}</li>
 *   <li>{@link se.kth.md.SimulinkOOAPI.impl.LineImpl#getDestination <em>Destination</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LineImpl extends ProtoObjectImpl implements Line {
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected Port source;

	/**
	 * The cached value of the '{@link #getDestination() <em>Destination</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestination()
	 * @generated
	 * @ordered
	 */
	protected Port destination;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LineImpl() {
		super();
	}
	
	private LineImpl(String name, Outport source, Inport destination) throws ProtoObjectCreationException{
		super(name);
		AssertionRunner.assertOr(
				AssertionRunner.assertion(ErrorMessages.LINE_PORTS_BELONG_TO_SAME_SYSTEM, 
						                  LineImpl.portsBelongToTheSameSystem(source, destination)),
				AssertionRunner.assertion(ErrorMessages.LINE_CONNECT_DIFFERENT_LEVEL_PORTS, 
						                  LineImpl.canConnectPortsAtDifferentLevels(source, destination)),
				AssertionRunner.assertion(ErrorMessages.LINE_CONNECT_SAME_LEVEL_PORTS, 
						                  LineImpl.canConnectPortsAtTheSameLevel(source, destination))
		);
		
		this.source = source;
		this.destination = destination;
	}
	
	protected LineImpl(String name, System parent, Outport source, Inport destination) throws ProtoObjectCreationException{
		this(name, source, destination);
		try {
			parent.addChild(this);
		} catch (AddChildException e) {
			//Should not happen. Line can be added to system.
		}		
	}
	
	protected LineImpl(String name, Model parent, Outport source, Inport destination) throws ProtoObjectCreationException{
		this(name, source, destination);
		try{
			parent.addChild(this);
		}catch(AddChildException e){
			//Should not happen. Lines can be added to models.
		}
	}	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SimulinkOOAPIPackage.Literals.LINE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Port getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (Port)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SimulinkOOAPIPackage.LINE__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Port basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(Port newSource) {
		Port oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulinkOOAPIPackage.LINE__SOURCE, oldSource, source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Port getDestination() {
		if (destination != null && destination.eIsProxy()) {
			InternalEObject oldDestination = (InternalEObject)destination;
			destination = (Port)eResolveProxy(oldDestination);
			if (destination != oldDestination) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SimulinkOOAPIPackage.LINE__DESTINATION, oldDestination, destination));
			}
		}
		return destination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Port basicGetDestination() {
		return destination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDestination(Port newDestination) {
		Port oldDestination = destination;
		destination = newDestination;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulinkOOAPIPackage.LINE__DESTINATION, oldDestination, destination));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SimulinkOOAPIPackage.LINE__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case SimulinkOOAPIPackage.LINE__DESTINATION:
				if (resolve) return getDestination();
				return basicGetDestination();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SimulinkOOAPIPackage.LINE__SOURCE:
				setSource((Port)newValue);
				return;
			case SimulinkOOAPIPackage.LINE__DESTINATION:
				setDestination((Port)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SimulinkOOAPIPackage.LINE__SOURCE:
				setSource((Port)null);
				return;
			case SimulinkOOAPIPackage.LINE__DESTINATION:
				setDestination((Port)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SimulinkOOAPIPackage.LINE__SOURCE:
				return source != null;
			case SimulinkOOAPIPackage.LINE__DESTINATION:
				return destination != null;
		}
		return super.eIsSet(featureID);
	}
	
	@Override
	public void ifLineAddToList(SimulinkList<Line> list){
		list.add(this);
	}
	
	/**
	 * Returns new instance of Line with the given name within the given model between the inport and the outport.
	 * @throws ProtoObjectCreationException 
	 */	
	protected static Line newNamedWithinFromTo(String name, Model parent, Outport source, Inport destination) throws ProtoObjectCreationException{		
		return new LineImpl(name, parent, source, destination);
	}
	
	/**
	 * Returns new instance of Line with the given name within the given system between the inport and the outport.
	 * @throws ProtoObjectCreationException 
	 */	
	protected static Line newNamedWithinFromTo(String name, System parent, Outport source, Inport destination) throws ProtoObjectCreationException{
		return new LineImpl(name, parent, source, destination);
	}
	
	/**
	 * Returns true if the two ports belong to the same system i e has the common system as a parent.
	 */
	public static boolean portsBelongToTheSameSystem(Port portA, Port portB){
		return portA.getParent().equals(portB.getParent());
	}
	
	/**
	 * Checks that system can be connected to the child system at the first level of children.	 
	 * Returns true if the destination port belongs to the first level children of the source port parent system or
	 * if the source port belongs to the first level children of the destination port parent system.
	 */
	public static boolean canConnectPortsAtDifferentLevels(Outport source, Inport destination) {
		System sourceSystem = source.getParent();
		System destinationSystem = destination.getParent();
		return destinationSystem.isParentOf(sourceSystem) 
				|| sourceSystem.isParentOf(destinationSystem);
	}
	
	/**
	 * Returns true if the ports are on different systems on the same level.
	 */
	public static boolean canConnectPortsAtTheSameLevel(Outport source, Inport destination) {
		System sourceSystem = source.getParent();
		System destinationSystem = destination.getParent();
		
		return !sourceSystem.equals(destinationSystem) && 
		       sourceSystem.getParent().equals(destinationSystem.getParent()) ;
	}	
	
	@Override
	public void addTo(Library parent) throws AddChildException {
		throw new AddChildException(this, parent);		
	}
	
	@Deprecated
	public static Line newFromDictionary(Map<String, Object> constructDict) throws ProtoObjectCreationException{
		//TODO: add error messages
		if (!constructDict.containsKey(FactoryImpl.keyWithName))			
			throw new ProtoObjectCreationException("");
		if (!constructDict.containsKey(FactoryImpl.keyWithin))			
			throw new ProtoObjectCreationException("");
		if (!constructDict.containsKey(FactoryImpl.keyFrom))			
			throw new ProtoObjectCreationException("");
		if (!constructDict.containsKey(FactoryImpl.keyTo))			
			throw new ProtoObjectCreationException("");
		
		//TODO: add check for the type casting
		Outport from = (Outport) constructDict.get(FactoryImpl.keyFrom);
		Inport to = (Inport) constructDict.get(FactoryImpl.keyTo);
		String name = (String) constructDict.get(FactoryImpl.keyWithName);
		System system = null;
		Model model = null;
		Object parent = constructDict.get(FactoryImpl.keyWithin);
		if (parent instanceof Model)
			model = (Model) parent;
		else
			system = (System)parent;
		
		if (system != null)
			return new LineImpl(name, system, from, to);
		else
			return new LineImpl(name, model, from, to);		
	}


} //Line
