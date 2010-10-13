/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package SimulinkOOAPI.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import SimulinkOOAPI.ChildrenSupport;
import SimulinkOOAPI.SimulinkOOAPIPackage;
import SimulinkOOAPI.GainBlock;
import SimulinkOOAPI.ProtoObject;
import SimulinkOOAPI.ReflectionList;

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
	
	private ReflectionList<ProtoObject> children = new ReflectionListImpl<ProtoObject>();
	
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
	
    /**
     * @generated NOT
     */
	@Override
	public ReflectionList<GainBlock> getChildrenOfTypeGainBlock() {
		
		ReflectionList<GainBlock> result = new ReflectionListImpl<GainBlock>();
		
		for (ProtoObject child: this.children){
			child.ifGainBlockAddToList(result);			
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
	public ReflectionList<ProtoObject> getChildren() {		
		return this.children;
	}

	@Override
	public int getNumberOfChildren() {
		return this.children.size();
	}

} //ChildrenSupportImpl
