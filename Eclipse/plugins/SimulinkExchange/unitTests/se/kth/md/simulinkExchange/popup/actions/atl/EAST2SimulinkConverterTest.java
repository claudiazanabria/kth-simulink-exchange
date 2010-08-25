package se.kth.md.simulinkExchange.popup.actions.atl;


import static org.junit.Assert.*;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EAST2SimulinkConverterTest {

	IPath selectedFilename = new Path("/somefile.extentsion?");
	EAST2SimulinkConverter converter = new EAST2SimulinkConverter( selectedFilename );
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void nameIsNotEmpty() {
		assertNotNull(converter.name());
	}
}
