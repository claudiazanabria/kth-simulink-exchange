/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package Simulink.impl;

import Simulink.Line;
import Simulink.Port;
import Simulink.SimulinkPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

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
 *   <li>{@link Simulink.impl.LineImpl#getSimuNameSrc <em>Simu Name Src</em>}</li>
 *   <li>{@link Simulink.impl.LineImpl#getSimuNameDst <em>Simu Name Dst</em>}</li>
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
	 * The default value of the '{@link #getSimuNameSrc() <em>Simu Name Src</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimuNameSrc()
	 * @generated
	 * @ordered
	 */
	protected static final String SIMU_NAME_SRC_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSimuNameSrc() <em>Simu Name Src</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimuNameSrc()
	 * @generated
	 * @ordered
	 */
	protected String simuNameSrc = SIMU_NAME_SRC_EDEFAULT;

	/**
	 * The default value of the '{@link #getSimuNameDst() <em>Simu Name Dst</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimuNameDst()
	 * @generated
	 * @ordered
	 */
	protected static final String SIMU_NAME_DST_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSimuNameDst() <em>Simu Name Dst</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimuNameDst()
	 * @generated
	 * @ordered
	 */
	protected String simuNameDst = SIMU_NAME_DST_EDEFAULT;

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
	public Port getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (Port)eResolveProxy(oldSource);
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
	public Port basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSource(Port newSource, NotificationChain msgs) {
		Port oldSource = source;
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
	public void setSource(Port newSource) {
		if (newSource != source) {
			NotificationChain msgs = null;
			if (source != null)
				msgs = ((InternalEObject)source).eInverseRemove(this, SimulinkPackage.PORT__CONNECTIONS, Port.class, msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, SimulinkPackage.PORT__CONNECTIONS, Port.class, msgs);
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
	public Port getDestination() {
		if (destination != null && destination.eIsProxy()) {
			InternalEObject oldDestination = (InternalEObject)destination;
			destination = (Port)eResolveProxy(oldDestination);
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
			eNotify(new ENotificationImpl(this, Notification.SET, SimulinkPackage.LINE__DESTINATION, oldDestination, destination));
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
	public String getSimuNameSrc() {
		return simuNameSrc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimuNameSrc(String newSimuNameSrc) {
		String oldSimuNameSrc = simuNameSrc;
		simuNameSrc = newSimuNameSrc;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulinkPackage.LINE__SIMU_NAME_SRC, oldSimuNameSrc, simuNameSrc));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSimuNameDst() {
		return simuNameDst;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimuNameDst(String newSimuNameDst) {
		String oldSimuNameDst = simuNameDst;
		simuNameDst = newSimuNameDst;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulinkPackage.LINE__SIMU_NAME_DST, oldSimuNameDst, simuNameDst));
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
					msgs = ((InternalEObject)source).eInverseRemove(this, SimulinkPackage.PORT__CONNECTIONS, Port.class, msgs);
				return basicSetSource((Port)otherEnd, msgs);
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
			case SimulinkPackage.LINE__SIMU_NAME_SRC:
				return getSimuNameSrc();
			case SimulinkPackage.LINE__SIMU_NAME_DST:
				return getSimuNameDst();
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
				setSource((Port)newValue);
				return;
			case SimulinkPackage.LINE__DESTINATION:
				setDestination((Port)newValue);
				return;
			case SimulinkPackage.LINE__PARENT:
				setParent((Simulink.System)newValue);
				return;
			case SimulinkPackage.LINE__SIMU_NAME_SRC:
				setSimuNameSrc((String)newValue);
				return;
			case SimulinkPackage.LINE__SIMU_NAME_DST:
				setSimuNameDst((String)newValue);
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
				setSource((Port)null);
				return;
			case SimulinkPackage.LINE__DESTINATION:
				setDestination((Port)null);
				return;
			case SimulinkPackage.LINE__PARENT:
				setParent((Simulink.System)null);
				return;
			case SimulinkPackage.LINE__SIMU_NAME_SRC:
				setSimuNameSrc(SIMU_NAME_SRC_EDEFAULT);
				return;
			case SimulinkPackage.LINE__SIMU_NAME_DST:
				setSimuNameDst(SIMU_NAME_DST_EDEFAULT);
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
			case SimulinkPackage.LINE__SIMU_NAME_SRC:
				return SIMU_NAME_SRC_EDEFAULT == null ? simuNameSrc != null : !SIMU_NAME_SRC_EDEFAULT.equals(simuNameSrc);
			case SimulinkPackage.LINE__SIMU_NAME_DST:
				return SIMU_NAME_DST_EDEFAULT == null ? simuNameDst != null : !SIMU_NAME_DST_EDEFAULT.equals(simuNameDst);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (simuNameSrc: ");
		result.append(simuNameSrc);
		result.append(", simuNameDst: ");
		result.append(simuNameDst);
		result.append(')');
		return result.toString();
	}

} //LineImpl
