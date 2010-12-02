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
import se.kth.md.SimulinkOOAPI.ISimulinkList;
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
	
	private ISimulinkList<IProtoObject> children = new SimulinkList<IProtoObject>();
	
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
	public ISimulinkList<IProtoObject> getChildren() {		
		return this.children;
	}

	@Override
	public int getNumberOfChildren() {
		return this.children.size();
	}
	
	@Override
	public ISimulinkList<IGainBlock> getChildrenOfTypeGainBlock() {
		ISimulinkList<IGainBlock> result = new SimulinkList<IGainBlock>();

		for (IProtoObject child : this.children) {
			child.ifGainBlockAddToList(result);
		}
		return result;
	}

	@Override
	public ISimulinkList<ILine> getChildrenOfTypeLine() {
		ISimulinkList<ILine> result = new SimulinkList<ILine>();

		for (IProtoObject child : this.children) {
			child.ifLineAddToList(result);
		}
		return result;
	}

	@Override
	public ISimulinkList<IPort> getChildrenOfTypePort() {
		ISimulinkList<IPort> result = new SimulinkList<IPort>();

		for (IProtoObject child : this.children) {
			child.ifPortAddToList(result);
		}
		return result;
	}
	
	@Override
	public ISimulinkList<ISystem> getChildrenOfTypeSystem() {
		ISimulinkList<ISystem> result = new SimulinkList<ISystem>();

		for (IProtoObject child : this.children) {
			child.ifSystemAddToList(result);
		}
		return result;
	}

	@Override
	public ISimulinkList<ISystemReference> getChildrenOfTypeSystemReference() {
		ISimulinkList<ISystemReference> result = new SimulinkList<ISystemReference>();

		for (IProtoObject child : this.children) {
			child.ifSystemReferenceAddToList(result);
		}
		return result;
	}

	@Override
	public ISimulinkList<IInport> getChildrenOfTypeInport() {
		ISimulinkList<IInport> result = new SimulinkList<IInport>();

		for (IProtoObject child : this.children) {
			child.ifInportAddToList(result);
		}
		return result;	
	}

	@Override
	public ISimulinkList<IOutport> getChildrenOfTypeOutport() {
		ISimulinkList<IOutport> result = new SimulinkList<IOutport>();

		for (IProtoObject child : this.children) {
			child.ifOutportAddToList(result);
		}
		return result;	

	}

} //ChildrenSupport
