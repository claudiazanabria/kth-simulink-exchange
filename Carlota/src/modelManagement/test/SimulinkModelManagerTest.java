package modelManagement.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import modelManagement.exceptions.InvalidModelException;
import modelManagement.exceptions.InvalidURIException;
import modelManagement.simulink.SimulinkModelManager;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.junit.Test;
import org.junit.runner.RunWith;

import Simulink.Model;
import Simulink.SimulinkFactory;

import ch.unibe.jexample.Given;
import ch.unibe.jexample.JExample;

@RunWith(JExample.class)
public class SimulinkModelManagerTest {
	
	private String modelPath = "testWorkspace/demo.simulink";
	private URI model = URI.createFileURI(modelPath);
		
	@Test
	public SimulinkModelManager testInstanceCreation() 
		throws InvalidURIException {
		
		SimulinkModelManager aModelMgr = new SimulinkModelManager(model);
		return aModelMgr;
	}

	@Test
	@Given("#testInstanceCreation")
	public SimulinkModelManager testReplacExtension(SimulinkModelManager aModelMgr) {
		String newPath = aModelMgr.replaceExtension("test.txt", "zzz");
		assertTrue(newPath.equalsIgnoreCase("test.zzz"));
		return aModelMgr;	
	}

	@Test
	@Given("#testReplacExtension(modelManagement.simulink.SimulinkModelManager)")
	public SimulinkModelManager testExtension(SimulinkModelManager aModelMgr) {
		assertTrue(aModelMgr.getFileExtension().equalsIgnoreCase("simulink"));
		return aModelMgr;	
	}

	@Test
	@Given("#testExtension(modelManagement.simulink.SimulinkModelManager)")
	public SimulinkModelManager testMetaModelRegistration(
			SimulinkModelManager aModelMgr) {
		
		String nsURI = aModelMgr.getNsURI();
		Registry globalRegistry = EPackage.Registry.INSTANCE; 
		EPackage ePkg = globalRegistry.getEPackage(nsURI);

		// This asserts that the Simulink package has been registered
		// to the global EMF registry, in standalone mode.
		assertTrue(ePkg.getName().equalsIgnoreCase("Simulink"));
		
		return aModelMgr;
	}
	
	@Test
	@Given("#testMetaModelRegistration(modelManagement.simulink.SimulinkModelManager)")
	public SimulinkModelManager testLoadIt(SimulinkModelManager aModelMgr) 
	throws InvalidModelException {
		
		try {
			aModelMgr.LoadIt();
		}
		catch (InvalidModelException e) {
			e.dumpInvalidObjectsToConsole();
			fail("Invalid Model, see the console for details.");
		}
		return aModelMgr;
	}

	@Test
	@Given("#testLoadIt(modelManagement.simulink.SimulinkModelManager)")
	public EObject testGetTopElement(SimulinkModelManager aModelMgr) {
		EObject top = aModelMgr.getTopElement();
		assertNotNull(top);
		assertTrue(top.eClass().getName().equalsIgnoreCase("Model"));
		return top;
	}	
	
	@Test
	@Given("#testGetTopElement(modelManagement.simulink.SimulinkModelManager)")
	public void testNewModel() {
		String pathName = "testWorkspace/deleteMe.simulink";
		SimulinkModelManager modelMgr 	= new SimulinkModelManager(pathName);
		SimulinkModelManager newMgr 	= new SimulinkModelManager(pathName);
		SimulinkFactory factory = modelMgr.getFactory();
		Model model = factory.createModel();
		model.setName("Testy");
		modelMgr.setTopElement(model);
		try {
			modelMgr.saveIt();
			newMgr.LoadIt();
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
		Model newModel = (Model) newMgr.getTopElement();
		assertTrue( newModel.getName().equalsIgnoreCase(model.getName()));
	}
	
}
