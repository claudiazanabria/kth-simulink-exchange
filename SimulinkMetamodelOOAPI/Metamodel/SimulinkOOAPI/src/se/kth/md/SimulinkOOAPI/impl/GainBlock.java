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

import se.kth.md.SimulinkOOAPI.IGainBlock;
import se.kth.md.SimulinkOOAPI.ILibrary;
import se.kth.md.SimulinkOOAPI.IModel;
import se.kth.md.SimulinkOOAPI.ISimulinkList;
import se.kth.md.SimulinkOOAPI.ISimulinkOOAPIPackage;
import se.kth.md.SimulinkOOAPI.ISystem;
import se.kth.md.SimulinkOOAPI.exceptions.ProtoObjectCreationException;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gain Block</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link se.kth.md.SimulinkOOAPI.impl.GainBlock#getGain <em>Gain</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GainBlock extends ProtoObject implements IGainBlock {
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
	protected GainBlock() {
		super();
	}
	
	/**
	 * Constructs a gain block with the given name, with the given gain, contained within the given system.	 
	 * @throws ProtoObjectCreationException 
	 */
	protected GainBlock(String name, ISystem parent, int gain) throws ProtoObjectCreationException {
		super(name);
		parent.addChild(this);
		this.gain = gain;
	}	
	
	/**
	 * Constructs a gain block with the given name, with the given gain, contained within the given library.	 
	 * @throws ProtoObjectCreationException 
	 */
	protected GainBlock(String name, ILibrary parent, int gain) throws ProtoObjectCreationException {
		super(name);
		parent.addChild(this);
		this.gain = gain;
	}	
	
	/**
	 * Constructs a gain block with the given name, with the given gain, contained within the given model.	 
	 * @throws ProtoObjectCreationException 
	 */
	protected GainBlock(String name, IModel parent, int gain) throws ProtoObjectCreationException {
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
		return ISimulinkOOAPIPackage.Literals.GAIN_BLOCK;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ISimulinkOOAPIPackage.GAIN_BLOCK__GAIN, oldGain, gain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ISimulinkOOAPIPackage.GAIN_BLOCK__GAIN:
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
			case ISimulinkOOAPIPackage.GAIN_BLOCK__GAIN:
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
			case ISimulinkOOAPIPackage.GAIN_BLOCK__GAIN:
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
			case ISimulinkOOAPIPackage.GAIN_BLOCK__GAIN:
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
	public void ifGainBlockAddToList(ISimulinkList<IGainBlock> list) {
		list.add(this);		
	}
	
	/**
	 * Returns new instance of GainBlock with the given name, with the given gain, contains within the given system.
	 * @throws ProtoObjectCreationException 
	 */	
	protected static IGainBlock newNamedWithinWithGain(String name, ISystem parent, int gain) throws ProtoObjectCreationException{		
		return new GainBlock(name, parent, gain);
	}
	
	/**
	 * Returns new instance of GainBlock with the given name, with the given gain, contains within the given library.
	 * @throws ProtoObjectCreationException 
	 */	
	protected static IGainBlock newNamedWithinWithGain(String name, ILibrary parent, int gain) throws ProtoObjectCreationException{		
		return new GainBlock(name, parent, gain);
	}	
	
	/**
	 * Returns new instance of GainBlock with the given name, with the given gain, contains within the given model.
	 * @throws ProtoObjectCreationException 
	 */	
	protected static IGainBlock newNamedWithinWithGain(String name, IModel parent, int gain) throws ProtoObjectCreationException{		
		return new GainBlock(name, parent, gain);
	}	
	
	
	@Deprecated
	public static IGainBlock newFromDictionary(Map<String, Object> constructDict) throws ProtoObjectCreationException{
		//TODO: add error messages
		if (!constructDict.containsKey(Factory.keyWithName))			
			throw new ProtoObjectCreationException("");
		if (!constructDict.containsKey(Factory.keyWithin))			
			throw new ProtoObjectCreationException("");
		if (!constructDict.containsKey(Factory.keyWithGain))			
			throw new ProtoObjectCreationException("");
		
		//TODO: add check for the type casting
		int gain = ((Integer) constructDict.get(Factory.keyWithGain)).intValue();
		String name = (String) constructDict.get(Factory.keyWithName);
		ISystem system = null;
		ILibrary library = null;
		Object parent = constructDict.get(Factory.keyWithin);
		if (parent instanceof ILibrary)
			library = (ILibrary) parent;
		else
			system = (ISystem)parent;
		
		if (system != null)
			return new GainBlock(name, system, gain);
		else
			return new GainBlock(name, library, gain);		
	}

} //GainBlock
