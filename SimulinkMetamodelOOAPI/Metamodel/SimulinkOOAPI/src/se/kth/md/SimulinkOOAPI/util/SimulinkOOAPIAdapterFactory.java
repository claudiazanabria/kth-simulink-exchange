/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package se.kth.md.SimulinkOOAPI.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

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
import se.kth.md.SimulinkOOAPI.IPort;
import se.kth.md.SimulinkOOAPI.IProtoObject;
import se.kth.md.SimulinkOOAPI.ISimulinkOOAPIPackage;
import se.kth.md.SimulinkOOAPI.ISystem;
import se.kth.md.SimulinkOOAPI.ISystemReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see se.kth.md.SimulinkOOAPI.ISimulinkOOAPIPackage
 * @generated
 */
public class SimulinkOOAPIAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ISimulinkOOAPIPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimulinkOOAPIAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ISimulinkOOAPIPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimulinkOOAPISwitch<Adapter> modelSwitch =
		new SimulinkOOAPISwitch<Adapter>() {
			@Override
			public Adapter caseProtoObject(IProtoObject object) {
				return createProtoObjectAdapter();
			}
			@Override
			public Adapter caseLibrary(ILibrary object) {
				return createLibraryAdapter();
			}
			@Override
			public Adapter caseIdentity(IIdentity object) {
				return createIdentityAdapter();
			}
			@Override
			public Adapter caseMask(IMask object) {
				return createMaskAdapter();
			}
			@Override
			public Adapter caseChildrenSupport(IChildrenSupport object) {
				return createChildrenSupportAdapter();
			}
			@Override
			public Adapter caseGainBlock(IGainBlock object) {
				return createGainBlockAdapter();
			}
			@Override
			public Adapter casePort(IPort object) {
				return createPortAdapter();
			}
			@Override
			public Adapter caseInport(IInport object) {
				return createInportAdapter();
			}
			@Override
			public Adapter caseOutport(IOutport object) {
				return createOutportAdapter();
			}
			@Override
			public Adapter caseLine(ILine object) {
				return createLineAdapter();
			}
			@Override
			public Adapter caseSystem(ISystem object) {
				return createSystemAdapter();
			}
			@Override
			public Adapter caseModel(IModel object) {
				return createModelAdapter();
			}
			@Override
			public Adapter caseSystemReference(ISystemReference object) {
				return createSystemReferenceAdapter();
			}
			@Override
			public Adapter caseContainer(IContainer object) {
				return createContainerAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link se.kth.md.SimulinkOOAPI.IProtoObject <em>Proto Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see se.kth.md.SimulinkOOAPI.IProtoObject
	 * @generated
	 */
	public Adapter createProtoObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link se.kth.md.SimulinkOOAPI.ILibrary <em>Library</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see se.kth.md.SimulinkOOAPI.ILibrary
	 * @generated
	 */
	public Adapter createLibraryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link se.kth.md.SimulinkOOAPI.IIdentity <em>Identity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see se.kth.md.SimulinkOOAPI.IIdentity
	 * @generated
	 */
	public Adapter createIdentityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link se.kth.md.SimulinkOOAPI.IMask <em>Mask</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see se.kth.md.SimulinkOOAPI.IMask
	 * @generated
	 */
	public Adapter createMaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link se.kth.md.SimulinkOOAPI.IChildrenSupport <em>Children Support</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see se.kth.md.SimulinkOOAPI.IChildrenSupport
	 * @generated
	 */
	public Adapter createChildrenSupportAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link se.kth.md.SimulinkOOAPI.IGainBlock <em>Gain Block</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see se.kth.md.SimulinkOOAPI.IGainBlock
	 * @generated
	 */
	public Adapter createGainBlockAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link se.kth.md.SimulinkOOAPI.IPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see se.kth.md.SimulinkOOAPI.IPort
	 * @generated
	 */
	public Adapter createPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link se.kth.md.SimulinkOOAPI.IInport <em>Inport</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see se.kth.md.SimulinkOOAPI.IInport
	 * @generated
	 */
	public Adapter createInportAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link se.kth.md.SimulinkOOAPI.IOutport <em>Outport</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see se.kth.md.SimulinkOOAPI.IOutport
	 * @generated
	 */
	public Adapter createOutportAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link se.kth.md.SimulinkOOAPI.ILine <em>Line</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see se.kth.md.SimulinkOOAPI.ILine
	 * @generated
	 */
	public Adapter createLineAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link se.kth.md.SimulinkOOAPI.ISystem <em>System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see se.kth.md.SimulinkOOAPI.ISystem
	 * @generated
	 */
	public Adapter createSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link se.kth.md.SimulinkOOAPI.IModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see se.kth.md.SimulinkOOAPI.IModel
	 * @generated
	 */
	public Adapter createModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link se.kth.md.SimulinkOOAPI.ISystemReference <em>System Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see se.kth.md.SimulinkOOAPI.ISystemReference
	 * @generated
	 */
	public Adapter createSystemReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link se.kth.md.SimulinkOOAPI.IContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see se.kth.md.SimulinkOOAPI.IContainer
	 * @generated
	 */
	public Adapter createContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //SimulinkOOAPIAdapterFactory
