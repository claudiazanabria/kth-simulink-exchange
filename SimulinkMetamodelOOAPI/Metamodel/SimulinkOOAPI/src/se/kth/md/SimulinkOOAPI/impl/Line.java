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

import se.kth.md.SimulinkOOAPI.IInport;
import se.kth.md.SimulinkOOAPI.ILibrary;
import se.kth.md.SimulinkOOAPI.ILine;
import se.kth.md.SimulinkOOAPI.IModel;
import se.kth.md.SimulinkOOAPI.IOutport;
import se.kth.md.SimulinkOOAPI.IPort;
import se.kth.md.SimulinkOOAPI.ISimulinkList;
import se.kth.md.SimulinkOOAPI.ISimulinkOOAPIPackage;
import se.kth.md.SimulinkOOAPI.ISystem;
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
 *   <li>{@link se.kth.md.SimulinkOOAPI.impl.Line#getSource <em>Source</em>}</li>
 *   <li>{@link se.kth.md.SimulinkOOAPI.impl.Line#getDestination <em>Destination</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Line extends ProtoObject implements ILine {
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected IPort source;

	/**
	 * The cached value of the '{@link #getDestination() <em>Destination</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestination()
	 * @generated
	 * @ordered
	 */
	protected IPort destination;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Line() {
		super();
	}
	
	private Line(String name, IOutport source, IInport destination) throws ProtoObjectCreationException{
		super(name);
		AssertionRunner.assertOr(
				AssertionRunner.assertion(ErrorMessages.LINE_PORTS_BELONG_TO_SAME_SYSTEM, 
						                  Line.portsBelongToTheSameSystem(source, destination)),
				AssertionRunner.assertion(ErrorMessages.LINE_CONNECT_DIFFERENT_LEVEL_PORTS, 
						                  Line.canConnectPortsAtDifferentLevels(source, destination)),
				AssertionRunner.assertion(ErrorMessages.LINE_CONNECT_SAME_LEVEL_PORTS, 
						                  Line.canConnectPortsAtTheSameLevel(source, destination))
		);
		
		this.source = source;
		this.destination = destination;
	}
	
	protected Line(String name, ISystem parent, IOutport source, IInport destination) throws ProtoObjectCreationException{
		this(name, source, destination);
		try {
			parent.addChild(this);
		} catch (AddChildException e) {
			//Should not happen. Line can be added to system.
		}		
	}
	
	protected Line(String name, IModel parent, IOutport source, IInport destination) throws ProtoObjectCreationException{
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
		return ISimulinkOOAPIPackage.Literals.LINE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IPort getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (IPort)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ISimulinkOOAPIPackage.LINE__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IPort basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(IPort newSource) {
		IPort oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ISimulinkOOAPIPackage.LINE__SOURCE, oldSource, source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IPort getDestination() {
		if (destination != null && destination.eIsProxy()) {
			InternalEObject oldDestination = (InternalEObject)destination;
			destination = (IPort)eResolveProxy(oldDestination);
			if (destination != oldDestination) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ISimulinkOOAPIPackage.LINE__DESTINATION, oldDestination, destination));
			}
		}
		return destination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IPort basicGetDestination() {
		return destination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDestination(IPort newDestination) {
		IPort oldDestination = destination;
		destination = newDestination;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ISimulinkOOAPIPackage.LINE__DESTINATION, oldDestination, destination));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ISimulinkOOAPIPackage.LINE__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case ISimulinkOOAPIPackage.LINE__DESTINATION:
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
			case ISimulinkOOAPIPackage.LINE__SOURCE:
				setSource((IPort)newValue);
				return;
			case ISimulinkOOAPIPackage.LINE__DESTINATION:
				setDestination((IPort)newValue);
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
			case ISimulinkOOAPIPackage.LINE__SOURCE:
				setSource((IPort)null);
				return;
			case ISimulinkOOAPIPackage.LINE__DESTINATION:
				setDestination((IPort)null);
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
			case ISimulinkOOAPIPackage.LINE__SOURCE:
				return source != null;
			case ISimulinkOOAPIPackage.LINE__DESTINATION:
				return destination != null;
		}
		return super.eIsSet(featureID);
	}
	
	@Override
	public void ifLineAddToList(ISimulinkList<ILine> list){
		list.add(this);
	}
	
	/**
	 * Returns new instance of Line with the given name within the given model between the inport and the outport.
	 * @throws ProtoObjectCreationException 
	 */	
	protected static ILine newNamedWithinFromTo(String name, IModel parent, IOutport source, IInport destination) throws ProtoObjectCreationException{		
		return new Line(name, parent, source, destination);
	}
	
	/**
	 * Returns new instance of Line with the given name within the given system between the inport and the outport.
	 * @throws ProtoObjectCreationException 
	 */	
	protected static ILine newNamedWithinFromTo(String name, ISystem parent, IOutport source, IInport destination) throws ProtoObjectCreationException{
		return new Line(name, parent, source, destination);
	}
	
	/**
	 * Returns true if the two ports belong to the same system i e has the common system as a parent.
	 */
	public static boolean portsBelongToTheSameSystem(IPort portA, IPort portB){
		return portA.getParent().equals(portB.getParent());
	}
	
	/**
	 * Checks that system can be connected to the child system at the first level of children.	 
	 * Returns true if the destination port belongs to the first level children of the source port parent system or
	 * if the source port belongs to the first level children of the destination port parent system.
	 */
	public static boolean canConnectPortsAtDifferentLevels(IOutport source, IInport destination) {
		ISystem sourceSystem = source.getParent();
		ISystem destinationSystem = destination.getParent();
		return destinationSystem.isParentOf(sourceSystem) 
				|| sourceSystem.isParentOf(destinationSystem);
	}
	
	/**
	 * Returns true if the ports are on different systems on the same level.
	 */
	public static boolean canConnectPortsAtTheSameLevel(IOutport source, IInport destination) {
		ISystem sourceSystem = source.getParent();
		ISystem destinationSystem = destination.getParent();
		
		return !sourceSystem.equals(destinationSystem) && 
		       sourceSystem.getParent().equals(destinationSystem.getParent()) ;
	}	
	
	@Override
	public void addTo(ILibrary parent) throws AddChildException {
		throw new AddChildException(this, parent);		
	}
	
	@Deprecated
	public static ILine newFromDictionary(Map<String, Object> constructDict) throws ProtoObjectCreationException{
		//TODO: add error messages
		if (!constructDict.containsKey(Factory.keyWithName))			
			throw new ProtoObjectCreationException("");
		if (!constructDict.containsKey(Factory.keyWithin))			
			throw new ProtoObjectCreationException("");
		if (!constructDict.containsKey(Factory.keyFrom))			
			throw new ProtoObjectCreationException("");
		if (!constructDict.containsKey(Factory.keyTo))			
			throw new ProtoObjectCreationException("");
		
		//TODO: add check for the type casting
		IOutport from = (IOutport) constructDict.get(Factory.keyFrom);
		IInport to = (IInport) constructDict.get(Factory.keyTo);
		String name = (String) constructDict.get(Factory.keyWithName);
		ISystem system = null;
		IModel model = null;
		Object parent = constructDict.get(Factory.keyWithin);
		if (parent instanceof IModel)
			model = (IModel) parent;
		else
			system = (ISystem)parent;
		
		if (system != null)
			return new Line(name, system, from, to);
		else
			return new Line(name, model, from, to);		
	}


} //Line
