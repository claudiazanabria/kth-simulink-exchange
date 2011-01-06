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

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import se.kth.md.SimulinkOOAPI.GainBlock;
import se.kth.md.SimulinkOOAPI.Library;
import se.kth.md.SimulinkOOAPI.Model;
import se.kth.md.SimulinkOOAPI.SimulinkList;
import se.kth.md.SimulinkOOAPI.SimulinkOOAPIPackage;
import se.kth.md.SimulinkOOAPI.System;
import se.kth.md.SimulinkOOAPI.exceptions.AddChildException;
import se.kth.md.SimulinkOOAPI.exceptions.ProtoObjectCreationException;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gain Block</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link se.kth.md.SimulinkOOAPI.impl.GainBlockImpl#getGain <em>Gain</em>}</li>
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
	
	/**
	 * Constructs a gain block with the given name, with the given gain, contained within the given system.	 
	 * @throws ProtoObjectCreationException 
	 */
	protected GainBlockImpl(String name, System parent, int gain) throws ProtoObjectCreationException {
		super(name);
		try {
			parent.addChild(this);
		} catch (AddChildException e) {
			//Should not happen. Gain block can be added to system.
		}
		this.gain = gain;
	}	
	
	/**
	 * Constructs a gain block with the given name, with the given gain, contained within the given library.	 
	 * @throws ProtoObjectCreationException 
	 */
	protected GainBlockImpl(String name, Library parent, int gain) throws ProtoObjectCreationException {
		super(name);
		try {
			parent.addChild(this);
		} catch (AddChildException e) {
			//Should not happen. Gain blocks can be added to library.
		}
		this.gain = gain;
	}	
	
	/**
	 * Constructs a gain block with the given name, with the given gain, contained within the given model.	 
	 * @throws ProtoObjectCreationException 
	 */
	protected GainBlockImpl(String name, Model parent, int gain) throws ProtoObjectCreationException {
		super(name);
		try {
			parent.addChild(this);
		} catch (AddChildException e) {
			//Should not happen. Gain blocks can be added to models.
		}
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
	
	@Override
	public void ifGainBlockAddToList(SimulinkList<GainBlock> list) {
		list.add(this);		
	}
	
	/**
	 * Returns new instance of GainBlock with the given name, with the given gain, contains within the given system.
	 * @throws ProtoObjectCreationException 
	 */	
	protected static GainBlock newNamedWithinWithGain(String name, System parent, int gain) throws ProtoObjectCreationException{		
		return new GainBlockImpl(name, parent, gain);
	}
	
	/**
	 * Returns new instance of GainBlock with the given name, with the given gain, contains within the given library.
	 * @throws ProtoObjectCreationException 
	 */	
	protected static GainBlock newNamedWithinWithGain(String name, Library parent, int gain) throws ProtoObjectCreationException{		
		return new GainBlockImpl(name, parent, gain);
	}	
	
	/**
	 * Returns new instance of GainBlock with the given name, with the given gain, contains within the given model.
	 * @throws ProtoObjectCreationException 
	 */	
	protected static GainBlock newNamedWithinWithGain(String name, Model parent, int gain) throws ProtoObjectCreationException{		
		return new GainBlockImpl(name, parent, gain);
	}	
	
	
	@Deprecated
	public static GainBlock newFromDictionary(Map<String, Object> constructDict) throws ProtoObjectCreationException{
		//TODO: add error messages
		if (!constructDict.containsKey(FactoryImpl.keyWithName))			
			throw new ProtoObjectCreationException("");
		if (!constructDict.containsKey(FactoryImpl.keyWithin))			
			throw new ProtoObjectCreationException("");
		if (!constructDict.containsKey(FactoryImpl.keyWithGain))			
			throw new ProtoObjectCreationException("");
		
		//TODO: add check for the type casting
		int gain = ((Integer) constructDict.get(FactoryImpl.keyWithGain)).intValue();
		String name = (String) constructDict.get(FactoryImpl.keyWithName);
		System system = null;
		Library library = null;
		Object parent = constructDict.get(FactoryImpl.keyWithin);
		if (parent instanceof Library)
			library = (Library) parent;
		else
			system = (System)parent;
		
		if (system != null)
			return new GainBlockImpl(name, system, gain);
		else
			return new GainBlockImpl(name, library, gain);		
	}

} //GainBlock
