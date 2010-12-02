package se.kth.md.SimulinkOOAPI.impl;


import java.util.HashMap;
import java.util.Map;

import se.kth.md.SimulinkOOAPI.IGainBlock;
import se.kth.md.SimulinkOOAPI.IInport;
import se.kth.md.SimulinkOOAPI.ILibrary;
import se.kth.md.SimulinkOOAPI.ILine;
import se.kth.md.SimulinkOOAPI.IModel;
import se.kth.md.SimulinkOOAPI.IOutport;
import se.kth.md.SimulinkOOAPI.ISystem;
import se.kth.md.SimulinkOOAPI.ISystemReference;
import se.kth.md.SimulinkOOAPI.exceptions.ProtoObjectCreationException;

/**
 * The Simulink model factory  
 */
public class Factory {
	
	/**
	 * Returns new instance of GainBlock with the given name, with the given gain, contains within the given system.
	 */	
	public static IGainBlock newGainBlockNamedWithinWithGain(String name, ISystem parent, int gain) throws ProtoObjectCreationException {		
		return GainBlock.newNamedWithinWithGain(name, parent, gain);
	}
	
	/**
	 * Returns new instance of GainBlock with the given name, with the given gain, contains within the given model.
	 */	
	public static IGainBlock newGainBlockNamedWithinWithGain(String name, IModel parent, int gain) throws ProtoObjectCreationException {		
		return GainBlock.newNamedWithinWithGain(name, parent, gain);
	}
	
	/**
	 * Returns new instance of GainBlock with the given name, with the given gain, contains within the given library.
	 */	
	public static IGainBlock newGainBlockNamedWithinWithGain(String name, ILibrary parent, int gain) throws ProtoObjectCreationException {		
		return GainBlock.newNamedWithinWithGain(name, parent, gain);
	}

	/**
	 * Returns new Library instance with the given name.
	 */
	public static ILibrary newLibraryNamed(String name) throws ProtoObjectCreationException {
		return Library.newNamed(name);
	}

	/**
	 * Returns new instance of Line with the given name within the given model between the inport and the outport.
	 */
	public static ILine newLineNameWithinFromTo(String name, IModel parent, IOutport source, IInport destination) throws ProtoObjectCreationException {		
		return Line.newNamedWithinFromTo(name, parent, source, destination);
	}
	
	/**
	 * Returns new instance of Line with the given name within the given system between the inport and the outport.
	 */
	public static ILine newLineNameWithinFromTo(String name, ISystem parent, IOutport source, IInport destination) throws ProtoObjectCreationException {		
		return Line.newNamedWithinFromTo(name, parent, source, destination);
	}

	/**
	 * Returns new instance of Inport with the given name within the given system	 
	 */	
	public static IInport newInportNamedWithin(String name, ISystem parent) throws ProtoObjectCreationException {		
		return Inport.newNamedWithin(name, parent);
	}

	/**
	 * Returns new instance of Outport with the given name within the given system	 
	 */	
	public static IOutport newOutportNamedWithin(String name, ISystem parent) throws ProtoObjectCreationException {
		return Outport.newNamedWithin(name, parent);
	}

	/**
	 * Returns new Model instance with the given name.
	 */
	public static IModel newModelNamed(String name) throws ProtoObjectCreationException {		
		return Model.newNamed(name);
	}

	/**
	 * Returns new instance of System with the given name within the given model. 
	 */
	public static ISystem newSystemNamedWithin(String name, IModel parent) throws ProtoObjectCreationException {		
		return System.newNamedWithin(name, parent);
	}
	
	/**
	 * Returns new instance of System with the given name within the given system. 
	 */
	public static ISystem newSystemNamedWithin(String name, ISystem parent) throws ProtoObjectCreationException {		
		return System.newNamedWithin(name, parent);
	}
	
	/**
	 * Returns new instance of System with the given name within the given library. 
	 */
	public static ISystem newSystemNamedWithin(String name, ILibrary parent) throws ProtoObjectCreationException {		
		return System.newNamedWithin(name, parent);
	}

	/**
	 * Returns new instance of SystemReference with the given name, within the
	 * given model, targeting to the given system
	 */
	public static ISystemReference newSystemReferemceNamedWithinTargeting(
			String name, IModel parent, ISystem target)
			throws ProtoObjectCreationException {
		return SystemReference.newNamedWithinTargeting(name, parent, target);
	}

