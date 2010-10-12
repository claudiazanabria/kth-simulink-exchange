/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package SimulinkOOOAPI;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see SimulinkOOOAPI.SimulinkOOOAPIFactory
 * @model kind="package"
 * @generated
 */
public interface SimulinkOOOAPIPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "SimulinkOOOAPI";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///se.kth.md.attest3/SimulinkOOAPI/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "simoo";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SimulinkOOOAPIPackage eINSTANCE = SimulinkOOOAPI.impl.SimulinkOOOAPIPackageImpl.init();

	/**
	 * The meta object id for the '{@link SimulinkOOOAPI.impl.ProtoObjectImpl <em>Proto Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SimulinkOOOAPI.impl.ProtoObjectImpl
	 * @see SimulinkOOOAPI.impl.SimulinkOOOAPIPackageImpl#getProtoObject()
	 * @generated
	 */
	int PROTO_OBJECT = 0;

	/**
	 * The feature id for the '<em><b>Identity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTO_OBJECT__IDENTITY = EcorePackage.EOBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Proto Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTO_OBJECT_FEATURE_COUNT = EcorePackage.EOBJECT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link SimulinkOOOAPI.impl.LibraryImpl <em>Library</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SimulinkOOOAPI.impl.LibraryImpl
	 * @see SimulinkOOOAPI.impl.SimulinkOOOAPIPackageImpl#getLibrary()
	 * @generated
	 */
	int LIBRARY = 1;

	/**
	 * The feature id for the '<em><b>Identity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__IDENTITY = PROTO_OBJECT__IDENTITY;

	/**
	 * The number of structural features of the '<em>Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_FEATURE_COUNT = PROTO_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link SimulinkOOOAPI.impl.IdentityImpl <em>Identity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SimulinkOOOAPI.impl.IdentityImpl
	 * @see SimulinkOOOAPI.impl.SimulinkOOOAPIPackageImpl#getIdentity()
	 * @generated
	 */
	int IDENTITY = 2;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTITY__UUID = EcorePackage.EOBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Identity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTITY_FEATURE_COUNT = EcorePackage.EOBJECT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link SimulinkOOOAPI.impl.MaskImpl <em>Mask</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SimulinkOOOAPI.impl.MaskImpl
	 * @see SimulinkOOOAPI.impl.SimulinkOOOAPIPackageImpl#getMask()
	 * @generated
	 */
	int MASK = 3;

	/**
	 * The number of structural features of the '<em>Mask</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MASK_FEATURE_COUNT = EcorePackage.EOBJECT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link SimulinkOOOAPI.impl.ChildrenSupportImpl <em>Children Support</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SimulinkOOOAPI.impl.ChildrenSupportImpl
	 * @see SimulinkOOOAPI.impl.SimulinkOOOAPIPackageImpl#getChildrenSupport()
	 * @generated
	 */
	int CHILDREN_SUPPORT = 4;

	/**
	 * The number of structural features of the '<em>Children Support</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILDREN_SUPPORT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link SimulinkOOOAPI.impl.GainBlockImpl <em>Gain Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SimulinkOOOAPI.impl.GainBlockImpl
	 * @see SimulinkOOOAPI.impl.SimulinkOOOAPIPackageImpl#getGainBlock()
	 * @generated
	 */
	int GAIN_BLOCK = 5;

	/**
	 * The feature id for the '<em><b>Identity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAIN_BLOCK__IDENTITY = PROTO_OBJECT__IDENTITY;

	/**
	 * The feature id for the '<em><b>Gain</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAIN_BLOCK__GAIN = PROTO_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Gain Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAIN_BLOCK_FEATURE_COUNT = PROTO_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link SimulinkOOOAPI.impl.PortImpl <em>Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SimulinkOOOAPI.impl.PortImpl
	 * @see SimulinkOOOAPI.impl.SimulinkOOOAPIPackageImpl#getPort()
	 * @generated
	 */
	int PORT = 6;

	/**
	 * The feature id for the '<em><b>Identity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__IDENTITY = PROTO_OBJECT__IDENTITY;

	/**
	 * The number of structural features of the '<em>Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_FEATURE_COUNT = PROTO_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link SimulinkOOOAPI.impl.LineImpl <em>Line</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SimulinkOOOAPI.impl.LineImpl
	 * @see SimulinkOOOAPI.impl.SimulinkOOOAPIPackageImpl#getLine()
	 * @generated
	 */
	int LINE = 7;

	/**
	 * The feature id for the '<em><b>Identity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE__IDENTITY = PROTO_OBJECT__IDENTITY;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE__SOURCE = PROTO_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE__DESTINATION = PROTO_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Line</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_FEATURE_COUNT = PROTO_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link SimulinkOOOAPI.impl.SystemImpl <em>System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SimulinkOOOAPI.impl.SystemImpl
	 * @see SimulinkOOOAPI.impl.SimulinkOOOAPIPackageImpl#getSystem()
	 * @generated
	 */
	int SYSTEM = 8;

	/**
	 * The feature id for the '<em><b>Identity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__IDENTITY = PROTO_OBJECT__IDENTITY;

	/**
	 * The feature id for the '<em><b>Children</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__CHILDREN = PROTO_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_FEATURE_COUNT = PROTO_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link SimulinkOOOAPI.impl.ModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SimulinkOOOAPI.impl.ModelImpl
	 * @see SimulinkOOOAPI.impl.SimulinkOOOAPIPackageImpl#getModel()
	 * @generated
	 */
	int MODEL = 9;

	/**
	 * The feature id for the '<em><b>Identity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__IDENTITY = PROTO_OBJECT__IDENTITY;

	/**
	 * The feature id for the '<em><b>Children</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__CHILDREN = PROTO_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_FEATURE_COUNT = PROTO_OBJECT_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link SimulinkOOOAPI.ProtoObject <em>Proto Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Proto Object</em>'.
	 * @see SimulinkOOOAPI.ProtoObject
	 * @generated
	 */
	EClass getProtoObject();

	/**
	 * Returns the meta object for the reference '{@link SimulinkOOOAPI.ProtoObject#getIdentity <em>Identity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Identity</em>'.
	 * @see SimulinkOOOAPI.ProtoObject#getIdentity()
	 * @see #getProtoObject()
	 * @generated
	 */
	EReference getProtoObject_Identity();

	/**
	 * Returns the meta object for class '{@link SimulinkOOOAPI.Library <em>Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Library</em>'.
	 * @see SimulinkOOOAPI.Library
	 * @generated
	 */
	EClass getLibrary();

	/**
	 * Returns the meta object for class '{@link SimulinkOOOAPI.Identity <em>Identity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Identity</em>'.
	 * @see SimulinkOOOAPI.Identity
	 * @generated
	 */
	EClass getIdentity();

	/**
	 * Returns the meta object for the attribute '{@link SimulinkOOOAPI.Identity#getUuid <em>Uuid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uuid</em>'.
	 * @see SimulinkOOOAPI.Identity#getUuid()
	 * @see #getIdentity()
	 * @generated
	 */
	EAttribute getIdentity_Uuid();

	/**
	 * Returns the meta object for class '{@link SimulinkOOOAPI.Mask <em>Mask</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mask</em>'.
	 * @see SimulinkOOOAPI.Mask
	 * @generated
	 */
	EClass getMask();

	/**
	 * Returns the meta object for class '{@link SimulinkOOOAPI.ChildrenSupport <em>Children Support</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Children Support</em>'.
	 * @see SimulinkOOOAPI.ChildrenSupport
	 * @generated
	 */
	EClass getChildrenSupport();

	/**
	 * Returns the meta object for class '{@link SimulinkOOOAPI.GainBlock <em>Gain Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gain Block</em>'.
	 * @see SimulinkOOOAPI.GainBlock
	 * @generated
	 */
	EClass getGainBlock();

	/**
	 * Returns the meta object for the attribute '{@link SimulinkOOOAPI.GainBlock#getGain <em>Gain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Gain</em>'.
	 * @see SimulinkOOOAPI.GainBlock#getGain()
	 * @see #getGainBlock()
	 * @generated
	 */
	EAttribute getGainBlock_Gain();

	/**
	 * Returns the meta object for class '{@link SimulinkOOOAPI.Port <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port</em>'.
	 * @see SimulinkOOOAPI.Port
	 * @generated
	 */
	EClass getPort();

	/**
	 * Returns the meta object for class '{@link SimulinkOOOAPI.Line <em>Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Line</em>'.
	 * @see SimulinkOOOAPI.Line
	 * @generated
	 */
	EClass getLine();

	/**
	 * Returns the meta object for the reference '{@link SimulinkOOOAPI.Line#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see SimulinkOOOAPI.Line#getSource()
	 * @see #getLine()
	 * @generated
	 */
	EReference getLine_Source();

	/**
	 * Returns the meta object for the reference '{@link SimulinkOOOAPI.Line#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Destination</em>'.
	 * @see SimulinkOOOAPI.Line#getDestination()
	 * @see #getLine()
	 * @generated
	 */
	EReference getLine_Destination();

	/**
	 * Returns the meta object for class '{@link SimulinkOOOAPI.System <em>System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System</em>'.
	 * @see SimulinkOOOAPI.System
	 * @generated
	 */
	EClass getSystem();

	/**
	 * Returns the meta object for the reference '{@link SimulinkOOOAPI.System#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Children</em>'.
	 * @see SimulinkOOOAPI.System#getChildren()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_Children();

	/**
	 * Returns the meta object for class '{@link SimulinkOOOAPI.Model <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see SimulinkOOOAPI.Model
	 * @generated
	 */
	EClass getModel();

	/**
	 * Returns the meta object for the reference '{@link SimulinkOOOAPI.Model#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Children</em>'.
	 * @see SimulinkOOOAPI.Model#getChildren()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_Children();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SimulinkOOOAPIFactory getSimulinkOOOAPIFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link SimulinkOOOAPI.impl.ProtoObjectImpl <em>Proto Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SimulinkOOOAPI.impl.ProtoObjectImpl
		 * @see SimulinkOOOAPI.impl.SimulinkOOOAPIPackageImpl#getProtoObject()
		 * @generated
		 */
		EClass PROTO_OBJECT = eINSTANCE.getProtoObject();

		/**
		 * The meta object literal for the '<em><b>Identity</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROTO_OBJECT__IDENTITY = eINSTANCE.getProtoObject_Identity();

		/**
		 * The meta object literal for the '{@link SimulinkOOOAPI.impl.LibraryImpl <em>Library</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SimulinkOOOAPI.impl.LibraryImpl
		 * @see SimulinkOOOAPI.impl.SimulinkOOOAPIPackageImpl#getLibrary()
		 * @generated
		 */
		EClass LIBRARY = eINSTANCE.getLibrary();

		/**
		 * The meta object literal for the '{@link SimulinkOOOAPI.impl.IdentityImpl <em>Identity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SimulinkOOOAPI.impl.IdentityImpl
		 * @see SimulinkOOOAPI.impl.SimulinkOOOAPIPackageImpl#getIdentity()
		 * @generated
		 */
		EClass IDENTITY = eINSTANCE.getIdentity();

		/**
		 * The meta object literal for the '<em><b>Uuid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IDENTITY__UUID = eINSTANCE.getIdentity_Uuid();

		/**
		 * The meta object literal for the '{@link SimulinkOOOAPI.impl.MaskImpl <em>Mask</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SimulinkOOOAPI.impl.MaskImpl
		 * @see SimulinkOOOAPI.impl.SimulinkOOOAPIPackageImpl#getMask()
		 * @generated
		 */
		EClass MASK = eINSTANCE.getMask();

		/**
		 * The meta object literal for the '{@link SimulinkOOOAPI.impl.ChildrenSupportImpl <em>Children Support</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SimulinkOOOAPI.impl.ChildrenSupportImpl
		 * @see SimulinkOOOAPI.impl.SimulinkOOOAPIPackageImpl#getChildrenSupport()
		 * @generated
		 */
		EClass CHILDREN_SUPPORT = eINSTANCE.getChildrenSupport();

		/**
		 * The meta object literal for the '{@link SimulinkOOOAPI.impl.GainBlockImpl <em>Gain Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SimulinkOOOAPI.impl.GainBlockImpl
		 * @see SimulinkOOOAPI.impl.SimulinkOOOAPIPackageImpl#getGainBlock()
		 * @generated
		 */
		EClass GAIN_BLOCK = eINSTANCE.getGainBlock();

		/**
		 * The meta object literal for the '<em><b>Gain</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GAIN_BLOCK__GAIN = eINSTANCE.getGainBlock_Gain();

		/**
		 * The meta object literal for the '{@link SimulinkOOOAPI.impl.PortImpl <em>Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SimulinkOOOAPI.impl.PortImpl
		 * @see SimulinkOOOAPI.impl.SimulinkOOOAPIPackageImpl#getPort()
		 * @generated
		 */
		EClass PORT = eINSTANCE.getPort();

		/**
		 * The meta object literal for the '{@link SimulinkOOOAPI.impl.LineImpl <em>Line</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SimulinkOOOAPI.impl.LineImpl
		 * @see SimulinkOOOAPI.impl.SimulinkOOOAPIPackageImpl#getLine()
		 * @generated
		 */
		EClass LINE = eINSTANCE.getLine();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINE__SOURCE = eINSTANCE.getLine_Source();

		/**
		 * The meta object literal for the '<em><b>Destination</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINE__DESTINATION = eINSTANCE.getLine_Destination();

		/**
		 * The meta object literal for the '{@link SimulinkOOOAPI.impl.SystemImpl <em>System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SimulinkOOOAPI.impl.SystemImpl
		 * @see SimulinkOOOAPI.impl.SimulinkOOOAPIPackageImpl#getSystem()
		 * @generated
		 */
		EClass SYSTEM = eINSTANCE.getSystem();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__CHILDREN = eINSTANCE.getSystem_Children();

		/**
		 * The meta object literal for the '{@link SimulinkOOOAPI.impl.ModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SimulinkOOOAPI.impl.ModelImpl
		 * @see SimulinkOOOAPI.impl.SimulinkOOOAPIPackageImpl#getModel()
		 * @generated
		 */
		EClass MODEL = eINSTANCE.getModel();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__CHILDREN = eINSTANCE.getModel_Children();

	}

} //SimulinkOOOAPIPackage
