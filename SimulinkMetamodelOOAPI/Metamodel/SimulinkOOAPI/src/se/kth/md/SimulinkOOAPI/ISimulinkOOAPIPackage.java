/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package se.kth.md.SimulinkOOAPI;

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
 * @see se.kth.md.SimulinkOOAPI.ISimulinkOOAPIFactory
 * @model kind="package"
 * @generated
 */
public interface ISimulinkOOAPIPackage extends EPackage {
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
	ISimulinkOOAPIPackage eINSTANCE = se.kth.md.SimulinkOOAPI.impl.SimulinkOOAPIPackage.init();

	/**
	 * The meta object id for the '{@link se.kth.md.SimulinkOOAPI.impl.ProtoObject <em>Proto Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see se.kth.md.SimulinkOOAPI.impl.ProtoObject
	 * @see se.kth.md.SimulinkOOAPI.impl.SimulinkOOAPIPackage#getProtoObject()
	 * @generated
	 */
	int PROTO_OBJECT = 0;

	/**
	 * The feature id for the '<em><b>Identity</b></em>' containment reference.
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
	 * The meta object id for the '{@link se.kth.md.SimulinkOOAPI.impl.Container <em>Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see se.kth.md.SimulinkOOAPI.impl.Container
	 * @see se.kth.md.SimulinkOOAPI.impl.SimulinkOOAPIPackage#getContainer()
	 * @generated
	 */
	int CONTAINER = 13;

	/**
	 * The feature id for the '<em><b>Identity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER__IDENTITY = PROTO_OBJECT__IDENTITY;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER__CHILDREN = PROTO_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_FEATURE_COUNT = PROTO_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link se.kth.md.SimulinkOOAPI.impl.Library <em>Library</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see se.kth.md.SimulinkOOAPI.impl.Library
	 * @see se.kth.md.SimulinkOOAPI.impl.SimulinkOOAPIPackage#getLibrary()
	 * @generated
	 */
	int LIBRARY = 1;

	/**
	 * The feature id for the '<em><b>Identity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__IDENTITY = CONTAINER__IDENTITY;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__CHILDREN = CONTAINER__CHILDREN;

	/**
	 * The number of structural features of the '<em>Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_FEATURE_COUNT = CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link se.kth.md.SimulinkOOAPI.impl.Identity <em>Identity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see se.kth.md.SimulinkOOAPI.impl.Identity
	 * @see se.kth.md.SimulinkOOAPI.impl.SimulinkOOAPIPackage#getIdentity()
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
	 * The meta object id for the '{@link se.kth.md.SimulinkOOAPI.impl.Mask <em>Mask</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see se.kth.md.SimulinkOOAPI.impl.Mask
	 * @see se.kth.md.SimulinkOOAPI.impl.SimulinkOOAPIPackage#getMask()
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
	 * The meta object id for the '{@link se.kth.md.SimulinkOOAPI.impl.ChildrenSupport <em>Children Support</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see se.kth.md.SimulinkOOAPI.impl.ChildrenSupport
	 * @see se.kth.md.SimulinkOOAPI.impl.SimulinkOOAPIPackage#getChildrenSupport()
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
	 * The meta object id for the '{@link se.kth.md.SimulinkOOAPI.impl.GainBlock <em>Gain Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see se.kth.md.SimulinkOOAPI.impl.GainBlock
	 * @see se.kth.md.SimulinkOOAPI.impl.SimulinkOOAPIPackage#getGainBlock()
	 * @generated
	 */
	int GAIN_BLOCK = 5;

	/**
	 * The feature id for the '<em><b>Identity</b></em>' containment reference.
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
	 * The meta object id for the '{@link se.kth.md.SimulinkOOAPI.impl.Port <em>Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see se.kth.md.SimulinkOOAPI.impl.Port
	 * @see se.kth.md.SimulinkOOAPI.impl.SimulinkOOAPIPackage#getPort()
	 * @generated
	 */
	int PORT = 6;

	/**
	 * The feature id for the '<em><b>Identity</b></em>' containment reference.
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
	 * The meta object id for the '{@link se.kth.md.SimulinkOOAPI.impl.Inport <em>Inport</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see se.kth.md.SimulinkOOAPI.impl.Inport
	 * @see se.kth.md.SimulinkOOAPI.impl.SimulinkOOAPIPackage#getInport()
	 * @generated
	 */
	int INPORT = 7;

	/**
	 * The feature id for the '<em><b>Identity</b></em>' containment reference.
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
	 * The meta object id for the '{@link se.kth.md.SimulinkOOAPI.impl.Outport <em>Outport</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see se.kth.md.SimulinkOOAPI.impl.Outport
	 * @see se.kth.md.SimulinkOOAPI.impl.SimulinkOOAPIPackage#getOutport()
	 * @generated
	 */
	int OUTPORT = 8;

