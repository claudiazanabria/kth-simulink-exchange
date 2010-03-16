/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package Simulink.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;
import Simulink.Inport;
import Simulink.Line;
import Simulink.Outport;
import Simulink.SimulinkPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Line</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link Simulink.impl.LineImpl#getSource <em>Source</em>}</li>
 *   <li>{@link Simulink.impl.LineImpl#getDestination <em>Destination</em>}</li>
 *   <li>{@link Simulink.impl.LineImpl#getParent <em>Parent</em>}</li>
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
	protected Outport source;

	/**
	 * The cached value of the '{@link #getDestination() <em>Destination</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestination()
	 * @generated
	 * @ordered
	 */
	protected Inport destination;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LineImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SimulinkPackage.Literals.LINE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Outport getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (Outport)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SimulinkPackage.LINE__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Outport basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSource(Outport newSource, NotificationChain msgs) {
		Outport oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SimulinkPackage.LINE__SOURCE, oldSource, newSource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(Outport newSource) {
		if (newSource != source) {
			NotificationChain msgs = null;
			if (source != null)
				msgs = ((InternalEObject)source).eInverseRemove(this, SimulinkPackage.OUTPORT__CONNECTIONS, Outport.class, msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, SimulinkPackage.OUTPORT__CONNECTIONS, Outport.class, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulinkPackage.LINE__SOURCE, newSource, newSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Inport getDestination() {
		if (destination != null && destination.eIsProxy()) {
			InternalEObject oldDestination = (InternalEObject)destination;
			destination = (Inport)eResolveProxy(oldDestination);
			if (destination != oldDestination) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SimulinkPackage.LINE__DESTINATION, oldDestination, destination));
			}
		}
		return destination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Inport basicGetDestination() {
		return destination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDestination(Inport newDestination, NotificationChain msgs) {
		Inport oldDestination = destination;
		destination = newDestination;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SimulinkPackage.LINE__DESTINATION, oldDestination, newDestination);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDestination(Inport newDestination) {
		if (newDestination != destination) {
			NotificationChain msgs = null;
			if (destination != null)
				msgs = ((InternalEObject)destination).eInverseRemove(this, SimulinkPackage.INPORT__CONNECTIONS, Inport.class, msgs);
			if (newDestination != null)
				msgs = ((InternalEObject)newDestination).eInverseAdd(this, SimulinkPackage.INPORT__CONNECTIONS, Inport.class, msgs);
			msgs = basicSetDestination(newDestination, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulinkPackage.LINE__DESTINATION, newDestination, newDestination));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Simulink.System getParent() {
		if (eContainerFeatureID() != SimulinkPackage.LINE__PARENT) return null;
		return (Simulink.System)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParent(Simulink.System newParent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParent, SimulinkPackage.LINE__PARENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(Simulink.System newParent) {
		if (newParent != eInternalContainer() || (eContainerFeatureID() != SimulinkPackage.LINE__PARENT && newParent != null)) {
			if (EcoreUtil.isAncestor(this, newParent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParent != null)
				msgs = ((InternalEObject)newParent).eInverseAdd(this, SimulinkPackage.SYSTEM__LINES, Simulink.System.class, msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulinkPackage.LINE__PARENT, newParent, newParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SimulinkPackage.LINE__SOURCE:
				if (source != null)
					msgs = ((InternalEObject)source).eInverseRemove(this, SimulinkPackage.OUTPORT__CONNECTIONS, Outport.class, msgs);
				return basicSetSource((Outport)otherEnd, msgs);
			case SimulinkPackage.LINE__DESTINATION:
				if (destination != null)
					msgs = ((InternalEObject)destination).eInverseRemove(this, SimulinkPackage.INPORT__CONNECTIONS, Inport.class, msgs);
				return basicSetDestination((Inport)otherEnd, msgs);
			case SimulinkPackage.LINE__PARENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParent((Simulink.System)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SimulinkPackage.LINE__SOURCE:
				return basicSetSource(null, msgs);
			case SimulinkPackage.LINE__DESTINATION:
				return basicSetDestination(null, msgs);
			case SimulinkPackage.LINE__PARENT:
				return basicSetParent(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case SimulinkPackage.LINE__PARENT:
				return eInternalContainer().eInverseRemove(this, SimulinkPackage.SYSTEM__LINES, Simulink.System.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SimulinkPackage.LINE__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case SimulinkPackage.LINE__DESTINATION:
				if (resolve) return getDestination();
				return basicGetDestination();
			case SimulinkPackage.LINE__PARENT:
				return getParent();
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
			case SimulinkPackage.LINE__SOURCE:
				setSource((Outport)newValue);
				return;
			case SimulinkPackage.LINE__DESTINATION:
				setDestination((Inport)newValue);
				return;
			case SimulinkPackage.LINE__PARENT:
				setParent((Simulink.System)newValue);
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
			case SimulinkPackage.LINE__SOURCE:
				setSource((Outport)null);
				return;
			case SimulinkPackage.LINE__DESTINATION:
				setDestination((Inport)null);
				return;
			case SimulinkPackage.LINE__PARENT:
				setParent((Simulink.System)null);
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
			case SimulinkPackage.LINE__SOURCE:
				return source != null;
			case SimulinkPackage.LINE__DESTINATION:
				return destination != null;
			case SimulinkPackage.LINE__PARENT:
				return getParent() != null;
		}
		return super.eIsSet(featureID);
	}

} //LineImpl
