/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package se.kth.md.SimulinkOOAPI.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import se.kth.md.SimulinkOOAPI.ChildrenSupport;
import se.kth.md.SimulinkOOAPI.GainBlock;
import se.kth.md.SimulinkOOAPI.Inport;
import se.kth.md.SimulinkOOAPI.Line;
import se.kth.md.SimulinkOOAPI.Outport;
import se.kth.md.SimulinkOOAPI.Port;
import se.kth.md.SimulinkOOAPI.ProtoObject;
import se.kth.md.SimulinkOOAPI.SimulinkList;
import se.kth.md.SimulinkOOAPI.SimulinkOOAPIPackage;
import se.kth.md.SimulinkOOAPI.System;
import se.kth.md.SimulinkOOAPI.SystemReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Children Support</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ChildrenSupportImpl extends EObjectImpl implements ChildrenSupport {
	
	private SimulinkList<ProtoObject> children = new SimulinkListImpl<ProtoObject>();
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChildrenSupportImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SimulinkOOAPIPackage.Literals.CHILDREN_SUPPORT;
	}
	
	@Override
	public void addChild(ProtoObject child) {
		this.children.add(child);		
	}

	@Override
	public SimulinkList<ProtoObject> getChildren() {		
		return this.children;
	}

	@Override
	public int getNumberOfChildren() {
		return this.children.size();
	}
	
	@Override
	public SimulinkList<GainBlock> getChildrenOfTypeGainBlock() {
		SimulinkList<GainBlock> result = new SimulinkListImpl<GainBlock>();

		for (ProtoObject child : this.children) {
			child.ifGainBlockAddToList(result);
		}
		return result;
	}

	@Override
	public SimulinkList<Line> getChildrenOfTypeLine() {
		SimulinkList<Line> result = new SimulinkListImpl<Line>();

		for (ProtoObject child : this.children) {
			child.ifLineAddToList(result);
		}
		return result;
	}

	@Override
	public SimulinkList<Port> getChildrenOfTypePort() {
		SimulinkList<Port> result = new SimulinkListImpl<Port>();

		for (ProtoObject child : this.children) {
			child.ifPortAddToList(result);
		}
		return result;
	}
	
	@Override
	public SimulinkList<System> getChildrenOfTypeSystem() {
		SimulinkList<System> result = new SimulinkListImpl<System>();

		for (ProtoObject child : this.children) {
			child.ifSystemAddToList(result);
		}
		return result;
	}

	@Override
	public SimulinkList<SystemReference> getChildrenOfTypeSystemReference() {
		SimulinkList<SystemReference> result = new SimulinkListImpl<SystemReference>();

		for (ProtoObject child : this.children) {
			child.ifSystemReferenceAddToList(result);
		}
		return result;
	}

	@Override
	public SimulinkList<Inport> getChildrenOfTypeInport() {
		SimulinkList<Inport> result = new SimulinkListImpl<Inport>();

		for (ProtoObject child : this.children) {
			child.ifInportAddToList(result);
		}
		return result;	
	}

	@Override
	public SimulinkList<Outport> getChildrenOfTypeOutport() {
		SimulinkList<Outport> result = new SimulinkListImpl<Outport>();

		for (ProtoObject child : this.children) {
			child.ifOutportAddToList(result);
		}
		return result;	

	}

} //ChildrenSupport
