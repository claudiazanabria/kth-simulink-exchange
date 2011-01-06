package se.kth.md.SimulinkOOAPI.impl;


import java.util.HashMap;
import java.util.Map;

import se.kth.md.SimulinkOOAPI.GainBlock;
import se.kth.md.SimulinkOOAPI.Inport;
import se.kth.md.SimulinkOOAPI.Library;
import se.kth.md.SimulinkOOAPI.Line;
import se.kth.md.SimulinkOOAPI.Model;
import se.kth.md.SimulinkOOAPI.Outport;
import se.kth.md.SimulinkOOAPI.System;
import se.kth.md.SimulinkOOAPI.SystemReference;
import se.kth.md.SimulinkOOAPI.exceptions.ProtoObjectCreationException;

/**
 * The Simulink model factory  
 */
public class FactoryImpl {
	
	/**
	 * Returns new instance of GainBlock with the given name, with the given gain, contains within the given system.
	 */	
	public static GainBlock newGainBlockNamedWithinWithGain(String name, System parent, int gain) throws ProtoObjectCreationException {		
		return GainBlockImpl.newNamedWithinWithGain(name, parent, gain);
	}
	
	/**
	 * Returns new instance of GainBlock with the given name, with the given gain, contains within the given model.
	 */	
	public static GainBlock newGainBlockNamedWithinWithGain(String name, Model parent, int gain) throws ProtoObjectCreationException {		
		return GainBlockImpl.newNamedWithinWithGain(name, parent, gain);
	}
	
	/**
	 * Returns new instance of GainBlock with the given name, with the given gain, contains within the given library.
	 */	
	public static GainBlock newGainBlockNamedWithinWithGain(String name, Library parent, int gain) throws ProtoObjectCreationException {		
		return GainBlockImpl.newNamedWithinWithGain(name, parent, gain);
	}

	/**
	 * Returns new Library instance with the given name.
	 */
	public static Library newLibraryNamed(String name) throws ProtoObjectCreationException {
		return LibraryImpl.newNamed(name);
	}

	/**
	 * Returns new instance of Line with the given name within the given model between the inport and the outport.
	 */
	public static Line newLineNameWithinFromTo(String name, Model parent, Outport source, Inport destination) throws ProtoObjectCreationException {		
		return LineImpl.newNamedWithinFromTo(name, parent, source, destination);
	}
	
	/**
	 * Returns new instance of Line with the given name within the given system between the inport and the outport.
	 */
	public static Line newLineNameWithinFromTo(String name, System parent, Outport source, Inport destination) throws ProtoObjectCreationException {		
		return LineImpl.newNamedWithinFromTo(name, parent, source, destination);
	}

	/**
	 * Returns new instance of Inport with the given name within the given system	 
	 */	
	public static Inport newInportNamedWithin(String name, System parent) throws ProtoObjectCreationException {		
		return InportImpl.newNamedWithin(name, parent);
	}

	/**
	 * Returns new instance of Outport with the given name within the given system	 
	 */	
	public static Outport newOutportNamedWithin(String name, System parent) throws ProtoObjectCreationException {
		return OutportImpl.newNamedWithin(name, parent);
	}

	/**
	 * Returns new Model instance with the given name.
	 */
	public static Model newModelNamed(String name) throws ProtoObjectCreationException {		
		return ModelImpl.newNamed(name);
	}

	/**
	 * Returns new instance of System with the given name within the given model. 
	 */
	public static System newSystemNamedWithin(String name, Model parent) throws ProtoObjectCreationException {		
		return SystemImpl.newNamedWithin(name, parent);
	}
	
	/**
	 * Returns new instance of System with the given name within the given system. 
	 */
	public static System newSystemNamedWithin(String name, System parent) throws ProtoObjectCreationException {		
		return SystemImpl.newNamedWithin(name, parent);
	}
	
	/**
	 * Returns new instance of System with the given name within the given library. 
	 */
	public static System newSystemNamedWithin(String name, Library parent) throws ProtoObjectCreationException {		
		return SystemImpl.newNamedWithin(name, parent);
	}

	/**
	 * Returns new instance of SystemReference with the given name, within the
	 * given model, targeting to the given system
	 */
	public static SystemReference newSystemReferemceNamedWithinTargeting(
			String name, Model parent, System target)
			throws ProtoObjectCreationException {
		return SystemReferenceImpl.newNamedWithinTargeting(name, parent, target);
	}

	/**
	 * Returns new instance of SystemReference with the given name, within the
	 * given system, targeting to the given system
	 */
	public static SystemReference newSystemReferemceNamedWithinTargeting(
			String name, System parent, System target)
			throws ProtoObjectCreationException {
		return SystemReferenceImpl.newNamedWithinTargeting(name, parent, target);
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
		
		public Builder within(Model parent){
			constructDict.put(keyWithin, parent);
			return this;
		}
		
		public Builder within(System parent){
			constructDict.put(keyWithin, parent);
			return this;
		}
		
		public Builder within(Library parent){
			constructDict.put(keyWithin, parent);
			return this;
		}
		
		public Builder from(Outport port){
			constructDict.put(keyFrom, port);
			return this;
		}
		
		public Builder to(Inport port){
			constructDict.put(keyTo, port);
			return this;
		}
		
		public Builder targeting(System target){
			constructDict.put(keyTargeting, target);
			return this;
		}		
		
	    public GainBlock createGainBlock() throws ProtoObjectCreationException {
			return GainBlockImpl.newFromDictionary(this.constructDict);
		}		
		
		public Library createLibrary() throws ProtoObjectCreationException {
			return LibraryImpl.newFromDictionary(this.constructDict);
		}
		
		public Line createLine() throws ProtoObjectCreationException {
			return LineImpl.newFromDictionary(this.constructDict);
		}
		
		public Inport createInport() throws ProtoObjectCreationException{
			return InportImpl.newFromDictionary(this.constructDict);	
		}
		
		public Outport createOutport() throws ProtoObjectCreationException{
			return OutportImpl.newFromDictionary(this.constructDict);	
		}
		
		public Model createModel() throws ProtoObjectCreationException {
			return ModelImpl.newFromDictionary(this.constructDict);
		}
		
		public System createSystem() throws ProtoObjectCreationException {
			return SystemImpl.newFromDictionary(this.constructDict);
		}
		
		public SystemReference createSystemReferemce() throws ProtoObjectCreationException {
			return SystemReferenceImpl.newFromDictionary(this.constructDict);
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
