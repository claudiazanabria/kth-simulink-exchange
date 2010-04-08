/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package Simulink;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * @see Simulink.SimulinkFactory
 * @model kind="package"
 * @generated
 */
public interface SimulinkPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "Simulink";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///se.kth.md.attest2/Simulink/3.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "sim";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SimulinkPackage eINSTANCE = Simulink.impl.SimulinkPackageImpl.init();

	/**
	 * The meta object id for the '{@link Simulink.impl.ProtoObjectImpl <em>Proto Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Simulink.impl.ProtoObjectImpl
	 * @see Simulink.impl.SimulinkPackageImpl#getProtoObject()
	 * @generated
	 */
	int PROTO_OBJECT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTO_OBJECT__NAME = EcorePackage.EOBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Simulink Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTO_OBJECT__SIMULINK_NAME = EcorePackage.EOBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTO_OBJECT__POSITION = EcorePackage.EOBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTO_OBJECT__UUID = EcorePackage.EOBJECT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Proto Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTO_OBJECT_FEATURE_COUNT = EcorePackage.EOBJECT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link Simulink.impl.PortImpl <em>Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Simulink.impl.PortImpl
	 * @see Simulink.impl.SimulinkPackageImpl#getPort()
	 * @generated
	 */
	int PORT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__NAME = PROTO_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Simulink Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__SIMULINK_NAME = PROTO_OBJECT__SIMULINK_NAME;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__POSITION = PROTO_OBJECT__POSITION;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__UUID = PROTO_OBJECT__UUID;

	/**
	 * The feature id for the '<em><b>Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__CONNECTIONS = PROTO_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_FEATURE_COUNT = PROTO_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link Simulink.impl.InportImpl <em>Inport</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Simulink.impl.InportImpl
	 * @see Simulink.impl.SimulinkPackageImpl#getInport()
	 * @generated
	 */
	int INPORT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPORT__NAME = PORT__NAME;

	/**
	 * The feature id for the '<em><b>Simulink Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPORT__SIMULINK_NAME = PORT__SIMULINK_NAME;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPORT__POSITION = PORT__POSITION;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPORT__UUID = PORT__UUID;

	/**
	 * The feature id for the '<em><b>Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPORT__CONNECTIONS = PORT__CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPORT__PARENT = PORT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Inport</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPORT_FEATURE_COUNT = PORT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link Simulink.impl.OutportImpl <em>Outport</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Simulink.impl.OutportImpl
	 * @see Simulink.impl.SimulinkPackageImpl#getOutport()
	 * @generated
	 */
	int OUTPORT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPORT__NAME = PORT__NAME;

	/**
	 * The feature id for the '<em><b>Simulink Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPORT__SIMULINK_NAME = PORT__SIMULINK_NAME;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPORT__POSITION = PORT__POSITION;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPORT__UUID = PORT__UUID;

	/**
	 * The feature id for the '<em><b>Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPORT__CONNECTIONS = PORT__CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPORT__PARENT = PORT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Outport</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPORT_FEATURE_COUNT = PORT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link Simulink.impl.LineImpl <em>Line</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Simulink.impl.LineImpl
	 * @see Simulink.impl.SimulinkPackageImpl#getLine()
	 * @generated
	 */
	int LINE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE__NAME = PROTO_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Simulink Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE__SIMULINK_NAME = PROTO_OBJECT__SIMULINK_NAME;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE__POSITION = PROTO_OBJECT__POSITION;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE__UUID = PROTO_OBJECT__UUID;

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
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE__PARENT = PROTO_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Simu Name Src</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE__SIMU_NAME_SRC = PROTO_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Simu Name Dst</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE__SIMU_NAME_DST = PROTO_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Line</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_FEATURE_COUNT = PROTO_OBJECT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link Simulink.impl.SystemImpl <em>System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Simulink.impl.SystemImpl
	 * @see Simulink.impl.SimulinkPackageImpl#getSystem()
	 * @generated
	 */
	int SYSTEM = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__NAME = PROTO_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Simulink Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__SIMULINK_NAME = PROTO_OBJECT__SIMULINK_NAME;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__POSITION = PROTO_OBJECT__POSITION;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__UUID = PROTO_OBJECT__UUID;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__CHILDREN = PROTO_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Lines</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__LINES = PROTO_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Inports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__INPORTS = PROTO_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Outports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__OUTPORTS = PROTO_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Filename</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__FILENAME = PROTO_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_FEATURE_COUNT = PROTO_OBJECT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link Simulink.impl.ModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Simulink.impl.ModelImpl
	 * @see Simulink.impl.SimulinkPackageImpl#getModel()
	 * @generated
	 */
	int MODEL = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__NAME = PROTO_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Simulink Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__SIMULINK_NAME = PROTO_OBJECT__SIMULINK_NAME;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__POSITION = PROTO_OBJECT__POSITION;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__UUID = PROTO_OBJECT__UUID;

	/**
	 * The feature id for the '<em><b>Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__PARTS = PROTO_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Root</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__ROOT = PROTO_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_FEATURE_COUNT = PROTO_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link Simulink.impl.SystemReferenceImpl <em>System Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Simulink.impl.SystemReferenceImpl
	 * @see Simulink.impl.SimulinkPackageImpl#getSystemReference()
	 * @generated
	 */
	int SYSTEM_REFERENCE = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_REFERENCE__NAME = PROTO_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Simulink Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_REFERENCE__SIMULINK_NAME = PROTO_OBJECT__SIMULINK_NAME;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_REFERENCE__POSITION = PROTO_OBJECT__POSITION;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_REFERENCE__UUID = PROTO_OBJECT__UUID;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_REFERENCE__TARGET = PROTO_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_REFERENCE__PARENT = PROTO_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>System Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_REFERENCE_FEATURE_COUNT = PROTO_OBJECT_FEATURE_COUNT + 2;


	/**
	 * The meta object id for the '<em>UUID</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.UUID
	 * @see Simulink.impl.SimulinkPackageImpl#getUUID()
	 * @generated
	 */
	int UUID = 8;


	/**
	 * Returns the meta object for class '{@link Simulink.ProtoObject <em>Proto Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Proto Object</em>'.
	 * @see Simulink.ProtoObject
	 * @generated
	 */
	EClass getProtoObject();

	/**
	 * Returns the meta object for the attribute '{@link Simulink.ProtoObject#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see Simulink.ProtoObject#getName()
	 * @see #getProtoObject()
	 * @generated
	 */
	EAttribute getProtoObject_Name();

	/**
	 * Returns the meta object for the attribute '{@link Simulink.ProtoObject#getSimulinkName <em>Simulink Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Simulink Name</em>'.
	 * @see Simulink.ProtoObject#getSimulinkName()
	 * @see #getProtoObject()
	 * @generated
	 */
	EAttribute getProtoObject_SimulinkName();

	/**
	 * Returns the meta object for the attribute '{@link Simulink.ProtoObject#getPosition <em>Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Position</em>'.
	 * @see Simulink.ProtoObject#getPosition()
	 * @see #getProtoObject()
	 * @generated
	 */
	EAttribute getProtoObject_Position();

	/**
	 * Returns the meta object for the attribute '{@link Simulink.ProtoObject#getUuid <em>Uuid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uuid</em>'.
	 * @see Simulink.ProtoObject#getUuid()
	 * @see #getProtoObject()
	 * @generated
	 */
	EAttribute getProtoObject_Uuid();

	/**
	 * Returns the meta object for class '{@link Simulink.Port <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port</em>'.
	 * @see Simulink.Port
	 * @generated
	 */
	EClass getPort();

	/**
	 * Returns the meta object for the reference list '{@link Simulink.Port#getConnections <em>Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Connections</em>'.
	 * @see Simulink.Port#getConnections()
	 * @see #getPort()
	 * @generated
	 */
	EReference getPort_Connections();

	/**
	 * Returns the meta object for class '{@link Simulink.Inport <em>Inport</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inport</em>'.
	 * @see Simulink.Inport
	 * @generated
	 */
	EClass getInport();

	/**
	 * Returns the meta object for the container reference '{@link Simulink.Inport#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see Simulink.Inport#getParent()
	 * @see #getInport()
	 * @generated
	 */
	EReference getInport_Parent();

	/**
	 * Returns the meta object for class '{@link Simulink.Outport <em>Outport</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Outport</em>'.
	 * @see Simulink.Outport
	 * @generated
	 */
	EClass getOutport();

	/**
	 * Returns the meta object for the container reference '{@link Simulink.Outport#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see Simulink.Outport#getParent()
	 * @see #getOutport()
	 * @generated
	 */
	EReference getOutport_Parent();

	/**
	 * Returns the meta object for class '{@link Simulink.Line <em>Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Line</em>'.
	 * @see Simulink.Line
	 * @generated
	 */
	EClass getLine();

	/**
	 * Returns the meta object for the reference '{@link Simulink.Line#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see Simulink.Line#getSource()
	 * @see #getLine()
	 * @generated
	 */
	EReference getLine_Source();

	/**
	 * Returns the meta object for the reference '{@link Simulink.Line#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Destination</em>'.
	 * @see Simulink.Line#getDestination()
	 * @see #getLine()
	 * @generated
	 */
	EReference getLine_Destination();

	/**
	 * Returns the meta object for the container reference '{@link Simulink.Line#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see Simulink.Line#getParent()
	 * @see #getLine()
	 * @generated
	 */
	EReference getLine_Parent();

	/**
	 * Returns the meta object for the attribute '{@link Simulink.Line#getSimuNameSrc <em>Simu Name Src</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Simu Name Src</em>'.
	 * @see Simulink.Line#getSimuNameSrc()
	 * @see #getLine()
	 * @generated
	 */
	EAttribute getLine_SimuNameSrc();

	/**
	 * Returns the meta object for the attribute '{@link Simulink.Line#getSimuNameDst <em>Simu Name Dst</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Simu Name Dst</em>'.
	 * @see Simulink.Line#getSimuNameDst()
	 * @see #getLine()
	 * @generated
	 */
	EAttribute getLine_SimuNameDst();

	/**
	 * Returns the meta object for class '{@link Simulink.System <em>System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System</em>'.
	 * @see Simulink.System
	 * @generated
	 */
	EClass getSystem();

	/**
	 * Returns the meta object for the containment reference list '{@link Simulink.System#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see Simulink.System#getChildren()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_Children();

	/**
	 * Returns the meta object for the containment reference list '{@link Simulink.System#getLines <em>Lines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Lines</em>'.
	 * @see Simulink.System#getLines()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_Lines();

	/**
	 * Returns the meta object for the containment reference list '{@link Simulink.System#getInports <em>Inports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Inports</em>'.
	 * @see Simulink.System#getInports()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_Inports();

	/**
	 * Returns the meta object for the containment reference list '{@link Simulink.System#getOutports <em>Outports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Outports</em>'.
	 * @see Simulink.System#getOutports()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_Outports();

	/**
	 * Returns the meta object for the attribute '{@link Simulink.System#getFilename <em>Filename</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Filename</em>'.
	 * @see Simulink.System#getFilename()
	 * @see #getSystem()
	 * @generated
	 */
	EAttribute getSystem_Filename();

	/**
	 * Returns the meta object for class '{@link Simulink.Model <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see Simulink.Model
	 * @generated
	 */
	EClass getModel();

	/**
	 * Returns the meta object for the containment reference list '{@link Simulink.Model#getParts <em>Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parts</em>'.
	 * @see Simulink.Model#getParts()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_Parts();

	/**
	 * Returns the meta object for the reference '{@link Simulink.Model#getRoot <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Root</em>'.
	 * @see Simulink.Model#getRoot()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_Root();

	/**
	 * Returns the meta object for class '{@link Simulink.SystemReference <em>System Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System Reference</em>'.
	 * @see Simulink.SystemReference
	 * @generated
	 */
	EClass getSystemReference();

	/**
	 * Returns the meta object for the reference '{@link Simulink.SystemReference#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see Simulink.SystemReference#getTarget()
	 * @see #getSystemReference()
	 * @generated
	 */
	EReference getSystemReference_Target();

	/**
	 * Returns the meta object for the container reference '{@link Simulink.SystemReference#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see Simulink.SystemReference#getParent()
	 * @see #getSystemReference()
	 * @generated
	 */
	EReference getSystemReference_Parent();

	/**
	 * Returns the meta object for data type '{@link java.util.UUID <em>UUID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>UUID</em>'.
	 * @see java.util.UUID
	 * @model instanceClass="java.util.UUID"
	 * @generated
	 */
	EDataType getUUID();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SimulinkFactory getSimulinkFactory();

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
		 * The meta object literal for the '{@link Simulink.impl.ProtoObjectImpl <em>Proto Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Simulink.impl.ProtoObjectImpl
		 * @see Simulink.impl.SimulinkPackageImpl#getProtoObject()
		 * @generated
		 */
		EClass PROTO_OBJECT = eINSTANCE.getProtoObject();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROTO_OBJECT__NAME = eINSTANCE.getProtoObject_Name();

		/**
		 * The meta object literal for the '<em><b>Simulink Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROTO_OBJECT__SIMULINK_NAME = eINSTANCE.getProtoObject_SimulinkName();

		/**
		 * The meta object literal for the '<em><b>Position</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROTO_OBJECT__POSITION = eINSTANCE.getProtoObject_Position();

		/**
		 * The meta object literal for the '<em><b>Uuid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROTO_OBJECT__UUID = eINSTANCE.getProtoObject_Uuid();

		/**
		 * The meta object literal for the '{@link Simulink.impl.PortImpl <em>Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Simulink.impl.PortImpl
		 * @see Simulink.impl.SimulinkPackageImpl#getPort()
		 * @generated
		 */
		EClass PORT = eINSTANCE.getPort();

		/**
		 * The meta object literal for the '<em><b>Connections</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT__CONNECTIONS = eINSTANCE.getPort_Connections();

		/**
		 * The meta object literal for the '{@link Simulink.impl.InportImpl <em>Inport</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Simulink.impl.InportImpl
		 * @see Simulink.impl.SimulinkPackageImpl#getInport()
		 * @generated
		 */
		EClass INPORT = eINSTANCE.getInport();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INPORT__PARENT = eINSTANCE.getInport_Parent();

		/**
		 * The meta object literal for the '{@link Simulink.impl.OutportImpl <em>Outport</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Simulink.impl.OutportImpl
		 * @see Simulink.impl.SimulinkPackageImpl#getOutport()
		 * @generated
		 */
		EClass OUTPORT = eINSTANCE.getOutport();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OUTPORT__PARENT = eINSTANCE.getOutport_Parent();

		/**
		 * The meta object literal for the '{@link Simulink.impl.LineImpl <em>Line</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Simulink.impl.LineImpl
		 * @see Simulink.impl.SimulinkPackageImpl#getLine()
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
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINE__PARENT = eINSTANCE.getLine_Parent();

		/**
		 * The meta object literal for the '<em><b>Simu Name Src</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINE__SIMU_NAME_SRC = eINSTANCE.getLine_SimuNameSrc();

		/**
		 * The meta object literal for the '<em><b>Simu Name Dst</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINE__SIMU_NAME_DST = eINSTANCE.getLine_SimuNameDst();

		/**
		 * The meta object literal for the '{@link Simulink.impl.SystemImpl <em>System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Simulink.impl.SystemImpl
		 * @see Simulink.impl.SimulinkPackageImpl#getSystem()
		 * @generated
		 */
		EClass SYSTEM = eINSTANCE.getSystem();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__CHILDREN = eINSTANCE.getSystem_Children();

		/**
		 * The meta object literal for the '<em><b>Lines</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__LINES = eINSTANCE.getSystem_Lines();

		/**
		 * The meta object literal for the '<em><b>Inports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__INPORTS = eINSTANCE.getSystem_Inports();

		/**
		 * The meta object literal for the '<em><b>Outports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__OUTPORTS = eINSTANCE.getSystem_Outports();

		/**
		 * The meta object literal for the '<em><b>Filename</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYSTEM__FILENAME = eINSTANCE.getSystem_Filename();

		/**
		 * The meta object literal for the '{@link Simulink.impl.ModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Simulink.impl.ModelImpl
		 * @see Simulink.impl.SimulinkPackageImpl#getModel()
		 * @generated
		 */
		EClass MODEL = eINSTANCE.getModel();

		/**
		 * The meta object literal for the '<em><b>Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__PARTS = eINSTANCE.getModel_Parts();

		/**
		 * The meta object literal for the '<em><b>Root</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__ROOT = eINSTANCE.getModel_Root();

		/**
		 * The meta object literal for the '{@link Simulink.impl.SystemReferenceImpl <em>System Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Simulink.impl.SystemReferenceImpl
		 * @see Simulink.impl.SimulinkPackageImpl#getSystemReference()
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
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_REFERENCE__PARENT = eINSTANCE.getSystemReference_Parent();

		/**
		 * The meta object literal for the '<em>UUID</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.UUID
		 * @see Simulink.impl.SimulinkPackageImpl#getUUID()
		 * @generated
		 */
		EDataType UUID = eINSTANCE.getUUID();

	}

} //SimulinkPackage
