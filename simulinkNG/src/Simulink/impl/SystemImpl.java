/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package Simulink.impl;

import Simulink.Inport;
import Simulink.Line;
import Simulink.Outport;
import Simulink.SimulinkPackage;
import Simulink.SystemReference;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link Simulink.impl.SystemImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link Simulink.impl.SystemImpl#getLines <em>Lines</em>}</li>
 *   <li>{@link Simulink.impl.SystemImpl#getInports <em>Inports</em>}</li>
 *   <li>{@link Simulink.impl.SystemImpl#getOutports <em>Outports</em>}</li>
 *   <li>{@link Simulink.impl.SystemImpl#getFilename <em>Filename</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SystemImpl extends ProtoObjectImpl implements Simulink.System {
	/**
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<SystemReference> children;

	/**
	 * The cached value of the '{@link #getLines() <em>Lines</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLines()
	 * @generated
	 * @ordered
	 */
	protected EList<Line> lines;

	/**
	 * The cached value of the '{@link #getInports() <em>Inports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInports()
	 * @generated
	 * @ordered
	 */
	protected EList<Inport> inports;

	/**
	 * The cached value of the '{@link #getOutports() <em>Outports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutports()
	 * @generated
	 * @ordered
	 */
	protected EList<Outport> outports;

	/**
	 * The default value of the '{@link #getFilename() <em>Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilename()
	 * @generated
	 * @ordered
	 */
	protected static final String FILENAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFilename() <em>Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilename()
	 * @generated
	 * @ordered
	 */
	protected String filename = FILENAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SimulinkPackage.Literals.SYSTEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SystemReference> getChildren() {
		if (children == null) {
			children = new EObjectContainmentWithInverseEList<SystemReference>(SystemReference.class, this, SimulinkPackage.SYSTEM__CHILDREN, SimulinkPackage.SYSTEM_REFERENCE__PARENT);
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Line> getLines() {
		if (lines == null) {
			lines = new EObjectContainmentWithInverseEList<Line>(Line.class, this, SimulinkPackage.SYSTEM__LINES, SimulinkPackage.LINE__PARENT);
		}
		return lines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Inport> getInports() {
		if (inports == null) {
			inports = new EObjectContainmentWithInverseEList<Inport>(Inport.class, this, SimulinkPackage.SYSTEM__INPORTS, SimulinkPackage.INPORT__PARENT);
		}
		return inports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Outport> getOutports() {
		if (outports == null) {
			outports = new EObjectContainmentWithInverseEList<Outport>(Outport.class, this, SimulinkPackage.SYSTEM__OUTPORTS, SimulinkPackage.OUTPORT__PARENT);
		}
		return outports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFilename(String newFilename) {
		String oldFilename = filename;
		filename = newFilename;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulinkPackage.SYSTEM__FILENAME, oldFilename, filename));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SimulinkPackage.SYSTEM__CHILDREN:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getChildren()).basicAdd(otherEnd, msgs);
			case SimulinkPackage.SYSTEM__LINES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getLines()).basicAdd(otherEnd, msgs);
			case SimulinkPackage.SYSTEM__INPORTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getInports()).basicAdd(otherEnd, msgs);
			case SimulinkPackage.SYSTEM__OUTPORTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutports()).basicAdd(otherEnd, msgs);
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
			case SimulinkPackage.SYSTEM__CHILDREN:
				return ((InternalEList<?>)getChildren()).basicRemove(otherEnd, msgs);
			case SimulinkPackage.SYSTEM__LINES:
				return ((InternalEList<?>)getLines()).basicRemove(otherEnd, msgs);
			case SimulinkPackage.SYSTEM__INPORTS:
				return ((InternalEList<?>)getInports()).basicRemove(otherEnd, msgs);
			case SimulinkPackage.SYSTEM__OUTPORTS:
				return ((InternalEList<?>)getOutports()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SimulinkPackage.SYSTEM__CHILDREN:
				return getChildren();
			case SimulinkPackage.SYSTEM__LINES:
				return getLines();
			case SimulinkPackage.SYSTEM__INPORTS:
				return getInports();
			case SimulinkPackage.SYSTEM__OUTPORTS:
				return getOutports();
			case SimulinkPackage.SYSTEM__FILENAME:
				return getFilename();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SimulinkPackage.SYSTEM__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection<? extends SystemReference>)newValue);
				return;
			case SimulinkPackage.SYSTEM__LINES:
				getLines().clear();
				getLines().addAll((Collection<? extends Line>)newValue);
				return;
			case SimulinkPackage.SYSTEM__INPORTS:
				getInports().clear();
				getInports().addAll((Collection<? extends Inport>)newValue);
				return;
			case SimulinkPackage.SYSTEM__OUTPORTS:
				getOutports().clear();
				getOutports().addAll((Collection<? extends Outport>)newValue);
				return;
			case SimulinkPackage.SYSTEM__FILENAME:
				setFilename((String)newValue);
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
			case SimulinkPackage.SYSTEM__CHILDREN:
				getChildren().clear();
				return;
			case SimulinkPackage.SYSTEM__LINES:
				getLines().clear();
				return;
			case SimulinkPackage.SYSTEM__INPORTS:
				getInports().clear();
				return;
			case SimulinkPackage.SYSTEM__OUTPORTS:
				getOutports().clear();
				return;
			case SimulinkPackage.SYSTEM__FILENAME:
				setFilename(FILENAME_EDEFAULT);
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
			case SimulinkPackage.SYSTEM__CHILDREN:
				return children != null && !children.isEmpty();
			case SimulinkPackage.SYSTEM__LINES:
				return lines != null && !lines.isEmpty();
			case SimulinkPackage.SYSTEM__INPORTS:
				return inports != null && !inports.isEmpty();
			case SimulinkPackage.SYSTEM__OUTPORTS:
				return outports != null && !outports.isEmpty();
			case SimulinkPackage.SYSTEM__FILENAME:
				return FILENAME_EDEFAULT == null ? filename != null : !FILENAME_EDEFAULT.equals(filename);
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
		result.append(" (filename: ");
		result.append(filename);
		result.append(')');
		return result.toString();
	}

} //SystemImpl