	/**
	 * Returns new instance of SystemReference with the given name, within the
	 * given system, targeting to the given system
	 */
	public static ISystemReference newSystemReferemceNamedWithinTargeting(
			String name, ISystem parent, ISystem target)
			throws ProtoObjectCreationException {
		return SystemReference.newNamedWithinTargeting(name, parent, target);
	}
	
	/**
	 * List of required parameters to create a valid gain block object
	 */
	protected static final String keyWithGain = "withGain";
	protected static final String keyWithin = "within";
	protected static final String keyWithName = "named";
	protected static final String keyFrom = "from";	
	protected static final String keyTo = "to";
	protected static final String keyTargeting = "targeting";	
	
	/***
	 * Proto Object under construction.
	 */
	private static class Builder{
		Map<String, Object> constructDict = new HashMap<String, Object>();		
		
		public Builder withGain(int gain){
			this.constructDict.put(keyWithGain, gain);
			return this;
		}
		
		public Builder named(String name){
			constructDict.put(keyWithName, name);
			return this;
		}
		
		public Builder within(IModel parent){
			constructDict.put(keyWithin, parent);
			return this;
		}
		
		public Builder within(ISystem parent){
			constructDict.put(keyWithin, parent);
			return this;
		}
		
		public Builder within(ILibrary parent){
			constructDict.put(keyWithin, parent);
			return this;
		}
		
		public Builder from(IOutport port){
			constructDict.put(keyFrom, port);
			return this;
		}
		
		public Builder to(IInport port){
			constructDict.put(keyTo, port);
			return this;
		}
		
		public Builder targeting(ISystem target){
			constructDict.put(keyTargeting, target);
			return this;
		}		
		
	    public IGainBlock createGainBlock() throws ProtoObjectCreationException {
			return GainBlock.newFromDictionary(this.constructDict);
		}		
		
		public ILibrary createLibrary() throws ProtoObjectCreationException {
			return Library.newFromDictionary(this.constructDict);
		}
		
		public ILine createLine() throws ProtoObjectCreationException {
			return Line.newFromDictionary(this.constructDict);
		}
		
		public IInport createInport() throws ProtoObjectCreationException{
			return Inport.newFromDictionary(this.constructDict);	
		}
		
		public IOutport createOutport() throws ProtoObjectCreationException{
			return Outport.newFromDictionary(this.constructDict);	
		}
		
		public IModel createModel() throws ProtoObjectCreationException {
			return Model.newFromDictionary(this.constructDict);
		}
		
		public ISystem createSystem() throws ProtoObjectCreationException {
			return System.newFromDictionary(this.constructDict);
		}
		
