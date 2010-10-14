package SimulinkOOAPI.impl;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;

public class IdentityImplTest {

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

}
