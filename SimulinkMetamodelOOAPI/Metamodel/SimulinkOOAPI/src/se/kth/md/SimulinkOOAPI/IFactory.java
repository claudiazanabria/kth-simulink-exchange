package se.kth.md.SimulinkOOAPI;

import se.kth.md.SimulinkOOAPI.impl.ProtoObjectCreationException;

public interface IFactory {
	
	
	
	
		
	public ILine createLine(String name, IModel parent, IOutport source, IInport destination) throws ProtoObjectCreationException;
	
	
	public ILine createLine(String name, ISystem parent, IOutport source, IInport destination) throws ProtoObjectCreationException;
	
	
	public IInport createInport(String name, ISystem parent) throws ProtoObjectCreationException;
	
	/**
	 * Returns new instance of Outport with the given name within the given system	 
	 */	
	public IOutport createOutport(String name, ISystem parent) throws ProtoObjectCreationException;
	
	
	public IModel createModel(String name) throws ProtoObjectCreationException;
	
	
	public ISystem createSystem(String name, IModel parent) throws ProtoObjectCreationException;
	
	/**
	 * Returns new instance of System with the given name within the given system. 
	 */
	public ISystem createSystem(String name, ISystem parent) throws ProtoObjectCreationException;
	
	/**
	 * Returns new instance of System with the given name within the given library. 
	 */
	public ISystem createSystem(String name, ILibrary parent) throws ProtoObjectCreationException;
	
	/**
	 * Returns new instance of SystemReference with the given name, within the given model, targeting to the given system
	 */	
	public ISystemReference createSystemReferemce(String name, IModel parent, ISystem target) throws ProtoObjectCreationException;
	
	/**
	 * Returns new instance of SystemReference with the given name, within the given system, targeting to the given system
	 */	
	public ISystemReference createSystemReferemce(String name, ISystem parent, ISystem target) throws ProtoObjectCreationException;

}
