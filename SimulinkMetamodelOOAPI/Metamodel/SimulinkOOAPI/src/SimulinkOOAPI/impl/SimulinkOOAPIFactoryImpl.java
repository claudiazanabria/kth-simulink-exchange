/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package SimulinkOOAPI.impl;

import SimulinkOOAPI.ChildrenSupport;
import SimulinkOOAPI.GainBlock;
import SimulinkOOAPI.Identity;
import SimulinkOOAPI.Library;
import SimulinkOOAPI.Line;
import SimulinkOOAPI.Mask;
import SimulinkOOAPI.Model;
import SimulinkOOAPI.Port;
import SimulinkOOAPI.SimulinkOOAPIFactory;
import SimulinkOOAPI.SimulinkOOAPIPackage;

import SimulinkOOAPI.SystemReference;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

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
		//TODO: FIX_ME - provide parameters for constructors
		switch (eClass.getClassifierID()) {
			case SimulinkOOAPIPackage.LIBRARY: return createLibrary();
			case SimulinkOOAPIPackage.IDENTITY: return createIdentity();
			case SimulinkOOAPIPackage.MASK: return createMask();
			case SimulinkOOAPIPackage.CHILDREN_SUPPORT: return createChildrenSupport();
			case SimulinkOOAPIPackage.GAIN_BLOCK: return createGainBlock(0);
			case SimulinkOOAPIPackage.PORT: return createPort();
			//case SimulinkOOAPIPackage.LINE: return createLine();
			case SimulinkOOAPIPackage.SYSTEM: return createSystem();
			case SimulinkOOAPIPackage.MODEL: return createModel();
			//case SimulinkOOAPIPackage.SYSTEM_REFERENCE: return createSystemReference();
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
	public ChildrenSupport createChildrenSupport() {
		ChildrenSupportImpl childrenSupport = new ChildrenSupportImpl();
		return childrenSupport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public GainBlock createGainBlock(int gain) {
		GainBlockImpl gainBlock = new GainBlockImpl(createIdentity(), gain);
		return gainBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Port createPort() {
		PortImpl port = new PortImpl(createIdentity());
		return port;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Line createLine(Port source, Port destination) {
		LineImpl line = new LineImpl(createIdentity(), source, destination);
		return line;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public SimulinkOOAPI.System createSystem() {
		SystemImpl system = new SystemImpl(createIdentity());
		return system;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Model createModel() {
		ModelImpl model = new ModelImpl(createIdentity());
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemReference createSystemReference(SimulinkOOAPI.System target) {
		SystemReferenceImpl systemReference = new SystemReferenceImpl(createIdentity(), target);
		return systemReference;
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

} //SimulinkOOAPIFactoryImpl
