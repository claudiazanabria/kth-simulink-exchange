package se.kth.md.simulinkExchange.modelManagement.east;

//import se.kth.md.simulinkExchange.simulink.SimulinkModelManager;

import org.eclipse.emf.common.util.URI;
//import org.junit.Test;

import se.kth.md.simulinkExchange.modelManagement.east.EastModelManager;
import se.kth.md.simulinkExchange.modelManagement.exceptions.InvalidModelException;

/**
 * Test cases for EastModelManager.
 * @author alesch
 *
 */
public class EastModelManagerTest {

	private String modelPath 	= "../ATLtrafos/testFiles/MyEASTModel1.uml";
	private URI modelURI 		= URI.createFileURI(modelPath);

	public void testValid() throws InvalidModelException {
		//SimulinkModelManager smm = new SimulinkModelManager( modelURI );
		EastModelManager mm = new EastModelManager( modelURI );
		mm.loadIt();
		mm.validateIt();
	}

	public static void main(String [] args) throws InvalidModelException {
		EastModelManagerTest mm = new EastModelManagerTest();
		mm.testValid();
	}
	
/*	@Test
	public void testInitMetaModel() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFactory() {
		fail("Not yet implemented");
	}

	@Test
	public void testEastModelManager() {
		fail("Not yet implemented");
	}

	@Test
	public void testEastModelManagerString() {
		fail("Not yet implemented");
	}

	@Test
	public void testEastModelManagerURI() {
		fail("Not yet implemented");
	}
*/
}