	/**
	 * The feature id for the '<em><b>Identity</b></em>' containment reference.
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
	 * The meta object id for the '{@link se.kth.md.SimulinkOOAPI.impl.Line <em>Line</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see se.kth.md.SimulinkOOAPI.impl.Line
	 * @see se.kth.md.SimulinkOOAPI.impl.SimulinkOOAPIPackage#getLine()
	 * @generated
	 */
	int LINE = 9;

	/**
	 * The feature id for the '<em><b>Identity</b></em>' containment reference.
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
	 * The meta object id for the '{@link se.kth.md.SimulinkOOAPI.impl.System <em>System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see se.kth.md.SimulinkOOAPI.impl.System
	 * @see se.kth.md.SimulinkOOAPI.impl.SimulinkOOAPIPackage#getSystem()
	 * @generated
	 */
	int SYSTEM = 10;

	/**
	 * The feature id for the '<em><b>Identity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__IDENTITY = CONTAINER__IDENTITY;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__CHILDREN = CONTAINER__CHILDREN;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__PARENT = CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_FEATURE_COUNT = CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link se.kth.md.SimulinkOOAPI.impl.Model <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see se.kth.md.SimulinkOOAPI.impl.Model
	 * @see se.kth.md.SimulinkOOAPI.impl.SimulinkOOAPIPackage#getModel()
	 * @generated
	 */
	int MODEL = 11;

	/**
	 * The feature id for the '<em><b>Identity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__IDENTITY = CONTAINER__IDENTITY;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__CHILDREN = CONTAINER__CHILDREN;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_FEATURE_COUNT = CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link se.kth.md.SimulinkOOAPI.impl.SystemReference <em>System Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see se.kth.md.SimulinkOOAPI.impl.SystemReference
	 * @see se.kth.md.SimulinkOOAPI.impl.SimulinkOOAPIPackage#getSystemReference()
	 * @generated
	 */
	int SYSTEM_REFERENCE = 12;

	/**
	 * The feature id for the '<em><b>Identity</b></em>' containment reference.
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
	 * Returns the meta object for class '{@link se.kth.md.SimulinkOOAPI.IProtoObject <em>Proto Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Proto Object</em>'.
	 * @see se.kth.md.SimulinkOOAPI.IProtoObject
	 * @generated
	 */
	EClass getProtoObject();

	/**
	 * Returns the meta object for the containment reference '{@link se.kth.md.SimulinkOOAPI.IProtoObject#getIdentity <em>Identity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Identity</em>'.
	 * @see se.kth.md.SimulinkOOAPI.IProtoObject#getIdentity()
	 * @see #getProtoObject()
	 * @generated
	 */
	EReference getProtoObject_Identity();

	/**
	 * Returns the meta object for class '{@link se.kth.md.SimulinkOOAPI.ILibrary <em>Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Library</em>'.
	 * @see se.kth.md.SimulinkOOAPI.ILibrary
	 * @generated
	 */
	EClass getLibrary();

	/**
	 * Returns the meta object for class '{@link se.kth.md.SimulinkOOAPI.IIdentity <em>Identity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Identity</em>'.
	 * @see se.kth.md.SimulinkOOAPI.IIdentity
	 * @generated
	 */
	EClass getIdentity();

	/**
	 * Returns the meta object for the attribute '{@link se.kth.md.SimulinkOOAPI.IIdentity#getUuid <em>Uuid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uuid</em>'.
	 * @see se.kth.md.SimulinkOOAPI.IIdentity#getUuid()
	 * @see #getIdentity()
	 * @generated
	 */
	EAttribute getIdentity_Uuid();

	/**
	 * Returns the meta object for the attribute '{@link se.kth.md.SimulinkOOAPI.IIdentity#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see se.kth.md.SimulinkOOAPI.IIdentity#getName()
	 * @see #getIdentity()
	 * @generated
	 */
	EAttribute getIdentity_Name();

	/**
	 * Returns the meta object for class '{@link se.kth.md.SimulinkOOAPI.IMask <em>Mask</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mask</em>'.
	 * @see se.kth.md.SimulinkOOAPI.IMask
	 * @generated
	 */
	EClass getMask();

	/**
	 * Returns the meta object for class '{@link se.kth.md.SimulinkOOAPI.IChildrenSupport <em>Children Support</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Children Support</em>'.
	 * @see se.kth.md.SimulinkOOAPI.IChildrenSupport
	 * @generated
	 */
	EClass getChildrenSupport();

	/**
	 * Returns the meta object for class '{@link se.kth.md.SimulinkOOAPI.IGainBlock <em>Gain Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gain Block</em>'.
	 * @see se.kth.md.SimulinkOOAPI.IGainBlock
	 * @generated
	 */
	EClass getGainBlock();

