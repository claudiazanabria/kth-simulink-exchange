/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package SimulinkOOAPI.impl;

import SimulinkOOAPI.ChildrenSupport;
import SimulinkOOAPI.GainBlock;
import SimulinkOOAPI.ProtoObject;
import SimulinkOOAPI.SimulinkOOOAPIPackage;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.EObjectImpl;

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
	
	private EList<ProtoObject> children = new BasicEList<ProtoObject>();
	
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
		return SimulinkOOOAPIPackage.Literals.CHILDREN_SUPPORT;
	}
	
    /**
     * @generated NOT
     */
	@Override
	public EList<GainBlock> getChildrenOfTypeGainBlock() {
		
		EList<GainBlock> result = new BasicEList<GainBlock>();
		for (ProtoObject child: this.children){
			if (child instanceof GainBlock) {
				result.add((GainBlock) child);				
			}
		}		
		return result;
	}

	/**
     * @generated NOT
     */
	@Override
	public void addChild(ProtoObject child) {
		this.children.add(child);		
	}

	/**
     * @generated NOT
     */
	@Override
	public EList<ProtoObject> getChildren() {		
		return this.children;
	}

	@Override
	public int getNumberOfChildren() {
		return this.children.size();
	}

} //ChildrenSupportImpl
