/**
 * 
 */
package se.kth.md.simulinkExchange.atl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.eclipse.emf.common.util.URI;
import org.junit.Test;

/**
 * Obs: Tests involving the EMF registry (using variable registeredMetamodel) need to be run as
 * JUnit Plug-in Test. It takes much longer to run as a new Eclipse framework is run.
 * 
 * @author alesch
 *
 */
public class UtilsTest {

	private final URI readableFile = URI.createFileURI("./Resources/testing/demo.simulink");
	private final URI unReadableFile = URI.createFileURI("./Resources/testing/fileDoesNOTexists");
	private final URI writeableFile = URI.createFileURI("./Resources/testing/deleteme.test");
	private final URI registeredMetamodel = URI.createURI("http://www.w3.org/XML/1998/namespace");
	private final URI unRegisteredMetamodel = URI.createURI("http://myGrandMother.is.not.here");
	

	/**
	 * Test method for {@link se.kth.md.simulinkExchange.atl.Utils#isReadable(org.eclipse.emf.common.util.URI)}.
	 */
	@Test
	public void testIsReadable() {
		assertTrue(	 Utils.isReadable( readableFile ));
		assertFalse( Utils.isReadable( unReadableFile ));
	}

	/**
	 * Test method for {@link se.kth.md.simulinkExchange.atl.Utils#isWriteable(org.eclipse.emf.common.util.URI)}.
	 */
	@Test
	public void testIsWriteableOnFileCreation() {
		assertTrue( Utils.isWriteable( writeableFile ));

	}

	/**
	 * Test method for {@link se.kth.md.simulinkExchange.atl.Utils#isWriteable(org.eclipse.emf.common.util.URI)}.
	 */
	@Test
	public void testIsWriteableOnFileOverwrite() {
		assertTrue( Utils.isWriteable(readableFile));	
	}

	/**
	 * Test method for {@link se.kth.md.simulinkExchange.atl.Utils#validateReadableURI(org.eclipse.emf.common.util.URI)}.
	 * @throws URInotFound 
	 */
	@Test(expected=se.kth.md.simulinkExchange.atl.URInotFound.class)
	public void testValidateReadableURI() throws URInotFound {
		try {
			Utils.validateReadableURI( readableFile );
		} catch (URInotFound e) { fail("Should pass OK"); }
		Utils.validateReadableURI( unReadableFile );  // Should throw URInotFound
	}

	/**
	 * Test method for {@link se.kth.md.simulinkExchange.atl.Utils#validateWriteableURI(org.eclipse.emf.common.util.URI)}.
	 */
	@Test
	public void testValidateWriteableURI() {
		try {
			Utils.validateWriteableURI( writeableFile );
		} catch (URInotFound e) { fail("Should pass OK"); }
	}

	/**
	 * Test method for {@link se.kth.md.simulinkExchange.atl.Utils#validateRegisteredMetamodel(org.eclipse.emf.common.util.URI)}.
	 * @throws URInotFound 
	 */
	@Test(expected=se.kth.md.simulinkExchange.atl.URInotFound.class)
	public void testValidateRegisteredMetamodel() throws URInotFound {
		try {
			Utils.validateRegisteredMetamodel( registeredMetamodel );
		} catch (URInotFound e) { fail("If you need an initialized EMF registry run the test as JUnit Plug-in Test."); }
		Utils.validateRegisteredMetamodel( unRegisteredMetamodel );
	}

	/**
	 * Test method for {@link se.kth.md.simulinkExchange.atl.Utils#isMetamodelRegistered(org.eclipse.emf.common.util.URI)}.
	 */
	@Test
	public void testIsMetamodelRegistered() {
		assertTrue( Utils.isMetamodelRegistered( registeredMetamodel ) );
		assertFalse( Utils.isMetamodelRegistered( unRegisteredMetamodel ));
	}

}
