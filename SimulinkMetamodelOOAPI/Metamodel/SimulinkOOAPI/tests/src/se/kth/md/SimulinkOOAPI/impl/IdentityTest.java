package se.kth.md.SimulinkOOAPI.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import se.kth.md.SimulinkOOAPI.Identity;
import se.kth.md.SimulinkOOAPI.exceptions.ProtoObjectCreationException;

public class IdentityTest {
	
	IdentityImpl identity = new IdentityImpl();

	@Test
	public void testGetUids() throws Exception {
		int ARRAY_SIZE = 100;

		ArrayList<IdentityImpl> identityList = new ArrayList<IdentityImpl>(
				ARRAY_SIZE);
		ArrayList<String> uuidCheckList = new ArrayList<String>(ARRAY_SIZE);

		for (int i = 0; i < ARRAY_SIZE; i++) {
			IdentityImpl identity = new IdentityImpl();
			assertNotNull(identity.getUuid());
			identityList.add(identity);
		}
		for (IdentityImpl identity : identityList) {
			String uuid = identity.getUuid();
			if (!uuidCheckList.contains(uuid))
				uuidCheckList.add(uuid);
			else
				throw new Exception("Equal uuids were found!");
		}
	}
	
	@Test
	public void testSetValidName(){		
		identity.setName("System");
		identity.setName("System.A");
		identity.setName("System_A-b3");
		identity.setName("System_A-b3.");
		identity.setName("A");
		identity.setName("a");
	}
	
	public void testSetNonValidName(String name){		
		boolean passed = false;
		try{
			identity.setName(name);
		}catch(IllegalArgumentException e){
			passed = true;
		}
		assertTrue(passed);	
	}
	
	@Test
	public void testNameMustNotStartWithNumbers(){		
		testSetNonValidName("23Name");
	}
	
	@Test
	public void testNameMustNotContainSpaces(){		
		testSetNonValidName("Na me");
	}
	
	@Test
	public void testNameMustNotContainSpecialSymbols(){		
		testSetNonValidName("Na@me");
		testSetNonValidName("Nme&");
	}
	
	@Test
	public void testCreateWithValidName() throws ProtoObjectCreationException{
		Identity identity = IdentityImpl.newNamed("Name");
		assertEquals("Name", identity.getName());
		assertNotNull(identity.getUuid());
	}
	
	@Test
	public void testCreateWithInvalidName() throws ProtoObjectCreationException {
		Identity identity = null;
		try{
			identity = IdentityImpl.newNamed("2Name");
			assertTrue(false); //should not reach this line
		}catch(ProtoObjectCreationException e){
			assertTrue(identity == null);
		}		
	}

}
