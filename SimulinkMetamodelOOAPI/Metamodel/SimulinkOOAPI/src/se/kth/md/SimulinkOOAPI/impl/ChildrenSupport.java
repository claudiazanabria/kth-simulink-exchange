/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package se.kth.md.SimulinkOOAPI.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import se.kth.md.SimulinkOOAPI.IChildrenSupport;
import se.kth.md.SimulinkOOAPI.IGainBlock;
import se.kth.md.SimulinkOOAPI.IInport;
import se.kth.md.SimulinkOOAPI.ILine;
import se.kth.md.SimulinkOOAPI.IOutport;
import se.kth.md.SimulinkOOAPI.IPort;
import se.kth.md.SimulinkOOAPI.IProtoObject;
import se.kth.md.SimulinkOOAPI.IReflectionList;
import se.kth.md.SimulinkOOAPI.ISimulinkOOAPIPackage;
import se.kth.md.SimulinkOOAPI.ISystem;
import se.kth.md.SimulinkOOAPI.ISystemReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Children Support</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ChildrenSupport extends EObjectImpl implements IChildrenSupport {
	
	private IReflectionList<IProtoObject> children = new ReflectionList<IProtoObject>();
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChildrenSupport() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ISimulinkOOAPIPackage.Literals.CHILDREN_SUPPORT;
	}
	
	@Override
	public void addChild(IProtoObject child) {
		this.children.add(child);		
	}

	@Override
	public IReflectionList<IProtoObject> getChildren() {		
		return this.children;
	}

	@Override
	public int getNumberOfChildren() {
		return this.children.size();
	}
	
	@Override
	public IReflectionList<IGainBlock> getChildrenOfTypeGainBlock() {
		IReflectionList<IGainBlock> result = new ReflectionList<IGainBlock>();

		for (IProtoObject child : this.children) {
			child.ifGainBlockAddToList(result);
		}
		return result;
	}

	@Override
	public IReflectionList<ILine> getChildrenOfTypeLine() {
		IReflectionList<ILine> result = new ReflectionList<ILine>();

		for (IProtoObject child : this.children) {
			child.ifLineAddToList(result);
		}
		return result;
	}

	@Override
	public IReflectionList<IPort> getChildrenOfTypePort() {
		IReflectionList<IPort> result = new ReflectionList<IPort>();

		for (IProtoObject child : this.children) {
			child.ifPortAddToList(result);
		}
		return result;
	}
	
	@Override
	public IReflectionList<ISystem> getChildrenOfTypeSystem() {
		IReflectionList<ISystem> result = new ReflectionList<ISystem>();

		for (IProtoObject child : this.children) {
			child.ifSystemAddToList(result);
		}
		return result;
	}

	@Override
	public IReflectionList<ISystemReference> getChildrenOfTypeSystemReference() {
		IReflectionList<ISystemReference> result = new ReflectionList<ISystemReference>();

		for (IProtoObject child : this.children) {
			child.ifSystemReferenceAddToList(result);
		}
		return result;
	}

	@Override
	public IReflectionList<IInport> getChildrenOfTypeInport() {
		IReflectionList<IInport> result = new ReflectionList<IInport>();

		for (IProtoObject child : this.children) {
			child.ifInportAddToList(result);
		}
		return result;	
	}

	@Override
	public IReflectionList<IOutport> getChildrenOfTypeOutport() {
		IReflectionList<IOutport> result = new ReflectionList<IOutport>();

		for (IProtoObject child : this.children) {
			child.ifOutportAddToList(result);
		}
		return result;	

	}

} //ChildrenSupport