		public ISystemReference createSystemReferemce() throws ProtoObjectCreationException {
			return SystemReference.newFromDictionary(this.constructDict);
		}
		
	}

	
	
//	public static class GainBlockUnderConstruction extends ProtoObjectUnderConstruction{
//		
//		public ProtoObjectUnderConstruction withGain(int gain){
//			this.constructDict.put(keyWithGain, gain);
//			return this;
//		}
//		
//		public ProtoObjectUnderConstruction named(String name){
//			constructDict.put(keyWithName, name);
//			return this;
//		}
//		
//		
//		public ProtoObjectUnderConstruction within(System parent){
//			constructDict.put(keyWithin, parent);
//			return this;
//		}
//		
//		public ProtoObjectUnderConstruction within(Library parent){
//			constructDict.put(keyWithin, parent);
//			return this;
//		}
//		
//		public GainBlock please() throws ProtoObjectCreationException{
//			return GainBlockImpl.newFromDictionary(this.constructDict);
//		}
//	}
	
	
//	public static class LineUnderConstruction extends ProtoObjectUnderConstruction{
//
//		public LineUnderConstruction from(Outport port){
//			constructDict.put(keyFrom, port);
//			return this;
//		}
//		
//		public LineUnderConstruction to(Inport port){
//			constructDict.put(keyTo, port);
//			return this;
//		}
//		
//		public LineUnderConstruction within(System parent){
//			constructDict.put(keyWithin, parent);
//			return this;
//		}
//		
//		public LineUnderConstruction within(Model parent){
//			constructDict.put(keyWithin, parent);
//			return this;
//		}
//		
//		public LineUnderConstruction withName(String name){
//			constructDict.put(keyWithName, name);
//			return this;
//		}	
//		
//		public Line please() throws ProtoObjectCreationException{
//			return LineImpl.newFromDictionary(this.constructDict);
//		}
//	}
	
//	public static class LibrarylUnderConstruction extends ProtoObjectUnderConstruction{
//		
//		public LibrarylUnderConstruction withName(String name){
//			constructDict.put(keyWithName, name);
//			return this;
//		}
//		
//		public Library please() throws ProtoObjectCreationException{
//			return LibraryImpl.newFromDictionary(this.constructDict);
//		}
//	}
//	
//	public static class ModelUnderConstruction extends ProtoObjectUnderConstruction{
//		
//		public ModelUnderConstruction withName(String name){
//			constructDict.put(keyWithName, name);
//			return this;
//		}
//		
//		public Model please() throws ProtoObjectCreationException{
//			return ModelImpl.newFromDictionary(this.constructDict);
//		}
//		
//	}
//	
//	public static class InportUnderConstruction extends ProtoObjectUnderConstruction{
//		
//		public InportUnderConstruction withName(String name){
//			constructDict.put(keyWithName, name);
//			return this;
//		}
//		
//		public InportUnderConstruction within(System parent){
//			constructDict.put(keyWithin, parent);
//			return this;
//		}
//		
//		public Inport please() throws ProtoObjectCreationException{
//			return InportImpl.newFromDictionary(this.constructDict);
//		}
//	}
//	
//	public static class OutportUnderConstruction extends ProtoObjectUnderConstruction{
//		
//		public OutportUnderConstruction withName(String name){
//			constructDict.put(keyWithName, name);
//			return this;
//		}
//		
//		public OutportUnderConstruction within(System parent){
//			constructDict.put(keyWithin, parent);
//			return this;
//		}		
//		
//		public Outport please() throws ProtoObjectCreationException{
//			return OutportImpl.newFromDictionary(this.constructDict);
//		}
//	}
//	
//	public static class SystemUnderConstruction extends ProtoObjectUnderConstruction{		
//		
//		public SystemUnderConstruction withName(String name){
//			constructDict.put(keyWithName, name);
//			return this;
//		}
//		
//		public SystemUnderConstruction within(System parent){
//			constructDict.put(keyWithin, parent);
//			return this;
//		}
//		
//		public SystemUnderConstruction within(Model parent){
//			constructDict.put(keyWithin, parent);
//			return this;
//		}
//		
//		public SystemUnderConstruction within(Library parent){
//			constructDict.put(keyWithin, parent);
//			return this;
//		}
//		
//		public System please() throws ProtoObjectCreationException{
//			return SystemImpl.newFromDictionary(this.constructDict);
//		}
//	}
//	
//	public static class SysRefUnderConstruction extends ProtoObjectUnderConstruction{
//		
//		public SysRefUnderConstruction withName(String name){
//			constructDict.put(keyWithName, name);
//			return this;
//		}
//
//		public SysRefUnderConstruction within(System parent){
//			constructDict.put(keyWithin, parent);
//			return this;
//		}
//		
//		public SysRefUnderConstruction within(Model parent){
//			constructDict.put(keyWithin, parent);
//			return this;
//		}
//		
//		public SysRefUnderConstruction targeting(System target){
//			constructDict.put(keyTargeting, target);
//			return this;
//		}
//		
//		public SystemReference please() throws ProtoObjectCreationException{
//			return SystemReferenceImpl.newFromDictionary(this.constructDict);
//		}
//	}
	
	

//	public static GainBlockUnderConstruction createGainBlock() {
//		return new GainBlockUnderConstruction();	
//	}
//	
//	public static LibrarylUnderConstruction createLibrary() {
//		return new LibrarylUnderConstruction();	
//	}
//	
//	public static InportUnderConstruction createInport() {
//		return new InportUnderConstruction();	
//	}
//	
//	public static OutportUnderConstruction createOutport() {
//		return new OutportUnderConstruction();	
//	}
//	
//	public static LineUnderConstruction createLine() {
//		return new LineUnderConstruction();	
//	}
//	
//	public static SystemUnderConstruction createSystem() {
//		return new SystemUnderConstruction();	
//	}
//	
//	public static SysRefUnderConstruction createSystemReference() {
//		return new SysRefUnderConstruction();	
//	}
//	
//	public static ModelUnderConstruction createModel() {
//		return new ModelUnderConstruction();	
//	}
}
