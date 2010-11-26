package SimulinkOOAPI.impl;


import java.util.HashMap;
import java.util.Map;

import SimulinkOOAPI.GainBlock;
import SimulinkOOAPI.Inport;
import SimulinkOOAPI.Library;
import SimulinkOOAPI.Line;
import SimulinkOOAPI.Model;
import SimulinkOOAPI.Outport;
import SimulinkOOAPI.System;
import SimulinkOOAPI.SystemReference;


public class Factory {
	
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
	public static class Builder{
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
