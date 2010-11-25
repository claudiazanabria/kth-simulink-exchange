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


public class CreationFactory {
	
	/**
	 * List of required parameters to create a valid gain block object
	 */
	protected static final String keyWithGain = "withGain";
	protected static final String keyWithin = "within";
	protected static final String keyWithName = "withName";
	protected static final String keyFrom = "from";	
	protected static final String keyTo = "to";
	protected static final String keyTargeting = "targeting";	

	public GainBlockUnderConstruction createGainBlock() {
		return new GainBlockUnderConstruction();	
	}
	
	public LibrarylUnderConstruction createLibrary() {
		return new LibrarylUnderConstruction();	
	}
	
	public InportUnderConstruction createInport() {
		return new InportUnderConstruction();	
	}
	
	public OutportUnderConstruction createOutport() {
		return new OutportUnderConstruction();	
	}
	
	public LineUnderConstruction createLine() {
		return new LineUnderConstruction();	
	}
	
	public SystemUnderConstruction createSystem() {
		return new SystemUnderConstruction();	
	}
	
	public SysRefUnderConstruction createSystemReference() {
		return new SysRefUnderConstruction();	
	}
	
	public ModelUnderConstruction createModel() {
		return new ModelUnderConstruction();	
	}
	
	public abstract class ProtoObjectUnderConstruction{
		Map<String, Object> constructDict = new HashMap<String, Object>();		
		
		protected Map<String, Object> getConstructDict() {
			return constructDict;
		}
	}	
	
	public class GainBlockUnderConstruction extends ProtoObjectUnderConstruction{		
		
		public GainBlockUnderConstruction withGain(int gain){
			this.constructDict.put(keyWithGain, gain);
			return this;
		}
		
		public GainBlockUnderConstruction withName(String name){
			constructDict.put(keyWithName, name);
			return this;
		}		
		
		public GainBlockUnderConstruction within(System parent){
			constructDict.put(keyWithin, parent);
			return this;
		}
		
		public GainBlockUnderConstruction within(Library parent){
			constructDict.put(keyWithin, parent);
			return this;
		}
		
		public GainBlock please() throws ProtoObjectCreationException{
			return GainBlockImpl.newFromDictionary(this.constructDict);
		}
	}
	
	
	public class LineUnderConstruction extends ProtoObjectUnderConstruction{

		public LineUnderConstruction from(Outport port){
			constructDict.put(keyFrom, port);
			return this;
		}
		
		public LineUnderConstruction to(Inport port){
			constructDict.put(keyTo, port);
			return this;
		}
		
		public LineUnderConstruction within(System parent){
			constructDict.put(keyWithin, parent);
			return this;
		}
		
		public LineUnderConstruction within(Model parent){
			constructDict.put(keyWithin, parent);
			return this;
		}
		
		public LineUnderConstruction withName(String name){
			constructDict.put(keyWithName, name);
			return this;
		}	
		
		public Line please() throws ProtoObjectCreationException{
			return LineImpl.newFromDictionary(this.constructDict);
		}
	}
	
	public class LibrarylUnderConstruction extends ProtoObjectUnderConstruction{
		
		public LibrarylUnderConstruction withName(String name){
			constructDict.put(keyWithName, name);
			return this;
		}
		
		public Library please() throws ProtoObjectCreationException{
			return LibraryImpl.newFromDictionary(this.constructDict);
		}
	}
	
	public class ModelUnderConstruction extends ProtoObjectUnderConstruction{
		
		public ModelUnderConstruction withName(String name){
			constructDict.put(keyWithName, name);
			return this;
		}
		
		public Model please() throws ProtoObjectCreationException{
			return ModelImpl.newFromDictionary(this.constructDict);
		}
		
	}
	
	public class InportUnderConstruction extends ProtoObjectUnderConstruction{
		
		public InportUnderConstruction withName(String name){
			constructDict.put(keyWithName, name);
			return this;
		}
		
		public InportUnderConstruction within(System parent){
			constructDict.put(keyWithin, parent);
			return this;
		}
		
		public Inport please() throws ProtoObjectCreationException{
			return InportImpl.newFromDictionary(this.constructDict);
		}
	}
	
	public class OutportUnderConstruction extends ProtoObjectUnderConstruction{
		
		public OutportUnderConstruction withName(String name){
			constructDict.put(keyWithName, name);
			return this;
		}
		
		public OutportUnderConstruction within(System parent){
			constructDict.put(keyWithin, parent);
			return this;
		}		
		
		public Outport please() throws ProtoObjectCreationException{
			return OutportImpl.newFromDictionary(this.constructDict);
		}
	}
	
	public class SystemUnderConstruction extends ProtoObjectUnderConstruction{		
		
		public SystemUnderConstruction withName(String name){
			constructDict.put(keyWithName, name);
			return this;
		}
		
		public SystemUnderConstruction within(System parent){
			constructDict.put(keyWithin, parent);
			return this;
		}
		
		public SystemUnderConstruction within(Model parent){
			constructDict.put(keyWithin, parent);
			return this;
		}
		
		public SystemUnderConstruction within(Library parent){
			constructDict.put(keyWithin, parent);
			return this;
		}
		
		public System please() throws ProtoObjectCreationException{
			return SystemImpl.newFromDictionary(this.constructDict);
		}
	}
	
	public class SysRefUnderConstruction extends ProtoObjectUnderConstruction{
		
		public SysRefUnderConstruction withName(String name){
			constructDict.put(keyWithName, name);
			return this;
		}

		public SysRefUnderConstruction within(System parent){
			constructDict.put(keyWithin, parent);
			return this;
		}
		
		public SysRefUnderConstruction within(Model parent){
			constructDict.put(keyWithin, parent);
			return this;
		}
		
		public SysRefUnderConstruction targeting(System target){
			constructDict.put(keyTargeting, target);
			return this;
		}
		
		public SystemReference please() throws ProtoObjectCreationException{
			return SystemReferenceImpl.newFromDictionary(this.constructDict);
		}
	}
}
