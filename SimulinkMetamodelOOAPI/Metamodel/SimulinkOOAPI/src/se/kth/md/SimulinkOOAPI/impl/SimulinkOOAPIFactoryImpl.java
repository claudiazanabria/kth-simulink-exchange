/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package se.kth.md.SimulinkOOAPI.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import se.kth.md.SimulinkOOAPI.ChildrenSupport;
import se.kth.md.SimulinkOOAPI.Container;
import se.kth.md.SimulinkOOAPI.GainBlock;
import se.kth.md.SimulinkOOAPI.Identity;
import se.kth.md.SimulinkOOAPI.Inport;
import se.kth.md.SimulinkOOAPI.Library;
import se.kth.md.SimulinkOOAPI.Line;
import se.kth.md.SimulinkOOAPI.Mask;
import se.kth.md.SimulinkOOAPI.Model;
import se.kth.md.SimulinkOOAPI.Outport;
import se.kth.md.SimulinkOOAPI.SimulinkOOAPIFactory;
import se.kth.md.SimulinkOOAPI.SimulinkOOAPIPackage;
import se.kth.md.SimulinkOOAPI.System;
import se.kth.md.SimulinkOOAPI.SystemReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SimulinkOOAPIFactoryImpl extends EFactoryImpl implements SimulinkOOAPIFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SimulinkOOAPIFactory init() {
		try {
			SimulinkOOAPIFactory theSimulinkOOAPIFactory = (SimulinkOOAPIFactory)EPackage.Registry.INSTANCE.getEFactory("http:///se.kth.md.attest3/SimulinkOOAPI/1.0"); 
			if (theSimulinkOOAPIFactory != null) {
				return theSimulinkOOAPIFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SimulinkOOAPIFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimulinkOOAPIFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case SimulinkOOAPIPackage.LIBRARY: return createLibrary();
			case SimulinkOOAPIPackage.IDENTITY: return createIdentity();
			case SimulinkOOAPIPackage.MASK: return createMask();
			case SimulinkOOAPIPackage.GAIN_BLOCK: return createGainBlock();
			case SimulinkOOAPIPackage.INPORT: return createInport();
			case SimulinkOOAPIPackage.OUTPORT: return createOutport();
			case SimulinkOOAPIPackage.LINE: return createLine();
			case SimulinkOOAPIPackage.SYSTEM: return createSystem();
			case SimulinkOOAPIPackage.MODEL: return createModel();
			case SimulinkOOAPIPackage.SYSTEM_REFERENCE: return createSystemReference();
			case SimulinkOOAPIPackage.CONTAINER: return createContainer();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Library createLibrary() {
		LibraryImpl library = new LibraryImpl();
		return library;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Identity createIdentity() {
		IdentityImpl identity = new IdentityImpl();
		return identity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mask createMask() {
		MaskImpl mask = new MaskImpl();
		return mask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GainBlock createGainBlock() {
		GainBlockImpl gainBlock = new GainBlockImpl();
		return gainBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Inport createInport() {
		InportImpl inport = new InportImpl();
		return inport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Outport createOutport() {
		OutportImpl outport = new OutportImpl();
		return outport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Line createLine() {
		LineImpl line = new LineImpl();
		return line;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public se.kth.md.SimulinkOOAPI.System createSystem() {
		SystemImpl system = new SystemImpl();
		return system;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Model createModel() {
		ModelImpl model = new ModelImpl();
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemReference createSystemReference() {
		SystemReferenceImpl systemReference = new SystemReferenceImpl();
		return systemReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public se.kth.md.SimulinkOOAPI.Container createContainer() {
		ContainerImpl container = new ContainerImpl();
		return container;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimulinkOOAPIPackage getSimulinkOOAPIPackage() {
		return (SimulinkOOAPIPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SimulinkOOAPIPackage getPackage() {
		return SimulinkOOAPIPackage.eINSTANCE;
	}

} //SimulinkOOAPIFactory
