package se.kth.md.SimulinkOOAPI.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

public class IdentityTest {
	
	Identity identity = new Identity();

	@Test
	public void testGetUids() throws Exception {
		int ARRAY_SIZE = 100;

		ArrayList<Identity> identityList = new ArrayList<Identity>(
				ARRAY_SIZE);
		ArrayList<String> uuidCheckList = new ArrayList<String>(ARRAY_SIZE);

		for (int i = 0; i < ARRAY_SIZE; i++) {
			Identity identity = new Identity();
			assertNotNull(identity.getUuid());
			identityList.add(identity);
		}
		for (Identity identity : identityList) {
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

}
