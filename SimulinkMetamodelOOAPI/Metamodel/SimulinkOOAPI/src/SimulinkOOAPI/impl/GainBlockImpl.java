/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package SimulinkOOAPI.impl;

import java.util.Map;

import SimulinkOOAPI.GainBlock;
import SimulinkOOAPI.Library;
import SimulinkOOAPI.Model;
import SimulinkOOAPI.ReflectionList;
import SimulinkOOAPI.SimulinkOOAPIPackage;
import SimulinkOOAPI.System;
import SimulinkOOAPI.util.ErrorMessages;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gain Block</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link SimulinkOOAPI.impl.GainBlockImpl#getGain <em>Gain</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GainBlockImpl extends ProtoObjectImpl implements GainBlock {
	/**
	 * The default value of the '{@link #getGain() <em>Gain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGain()
	 * @generated
	 * @ordered
	 */
	protected static final int GAIN_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getGain() <em>Gain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGain()
	 * @generated
	 * @ordered
	 */
	protected int gain = GAIN_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GainBlockImpl() {
		super();
	}	
	
	protected GainBlockImpl(String name, System parent, int gain) {
		super(name);
		parent.addChild(this);
		this.gain = gain;
	}	
	
	protected GainBlockImpl(String name, Library parent, int gain) {
		super(name);
		parent.addChild(this);
		this.gain = gain;
	}	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SimulinkOOAPIPackage.Literals.GAIN_BLOCK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getGain() {
		return gain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGain(int newGain) {
		int oldGain = gain;
		gain = newGain;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulinkOOAPIPackage.GAIN_BLOCK__GAIN, oldGain, gain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SimulinkOOAPIPackage.GAIN_BLOCK__GAIN:
				return getGain();
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
			case SimulinkOOAPIPackage.GAIN_BLOCK__GAIN:
				setGain((Integer)newValue);
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
			case SimulinkOOAPIPackage.GAIN_BLOCK__GAIN:
				setGain(GAIN_EDEFAULT);
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
			case SimulinkOOAPIPackage.GAIN_BLOCK__GAIN:
				return gain != GAIN_EDEFAULT;
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
		result.append(" (gain: ");
		result.append(gain);
		result.append(')');
		return result.toString();
	}

	/**
	 * @generated NOT
	 */
	@Override
	public void ifGainBlockAddToList(ReflectionList<GainBlock> list) {
		list.add(this);		
	}
	
	/**
	 * Returns new instance of GainBlock with the given name, with the given gain, contains within the given system.
	 * @param name
	 * @param gain
	 * @param system
	 * @return
	 */
	@Deprecated
	public static GainBlock newNamedWithinWithGain(String name, System parent, int gain){
		GainBlock gainBlock = new GainBlockImpl(name, parent, gain);		
		return gainBlock;
	}
	
	/**
	 * Returns new instance of GainBlock with the given name, with the given gain, contains within the given library.
	 * @param name
	 * @param gain
	 * @param system
	 * @return
	 */
	@Deprecated
	public static GainBlock newNamedWithinWithGain(String name, Library parent, int gain){
		GainBlock gainBlock = new GainBlockImpl(name, parent, gain);		
		return gainBlock;
	}

	@Override
	public void addTo(Model parent) {
		throw new IllegalArgumentException(ErrorMessages.GAINBLOCK_ADD_TO_MODEL);		
	}
	
	
	public static GainBlock newFromDictionary(Map<String, Object> constructDict) throws ProtoObjectCreationException{		
		if (!constructDict.containsKey(Factory.keyWithName))			
			throw new ProtoObjectCreationException();
		if (!constructDict.containsKey(Factory.keyWithin))			
			throw new ProtoObjectCreationException();
		if (!constructDict.containsKey(Factory.keyWithGain))			
			throw new ProtoObjectCreationException();
		
		//TODO: add check for the type casting
		int gain = ((Integer) constructDict.get(Factory.keyWithGain)).intValue();
		String name = (String) constructDict.get(Factory.keyWithName);
		System system = null;
		Library library = null;
		Object parent = constructDict.get(Factory.keyWithin);
		if (parent instanceof Library)
			library = (Library) parent;
		else
			system = (System)parent;
		
		if (system != null)
			return new GainBlockImpl(name, system, gain);
		else
			return new GainBlockImpl(name, library, gain);		
	}
	

} //GainBlockImpl
