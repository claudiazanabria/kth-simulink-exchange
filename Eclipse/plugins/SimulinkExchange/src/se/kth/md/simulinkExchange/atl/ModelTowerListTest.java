/**
 * 
 */
package se.kth.md.simulinkExchange.atl;

import static org.junit.Assert.*;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author alesch
 *
 */
public class ModelTowerListTest {

	private static URI aModel = URI.createFileURI("./Resource/testing/demo.uml"); 

	private static URI eastMetaModel 	= URI.createURI("http://www.papyrusuml.org/EAST-ADL2/1");
	private static URI umlMetaModel      = URI.createURI("http://www.eclipse.org/uml2/2.1.0/UML");

	private ModelTowerList mtList;
	private ModelTower mt1;
	private ModelTower mt2;
	
	/**
	 * This would be the destination part of a transformation from simulink to EAST.
	 * One output file with two meta-models.
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		mt1 = new ModelTower();
		mt2 = new ModelTower();
		mt1.setModel( aModel, "OUT1" );
		mt1.setMetaModel( eastMetaModel, "EST" );
		mt2.setModel( aModel, "OUT2");
		mt2.setMetaModel( umlMetaModel, "UML");
		mtList = new ModelTowerList();
		mtList.add( mt1 );
		mtList.add( mt2 );
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		mtList = null;
		mt1 = null;
		mt2 = null;
	}


	/**
	 * PathMap should be: "OUT" -> aModel.toString()
	 * Test method for {@link se.kth.md.simulinkExchange.atl.ModelTowerList#asPathMap()}.
	 */
	@Test
	public void testAsPathMap() {
		Map<String, String> pMap = mtList.asPathMap();
		assertTrue( pMap.size() == 4 );
		assertEquals(aModel.toString(), pMap.get("OUT1"));
		assertEquals(aModel.toString(), pMap.get("OUT2"));
		assertEquals(eastMetaModel.toString(), pMap.get("EST"));
		assertEquals(umlMetaModel.toString(), pMap.get("UML"));
	}

	/**
	 * ID Map should be "OUT1" -> "EST", "OUT2" -> "UML"
	 * Test method for {@link se.kth.md.simulinkExchange.atl.ModelTowerList#asIDMap()}.
	 */
	@Test
	public void testAsIDMap() {
		Map<String, String> idMap = mtList.asIDMap();
		assertTrue( idMap.size() == 2 );
		assertEquals("EST", idMap.get("OUT1"));
		assertEquals("UML", idMap.get("OUT2"));		
	}

	/**
	 * Handlers Map should be: "EST"->"EMF", "UML"->"EMF"
	 * Test method for {@link se.kth.md.simulinkExchange.atl.ModelTowerList#asHandlersMap()}.
	 */
	@Test
	public void testAsHandlersMap() {
		Map<String, String> hMap = mtList.asHandlersMap();
		for (String value : hMap.values()) {
			assertEquals("EMF", value);
		}
	}

}
