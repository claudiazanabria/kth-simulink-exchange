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

import se.kth.md.SimulinkOOAPI.IChildrenSupport;
import se.kth.md.SimulinkOOAPI.IContainer;
import se.kth.md.SimulinkOOAPI.IGainBlock;
import se.kth.md.SimulinkOOAPI.IIdentity;
import se.kth.md.SimulinkOOAPI.IInport;
import se.kth.md.SimulinkOOAPI.ILibrary;
import se.kth.md.SimulinkOOAPI.ILine;
import se.kth.md.SimulinkOOAPI.IMask;
import se.kth.md.SimulinkOOAPI.IModel;
import se.kth.md.SimulinkOOAPI.IOutport;
import se.kth.md.SimulinkOOAPI.ISimulinkOOAPIFactory;
import se.kth.md.SimulinkOOAPI.ISimulinkOOAPIPackage;
import se.kth.md.SimulinkOOAPI.ISystem;
import se.kth.md.SimulinkOOAPI.ISystemReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SimulinkOOAPIFactory extends EFactoryImpl implements ISimulinkOOAPIFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ISimulinkOOAPIFactory init() {
		try {
			ISimulinkOOAPIFactory theSimulinkOOAPIFactory = (ISimulinkOOAPIFactory)EPackage.Registry.INSTANCE.getEFactory("http:///se.kth.md.attest3/SimulinkOOAPI/1.0"); 
			if (theSimulinkOOAPIFactory != null) {
				return theSimulinkOOAPIFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SimulinkOOAPIFactory();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimulinkOOAPIFactory() {
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
			case ISimulinkOOAPIPackage.LIBRARY: return createLibrary();
			case ISimulinkOOAPIPackage.IDENTITY: return createIdentity();
			case ISimulinkOOAPIPackage.MASK: return createMask();
			case ISimulinkOOAPIPackage.CHILDREN_SUPPORT: return createChildrenSupport();
			case ISimulinkOOAPIPackage.GAIN_BLOCK: return createGainBlock();
			case ISimulinkOOAPIPackage.INPORT: return createInport();
			case ISimulinkOOAPIPackage.OUTPORT: return createOutport();
			case ISimulinkOOAPIPackage.LINE: return createLine();
			case ISimulinkOOAPIPackage.SYSTEM: return createSystem();
			case ISimulinkOOAPIPackage.MODEL: return createModel();
			case ISimulinkOOAPIPackage.SYSTEM_REFERENCE: return createSystemReference();
			case ISimulinkOOAPIPackage.CONTAINER: return createContainer();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ILibrary createLibrary() {
		Library library = new Library();
		return library;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IIdentity createIdentity() {
		Identity identity = new Identity();
		return identity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IMask createMask() {
		Mask mask = new Mask();
		return mask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IChildrenSupport createChildrenSupport() {
		ChildrenSupport childrenSupport = new ChildrenSupport();
		return childrenSupport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IGainBlock createGainBlock() {
		GainBlock gainBlock = new GainBlock();
		return gainBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IInport createInport() {
		Inport inport = new Inport();
		return inport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IOutport createOutport() {
		Outport outport = new Outport();
		return outport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ILine createLine() {
		Line line = new Line();
		return line;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ISystem createSystem() {
		System system = new System();
		return system;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IModel createModel() {
		Model model = new Model();
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ISystemReference createSystemReference() {
		SystemReference systemReference = new SystemReference();
		return systemReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IContainer createContainer() {
		se.kth.md.SimulinkOOAPI.impl.Container container = new se.kth.md.SimulinkOOAPI.impl.Container();
		return container;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ISimulinkOOAPIPackage getSimulinkOOAPIPackage() {
		return (ISimulinkOOAPIPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ISimulinkOOAPIPackage getPackage() {
		return ISimulinkOOAPIPackage.eINSTANCE;
	}

} //SimulinkOOAPIFactory
