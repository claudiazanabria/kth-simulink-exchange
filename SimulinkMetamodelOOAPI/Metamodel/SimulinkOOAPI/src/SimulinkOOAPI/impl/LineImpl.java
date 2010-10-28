/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package SimulinkOOAPI.impl;

import SimulinkOOAPI.Inport;
import SimulinkOOAPI.Library;
import SimulinkOOAPI.Line;
import SimulinkOOAPI.Model;
import SimulinkOOAPI.Outport;
import SimulinkOOAPI.Port;
import SimulinkOOAPI.ReflectionList;
import SimulinkOOAPI.SimulinkOOAPIPackage;
import SimulinkOOAPI.System;
import SimulinkOOAPI.util.AssertionRunner;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Line</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link SimulinkOOAPI.impl.LineImpl#getSource <em>Source</em>}</li>
 *   <li>{@link SimulinkOOAPI.impl.LineImpl#getDestination <em>Destination</em>}</li>
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
	
	
	private LineImpl(String name, Outport source, Inport destination){
		super(name);
		AssertionRunner.assertOr(
				AssertionRunner.assertion("Ports must belong to the same system.", 
						                  LineImpl.portsBelongToTheSameSystem(source, destination)),
				AssertionRunner.assertion("Can connect system only to the first level children system.", 
						                  LineImpl.canConnectPortsAtDifferentLevels(source, destination)),
				AssertionRunner.assertion("Can connect ports on different systems of the same childen level.", 
						                  LineImpl.canConnectPortsAtTheSameLevel(source, destination))
		);
		
		this.source = source;
		this.destination = destination;
	}
	
	protected LineImpl(String name, System parent, Outport source, Inport destination){
		this(name, source, destination);
		parent.addChild(this);		
	}
	
	protected LineImpl(String name, Model parent, Outport source, Inport destination){
		this(name, source, destination);
		parent.addChild(this);		
	}
	
	protected LineImpl(String name, Library parent, Outport source, Inport destination){
		this(name, source, destination);
		parent.addChild(this);
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
	
	/**
	 * @generated NOT
	 */
	public void ifLineAddToList(ReflectionList<Line> list){
		list.add(this);
	}
	
	/**
	 * Returns new instance of Line with the given name within the given model between the inport and the outport.
	 */
	public static Line newNamedWithinFromTo(String name, Model parent, Outport source, Inport destination){
		Line line = new LineImpl(name, parent, source, destination);		
		return line;
	}
	
	/**
	 * Returns new instance of Line with the given name within the given system between the inport and the outport.
	 */
	public static Line newNamedWithinFromTo(String name, System parent, Outport source, Inport destination){
		Line line = new LineImpl(name, parent, source, destination);		
		return line;
	}
	
	/**
	 * Returns new instance of Line with the given name within the given library between the inport and the outport.
	 */
	public static Line newNamedWithinFromTo(String name, Library parent, Outport source, Inport destination){
		Line line = new LineImpl(name, parent, source, destination);		
		return line;
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
		
		return !sourceSystem.equals(destinationSystem);
	}

} //LineImpl
