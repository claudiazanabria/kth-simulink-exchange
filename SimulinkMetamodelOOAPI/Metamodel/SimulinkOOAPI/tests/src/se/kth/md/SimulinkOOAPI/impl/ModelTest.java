package se.kth.md.SimulinkOOAPI.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import se.kth.md.SimulinkOOAPI.IInport;
import se.kth.md.SimulinkOOAPI.IModel;
import se.kth.md.SimulinkOOAPI.IOutport;
import se.kth.md.SimulinkOOAPI.IProtoObject;
import se.kth.md.SimulinkOOAPI.ISystem;
import se.kth.md.SimulinkOOAPI.exceptions.AddChildException;
import se.kth.md.SimulinkOOAPI.exceptions.ProtoObjectCreationException;
import se.kth.md.SimulinkOOAPI.util.YorkModel;

@RunWith(JMock.class)
public class ModelTest {
	
	Mockery context = new JUnit4Mockery();	
	ISystem systemMock = context.mock(ISystem.class);	
	IInport inportMock = context.mock(IInport.class);
	IOutport outportMock = context.mock(IOutport.class);
    IModel model;  
    String testSystem1Uuid, testSystem2Uuid;
	
	@Before
	public void setUp() throws ProtoObjectCreationException{		
		model = Model.newNamed("model");
		assertEquals("model", model.getName());
		
		ISystem sys1 = System.newNamedWithin("sys1", model);
		ISystem sys2 = System.newNamedWithin("sys2", model);
		testSystem1Uuid = sys1.getUuid();
		testSystem2Uuid = sys2.getUuid();
	}
	
	//Incorrect test! Default constructor should be allowed in order not to break emf core api. 
	/*
	@Test
	public void testDefaultConstructorIsNotAllowed(){
		try{
			new ModelImpl();
			//if constructor was called successfully, the test has not passed
			throw new AssertionFailedError();
		}catch(UnsupportedOperationException e){
			//test passed
		}
	}*/	
	
	@Test	
	public void testAddChild() throws ProtoObjectCreationException, AddChildException{
		context.checking(new Expectations() {{
			ignoring(systemMock);			    
		}});
		
		assertEquals(2, model.getNumberOfChildren());
		model.addChild(Factory.newSystemNamedWithin("sys1", systemMock));
		assertEquals(3, model.getNumberOfChildren());
	}
	
	protected void testAddWrongChild(IProtoObject child) throws AddChildException{
		boolean passed = false;
		try{
			model.addChild(child);
		}catch(AddChildException e){
			passed = true;
		}
		assertTrue(passed);
	}	
	
	@Test
	public void testAddLibrary() throws ProtoObjectCreationException, AddChildException{
		testAddWrongChild(Factory.newLibraryNamed("library"));		
	}
	
	@Test
	public void testAddPort() throws ProtoObjectCreationException, AddChildException{
		context.checking(new Expectations() {{
			ignoring(systemMock);
		}});
		
		testAddWrongChild(Factory.newInportNamedWithin("inport", systemMock));
	}
	
	@Test	
	public void testGetChildrenOfTypeLine() throws ProtoObjectCreationException{
		context.checking(new Expectations() {{
			atLeast(1).of(inportMock).getParent();
				will(returnValue(systemMock));
			atLeast(1).of(outportMock).getParent();
				will(returnValue(systemMock));
			
			ignoring(systemMock);			
		}});
		
		Factory.newLineNameWithinFromTo("line", model, outportMock, inportMock);		
		assertEquals(1, model.getChildrenOfTypeLine().size());
	}
	
	@Test
	public void testGetChildrenOfTypeSystem(){
		assertEquals(2, model.getChildrenOfTypeSystem().size());
	}
	
	@Test
	public void testGetChildrenOfTypeGainBlock() throws ProtoObjectCreationException{
		GainBlock.newNamedWithinWithGain("gb1", model, 1);
		GainBlock.newNamedWithinWithGain("gb2", model, 1);
		GainBlock.newNamedWithinWithGain("gb3", model, 1);
		assertEquals(3, model.getChildrenOfTypeGainBlock().size());
	}
	
	@Test
	public void testChildWithName(){
		assertNotNull(model.childWith("sys1"));
		assertNotNull(model.childWith("sys2"));
	}
	
	@Test
	public void testChildWithUuid(){
		assertNotNull(model.childWith(testSystem1Uuid));
		assertNotNull(model.childWith(testSystem2Uuid));
	}
	
	@Test
	public void testNoChildWithName(){
		assertTrue(model.childWith("somenameOrUuid") == null);		
	}
	
	@Test
	public void testSearchInModel() throws Exception{
		IModel york = YorkModel.buildWithSimulinkOOAPI();
		assertNotNull(york.searchInModel("RootSystem"));		
		assertNotNull(york.searchInModel("System1"));
		assertNull(york.searchInModel("RootSys"));
		assertEquals(york, york.searchInModel("model"));
	}
	

}