	/**
	 * Returns the meta object for the attribute '{@link se.kth.md.SimulinkOOAPI.IGainBlock#getGain <em>Gain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Gain</em>'.
	 * @see se.kth.md.SimulinkOOAPI.IGainBlock#getGain()
	 * @see #getGainBlock()
	 * @generated
	 */
	EAttribute getGainBlock_Gain();

	/**
	 * Returns the meta object for class '{@link se.kth.md.SimulinkOOAPI.IPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port</em>'.
	 * @see se.kth.md.SimulinkOOAPI.IPort
	 * @generated
	 */
	EClass getPort();

	/**
	 * Returns the meta object for the reference '{@link se.kth.md.SimulinkOOAPI.IPort#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent</em>'.
	 * @see se.kth.md.SimulinkOOAPI.IPort#getParent()
	 * @see #getPort()
	 * @generated
	 */
	EReference getPort_Parent();

	/**
	 * Returns the meta object for class '{@link se.kth.md.SimulinkOOAPI.IInport <em>Inport</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inport</em>'.
	 * @see se.kth.md.SimulinkOOAPI.IInport
	 * @generated
	 */
	EClass getInport();

	/**
	 * Returns the meta object for class '{@link se.kth.md.SimulinkOOAPI.IOutport <em>Outport</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Outport</em>'.
	 * @see se.kth.md.SimulinkOOAPI.IOutport
	 * @generated
	 */
	EClass getOutport();

	/**
	 * Returns the meta object for class '{@link se.kth.md.SimulinkOOAPI.ILine <em>Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Line</em>'.
	 * @see se.kth.md.SimulinkOOAPI.ILine
	 * @generated
	 */
	EClass getLine();

	/**
	 * Returns the meta object for the reference '{@link se.kth.md.SimulinkOOAPI.ILine#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see se.kth.md.SimulinkOOAPI.ILine#getSource()
	 * @see #getLine()
	 * @generated
	 */
	EReference getLine_Source();

	/**
	 * Returns the meta object for the reference '{@link se.kth.md.SimulinkOOAPI.ILine#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Destination</em>'.
	 * @see se.kth.md.SimulinkOOAPI.ILine#getDestination()
	 * @see #getLine()
	 * @generated
	 */
	EReference getLine_Destination();

	/**
	 * Returns the meta object for class '{@link se.kth.md.SimulinkOOAPI.ISystem <em>System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System</em>'.
	 * @see se.kth.md.SimulinkOOAPI.ISystem
	 * @generated
	 */
	EClass getSystem();

	/**
	 * Returns the meta object for the reference '{@link se.kth.md.SimulinkOOAPI.ISystem#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent</em>'.
	 * @see se.kth.md.SimulinkOOAPI.ISystem#getParent()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_Parent();

	/**
	 * Returns the meta object for class '{@link se.kth.md.SimulinkOOAPI.IModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see se.kth.md.SimulinkOOAPI.IModel
	 * @generated
	 */
	EClass getModel();

	/**
	 * Returns the meta object for class '{@link se.kth.md.SimulinkOOAPI.ISystemReference <em>System Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System Reference</em>'.
	 * @see se.kth.md.SimulinkOOAPI.ISystemReference
	 * @generated
	 */
	EClass getSystemReference();

	/**
	 * Returns the meta object for the reference '{@link se.kth.md.SimulinkOOAPI.ISystemReference#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see se.kth.md.SimulinkOOAPI.ISystemReference#getTarget()
	 * @see #getSystemReference()
	 * @generated
	 */
	EReference getSystemReference_Target();

	/**
	 * Returns the meta object for class '{@link se.kth.md.SimulinkOOAPI.IContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Container</em>'.
	 * @see se.kth.md.SimulinkOOAPI.IContainer
	 * @generated
	 */
	EClass getContainer();

	/**
	 * Returns the meta object for the containment reference '{@link se.kth.md.SimulinkOOAPI.IContainer#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Children</em>'.
	 * @see se.kth.md.SimulinkOOAPI.IContainer#getChildren()
	 * @see #getContainer()
	 * @generated
	 */
	EReference getContainer_Children();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ISimulinkOOAPIFactory getSimulinkOOAPIFactory();

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
		 * The meta object literal for the '{@link se.kth.md.SimulinkOOAPI.impl.ProtoObject <em>Proto Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see se.kth.md.SimulinkOOAPI.impl.ProtoObject
		 * @see se.kth.md.SimulinkOOAPI.impl.SimulinkOOAPIPackage#getProtoObject()
		 * @generated
		 */
		EClass PROTO_OBJECT = eINSTANCE.getProtoObject();

