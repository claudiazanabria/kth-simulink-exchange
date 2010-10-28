/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package SimulinkOOAPI;

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
 * @see SimulinkOOAPI.SimulinkOOAPIFactory
 * @model kind="package"
 * @generated
 */
public interface SimulinkOOAPIPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "SimulinkOOAPI";

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
	SimulinkOOAPIPackage eINSTANCE = SimulinkOOAPI.impl.SimulinkOOAPIPackageImpl.init();

	/**
	 * The meta object id for the '{@link SimulinkOOAPI.impl.ProtoObjectImpl <em>Proto Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SimulinkOOAPI.impl.ProtoObjectImpl
	 * @see SimulinkOOAPI.impl.SimulinkOOAPIPackageImpl#getProtoObject()
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
	 * The meta object id for the '{@link SimulinkOOAPI.impl.LibraryImpl <em>Library</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SimulinkOOAPI.impl.LibraryImpl
	 * @see SimulinkOOAPI.impl.SimulinkOOAPIPackageImpl#getLibrary()
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
	 * The feature id for the '<em><b>Children</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__CHILDREN = PROTO_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_FEATURE_COUNT = PROTO_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link SimulinkOOAPI.impl.IdentityImpl <em>Identity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SimulinkOOAPI.impl.IdentityImpl
	 * @see SimulinkOOAPI.impl.SimulinkOOAPIPackageImpl#getIdentity()
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
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTITY__NAME = EcorePackage.EOBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Identity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTITY_FEATURE_COUNT = EcorePackage.EOBJECT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link SimulinkOOAPI.impl.MaskImpl <em>Mask</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SimulinkOOAPI.impl.MaskImpl
	 * @see SimulinkOOAPI.impl.SimulinkOOAPIPackageImpl#getMask()
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
	 * The meta object id for the '{@link SimulinkOOAPI.impl.ChildrenSupportImpl <em>Children Support</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SimulinkOOAPI.impl.ChildrenSupportImpl
	 * @see SimulinkOOAPI.impl.SimulinkOOAPIPackageImpl#getChildrenSupport()
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
	 * The meta object id for the '{@link SimulinkOOAPI.impl.GainBlockImpl <em>Gain Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SimulinkOOAPI.impl.GainBlockImpl
	 * @see SimulinkOOAPI.impl.SimulinkOOAPIPackageImpl#getGainBlock()
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
	 * The meta object id for the '{@link SimulinkOOAPI.impl.PortImpl <em>Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SimulinkOOAPI.impl.PortImpl
	 * @see SimulinkOOAPI.impl.SimulinkOOAPIPackageImpl#getPort()
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
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__PARENT = PROTO_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_FEATURE_COUNT = PROTO_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link SimulinkOOAPI.impl.InportImpl <em>Inport</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SimulinkOOAPI.impl.InportImpl
	 * @see SimulinkOOAPI.impl.SimulinkOOAPIPackageImpl#getInport()
	 * @generated
	 */
	int INPORT = 7;

	/**
	 * The feature id for the '<em><b>Identity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPORT__IDENTITY = PORT__IDENTITY;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPORT__PARENT = PORT__PARENT;

	/**
	 * The number of structural features of the '<em>Inport</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPORT_FEATURE_COUNT = PORT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link SimulinkOOAPI.impl.OutportImpl <em>Outport</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SimulinkOOAPI.impl.OutportImpl
	 * @see SimulinkOOAPI.impl.SimulinkOOAPIPackageImpl#getOutport()
	 * @generated
	 */
	int OUTPORT = 8;

	/**
	 * The feature id for the '<em><b>Identity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPORT__IDENTITY = PORT__IDENTITY;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPORT__PARENT = PORT__PARENT;

	/**
	 * The number of structural features of the '<em>Outport</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPORT_FEATURE_COUNT = PORT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link SimulinkOOAPI.impl.LineImpl <em>Line</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SimulinkOOAPI.impl.LineImpl
	 * @see SimulinkOOAPI.impl.SimulinkOOAPIPackageImpl#getLine()
	 * @generated
	 */
	int LINE = 9;

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
	 * The meta object id for the '{@link SimulinkOOAPI.impl.SystemImpl <em>System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SimulinkOOAPI.impl.SystemImpl
	 * @see SimulinkOOAPI.impl.SimulinkOOAPIPackageImpl#getSystem()
	 * @generated
	 */
	int SYSTEM = 10;

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
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__PARENT = PROTO_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_FEATURE_COUNT = PROTO_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link SimulinkOOAPI.impl.ModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SimulinkOOAPI.impl.ModelImpl
	 * @see SimulinkOOAPI.impl.SimulinkOOAPIPackageImpl#getModel()
	 * @generated
	 */
	int MODEL = 11;

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
	 * The meta object id for the '{@link SimulinkOOAPI.impl.SystemReferenceImpl <em>System Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SimulinkOOAPI.impl.SystemReferenceImpl
	 * @see SimulinkOOAPI.impl.SimulinkOOAPIPackageImpl#getSystemReference()
	 * @generated
	 */
	int SYSTEM_REFERENCE = 12;

	/**
	 * The feature id for the '<em><b>Identity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_REFERENCE__IDENTITY = PROTO_OBJECT__IDENTITY;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_REFERENCE__TARGET = PROTO_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>System Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_REFERENCE_FEATURE_COUNT = PROTO_OBJECT_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link SimulinkOOAPI.ProtoObject <em>Proto Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Proto Object</em>'.
	 * @see SimulinkOOAPI.ProtoObject
	 * @generated
	 */
	EClass getProtoObject();

	/**
	 * Returns the meta object for the reference '{@link SimulinkOOAPI.ProtoObject#getIdentity <em>Identity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Identity</em>'.
	 * @see SimulinkOOAPI.ProtoObject#getIdentity()
	 * @see #getProtoObject()
	 * @generated
	 */
	EReference getProtoObject_Identity();

	/**
	 * Returns the meta object for class '{@link SimulinkOOAPI.Library <em>Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Library</em>'.
	 * @see SimulinkOOAPI.Library
	 * @generated
	 */
	EClass getLibrary();

	/**
	 * Returns the meta object for the reference '{@link SimulinkOOAPI.Library#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Children</em>'.
	 * @see SimulinkOOAPI.Library#getChildren()
	 * @see #getLibrary()
	 * @generated
	 */
	EReference getLibrary_Children();

	/**
	 * Returns the meta object for class '{@link SimulinkOOAPI.Identity <em>Identity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Identity</em>'.
	 * @see SimulinkOOAPI.Identity
	 * @generated
	 */
	EClass getIdentity();

	/**
	 * Returns the meta object for the attribute '{@link SimulinkOOAPI.Identity#getUuid <em>Uuid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uuid</em>'.
	 * @see SimulinkOOAPI.Identity#getUuid()
	 * @see #getIdentity()
	 * @generated
	 */
	EAttribute getIdentity_Uuid();

	/**
	 * Returns the meta object for the attribute '{@link SimulinkOOAPI.Identity#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see SimulinkOOAPI.Identity#getName()
	 * @see #getIdentity()
	 * @generated
	 */
	EAttribute getIdentity_Name();

	/**
	 * Returns the meta object for class '{@link SimulinkOOAPI.Mask <em>Mask</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mask</em>'.
	 * @see SimulinkOOAPI.Mask
	 * @generated
	 */
	EClass getMask();

	/**
	 * Returns the meta object for class '{@link SimulinkOOAPI.ChildrenSupport <em>Children Support</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Children Support</em>'.
	 * @see SimulinkOOAPI.ChildrenSupport
	 * @generated
	 */
	EClass getChildrenSupport();

	/**
	 * Returns the meta object for class '{@link SimulinkOOAPI.GainBlock <em>Gain Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gain Block</em>'.
	 * @see SimulinkOOAPI.GainBlock
	 * @generated
	 */
	EClass getGainBlock();

	/**
	 * Returns the meta object for the attribute '{@link SimulinkOOAPI.GainBlock#getGain <em>Gain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Gain</em>'.
	 * @see SimulinkOOAPI.GainBlock#getGain()
	 * @see #getGainBlock()
	 * @generated
	 */
	EAttribute getGainBlock_Gain();

	/**
	 * Returns the meta object for class '{@link SimulinkOOAPI.Port <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port</em>'.
	 * @see SimulinkOOAPI.Port
	 * @generated
	 */
	EClass getPort();

	/**
	 * Returns the meta object for the reference '{@link SimulinkOOAPI.Port#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent</em>'.
	 * @see SimulinkOOAPI.Port#getParent()
	 * @see #getPort()
	 * @generated
	 */
	EReference getPort_Parent();

	/**
	 * Returns the meta object for class '{@link SimulinkOOAPI.Inport <em>Inport</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inport</em>'.
	 * @see SimulinkOOAPI.Inport
	 * @generated
	 */
	EClass getInport();

	/**
	 * Returns the meta object for class '{@link SimulinkOOAPI.Outport <em>Outport</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Outport</em>'.
	 * @see SimulinkOOAPI.Outport
	 * @generated
	 */
	EClass getOutport();

	/**
	 * Returns the meta object for class '{@link SimulinkOOAPI.Line <em>Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Line</em>'.
	 * @see SimulinkOOAPI.Line
	 * @generated
	 */
	EClass getLine();

	/**
	 * Returns the meta object for the reference '{@link SimulinkOOAPI.Line#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see SimulinkOOAPI.Line#getSource()
	 * @see #getLine()
	 * @generated
	 */
	EReference getLine_Source();

	/**
	 * Returns the meta object for the reference '{@link SimulinkOOAPI.Line#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Destination</em>'.
	 * @see SimulinkOOAPI.Line#getDestination()
	 * @see #getLine()
	 * @generated
	 */
	EReference getLine_Destination();

	/**
	 * Returns the meta object for class '{@link SimulinkOOAPI.System <em>System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System</em>'.
	 * @see SimulinkOOAPI.System
	 * @generated
	 */
	EClass getSystem();

	/**
	 * Returns the meta object for the reference '{@link SimulinkOOAPI.System#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Children</em>'.
	 * @see SimulinkOOAPI.System#getChildren()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_Children();

	/**
	 * Returns the meta object for the reference '{@link SimulinkOOAPI.System#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent</em>'.
	 * @see SimulinkOOAPI.System#getParent()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_Parent();

	/**
	 * Returns the meta object for class '{@link SimulinkOOAPI.Model <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see SimulinkOOAPI.Model
	 * @generated
	 */
	EClass getModel();

	/**
	 * Returns the meta object for the reference '{@link SimulinkOOAPI.Model#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Children</em>'.
	 * @see SimulinkOOAPI.Model#getChildren()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_Children();

	/**
	 * Returns the meta object for class '{@link SimulinkOOAPI.SystemReference <em>System Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System Reference</em>'.
	 * @see SimulinkOOAPI.SystemReference
	 * @generated
	 */
	EClass getSystemReference();

	/**
	 * Returns the meta object for the reference '{@link SimulinkOOAPI.SystemReference#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see SimulinkOOAPI.SystemReference#getTarget()
	 * @see #getSystemReference()
	 * @generated
	 */
	EReference getSystemReference_Target();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SimulinkOOAPIFactory getSimulinkOOAPIFactory();

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
		 * The meta object literal for the '{@link SimulinkOOAPI.impl.ProtoObjectImpl <em>Proto Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SimulinkOOAPI.impl.ProtoObjectImpl
		 * @see SimulinkOOAPI.impl.SimulinkOOAPIPackageImpl#getProtoObject()
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
		 * The meta object literal for the '{@link SimulinkOOAPI.impl.LibraryImpl <em>Library</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SimulinkOOAPI.impl.LibraryImpl
		 * @see SimulinkOOAPI.impl.SimulinkOOAPIPackageImpl#getLibrary()
		 * @generated
		 */
		EClass LIBRARY = eINSTANCE.getLibrary();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIBRARY__CHILDREN = eINSTANCE.getLibrary_Children();

		/**
		 * The meta object literal for the '{@link SimulinkOOAPI.impl.IdentityImpl <em>Identity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SimulinkOOAPI.impl.IdentityImpl
		 * @see SimulinkOOAPI.impl.SimulinkOOAPIPackageImpl#getIdentity()
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
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IDENTITY__NAME = eINSTANCE.getIdentity_Name();

		/**
		 * The meta object literal for the '{@link SimulinkOOAPI.impl.MaskImpl <em>Mask</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SimulinkOOAPI.impl.MaskImpl
		 * @see SimulinkOOAPI.impl.SimulinkOOAPIPackageImpl#getMask()
		 * @generated
		 */
		EClass MASK = eINSTANCE.getMask();

		/**
		 * The meta object literal for the '{@link SimulinkOOAPI.impl.ChildrenSupportImpl <em>Children Support</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SimulinkOOAPI.impl.ChildrenSupportImpl
		 * @see SimulinkOOAPI.impl.SimulinkOOAPIPackageImpl#getChildrenSupport()
		 * @generated
		 */
		EClass CHILDREN_SUPPORT = eINSTANCE.getChildrenSupport();

		/**
		 * The meta object literal for the '{@link SimulinkOOAPI.impl.GainBlockImpl <em>Gain Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SimulinkOOAPI.impl.GainBlockImpl
		 * @see SimulinkOOAPI.impl.SimulinkOOAPIPackageImpl#getGainBlock()
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
		 * The meta object literal for the '{@link SimulinkOOAPI.impl.PortImpl <em>Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SimulinkOOAPI.impl.PortImpl
		 * @see SimulinkOOAPI.impl.SimulinkOOAPIPackageImpl#getPort()
		 * @generated
		 */
		EClass PORT = eINSTANCE.getPort();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT__PARENT = eINSTANCE.getPort_Parent();

		/**
		 * The meta object literal for the '{@link SimulinkOOAPI.impl.InportImpl <em>Inport</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SimulinkOOAPI.impl.InportImpl
		 * @see SimulinkOOAPI.impl.SimulinkOOAPIPackageImpl#getInport()
		 * @generated
		 */
		EClass INPORT = eINSTANCE.getInport();

		/**
		 * The meta object literal for the '{@link SimulinkOOAPI.impl.OutportImpl <em>Outport</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SimulinkOOAPI.impl.OutportImpl
		 * @see SimulinkOOAPI.impl.SimulinkOOAPIPackageImpl#getOutport()
		 * @generated
		 */
		EClass OUTPORT = eINSTANCE.getOutport();

		/**
		 * The meta object literal for the '{@link SimulinkOOAPI.impl.LineImpl <em>Line</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SimulinkOOAPI.impl.LineImpl
		 * @see SimulinkOOAPI.impl.SimulinkOOAPIPackageImpl#getLine()
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
		 * The meta object literal for the '{@link SimulinkOOAPI.impl.SystemImpl <em>System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SimulinkOOAPI.impl.SystemImpl
		 * @see SimulinkOOAPI.impl.SimulinkOOAPIPackageImpl#getSystem()
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
		 * The meta object literal for the '<em><b>Parent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__PARENT = eINSTANCE.getSystem_Parent();

		/**
		 * The meta object literal for the '{@link SimulinkOOAPI.impl.ModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SimulinkOOAPI.impl.ModelImpl
		 * @see SimulinkOOAPI.impl.SimulinkOOAPIPackageImpl#getModel()
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

		/**
		 * The meta object literal for the '{@link SimulinkOOAPI.impl.SystemReferenceImpl <em>System Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SimulinkOOAPI.impl.SystemReferenceImpl
		 * @see SimulinkOOAPI.impl.SimulinkOOAPIPackageImpl#getSystemReference()
		 * @generated
		 */
		EClass SYSTEM_REFERENCE = eINSTANCE.getSystemReference();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_REFERENCE__TARGET = eINSTANCE.getSystemReference_Target();

	}

} //SimulinkOOAPIPackage