		/**
		 * The meta object literal for the '<em><b>Identity</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROTO_OBJECT__IDENTITY = eINSTANCE.getProtoObject_Identity();

		/**
		 * The meta object literal for the '{@link se.kth.md.SimulinkOOAPI.impl.Library <em>Library</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see se.kth.md.SimulinkOOAPI.impl.Library
		 * @see se.kth.md.SimulinkOOAPI.impl.SimulinkOOAPIPackage#getLibrary()
		 * @generated
		 */
		EClass LIBRARY = eINSTANCE.getLibrary();

		/**
		 * The meta object literal for the '{@link se.kth.md.SimulinkOOAPI.impl.Identity <em>Identity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see se.kth.md.SimulinkOOAPI.impl.Identity
		 * @see se.kth.md.SimulinkOOAPI.impl.SimulinkOOAPIPackage#getIdentity()
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
		 * The meta object literal for the '{@link se.kth.md.SimulinkOOAPI.impl.Mask <em>Mask</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see se.kth.md.SimulinkOOAPI.impl.Mask
		 * @see se.kth.md.SimulinkOOAPI.impl.SimulinkOOAPIPackage#getMask()
		 * @generated
		 */
		EClass MASK = eINSTANCE.getMask();

		/**
		 * The meta object literal for the '{@link se.kth.md.SimulinkOOAPI.impl.ChildrenSupport <em>Children Support</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see se.kth.md.SimulinkOOAPI.impl.ChildrenSupport
		 * @see se.kth.md.SimulinkOOAPI.impl.SimulinkOOAPIPackage#getChildrenSupport()
		 * @generated
		 */
		EClass CHILDREN_SUPPORT = eINSTANCE.getChildrenSupport();

		/**
		 * The meta object literal for the '{@link se.kth.md.SimulinkOOAPI.impl.GainBlock <em>Gain Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see se.kth.md.SimulinkOOAPI.impl.GainBlock
		 * @see se.kth.md.SimulinkOOAPI.impl.SimulinkOOAPIPackage#getGainBlock()
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
		 * The meta object literal for the '{@link se.kth.md.SimulinkOOAPI.impl.Port <em>Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see se.kth.md.SimulinkOOAPI.impl.Port
		 * @see se.kth.md.SimulinkOOAPI.impl.SimulinkOOAPIPackage#getPort()
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
		 * The meta object literal for the '{@link se.kth.md.SimulinkOOAPI.impl.Inport <em>Inport</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see se.kth.md.SimulinkOOAPI.impl.Inport
		 * @see se.kth.md.SimulinkOOAPI.impl.SimulinkOOAPIPackage#getInport()
		 * @generated
		 */
		EClass INPORT = eINSTANCE.getInport();

		/**
		 * The meta object literal for the '{@link se.kth.md.SimulinkOOAPI.impl.Outport <em>Outport</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see se.kth.md.SimulinkOOAPI.impl.Outport
		 * @see se.kth.md.SimulinkOOAPI.impl.SimulinkOOAPIPackage#getOutport()
		 * @generated
		 */
		EClass OUTPORT = eINSTANCE.getOutport();

		/**
		 * The meta object literal for the '{@link se.kth.md.SimulinkOOAPI.impl.Line <em>Line</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see se.kth.md.SimulinkOOAPI.impl.Line
		 * @see se.kth.md.SimulinkOOAPI.impl.SimulinkOOAPIPackage#getLine()
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
		 * The meta object literal for the '{@link se.kth.md.SimulinkOOAPI.impl.System <em>System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see se.kth.md.SimulinkOOAPI.impl.System
		 * @see se.kth.md.SimulinkOOAPI.impl.SimulinkOOAPIPackage#getSystem()
		 * @generated
		 */
		EClass SYSTEM = eINSTANCE.getSystem();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__PARENT = eINSTANCE.getSystem_Parent();

		/**
		 * The meta object literal for the '{@link se.kth.md.SimulinkOOAPI.impl.Model <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see se.kth.md.SimulinkOOAPI.impl.Model
		 * @see se.kth.md.SimulinkOOAPI.impl.SimulinkOOAPIPackage#getModel()
		 * @generated
		 */
		EClass MODEL = eINSTANCE.getModel();

		/**
		 * The meta object literal for the '{@link se.kth.md.SimulinkOOAPI.impl.SystemReference <em>System Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see se.kth.md.SimulinkOOAPI.impl.SystemReference
		 * @see se.kth.md.SimulinkOOAPI.impl.SimulinkOOAPIPackage#getSystemReference()
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

		/**
		 * The meta object literal for the '{@link se.kth.md.SimulinkOOAPI.impl.Container <em>Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see se.kth.md.SimulinkOOAPI.impl.Container
		 * @see se.kth.md.SimulinkOOAPI.impl.SimulinkOOAPIPackage#getContainer()
		 * @generated
		 */
		EClass CONTAINER = eINSTANCE.getContainer();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTAINER__CHILDREN = eINSTANCE.getContainer_Children();

	}

} //ISimulinkOOAPIPackage
