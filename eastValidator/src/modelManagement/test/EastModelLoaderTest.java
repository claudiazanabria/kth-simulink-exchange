package modelManagement.test;

import static org.junit.Assert.*;

import modelManagement.EastModelLoader;
import modelManagement.exceptions.InvalidModelException;
import modelManagement.exceptions.InvalidURIException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;

import org.junit.Test;
import org.junit.runner.RunWith;

import ch.unibe.jexample.JExample;
import ch.unibe.jexample.Given;

@RunWith(JExample.class)

public class EastModelLoaderTest {



	private String modelPath = "testFiles/simpleEAST.uml";
	private URI model = URI.createFileURI(modelPath);

	@Test
	public EastModelLoader testInstanceCreation() 
	throws InvalidURIException {

		EastModelLoader aModelLoader = new EastModelLoader(model);
		return aModelLoader;
	}

	@Test
	@Given("#testInstanceCreation")
	public EastModelLoader testMetaModelRegistration(
			EastModelLoader aModelLoader) {

		String nsURI = aModelLoader.getNsURI();
		Registry globalRegistry = EPackage.Registry.INSTANCE; 
		EPackage ePkg = globalRegistry.getEPackage(nsURI);

		// This asserts that the EAST-ADL package has been registered
		// to the global EMF registry, in standalone mode.
		assertTrue(ePkg.getName().equalsIgnoreCase("eastadl"));

		return aModelLoader;
	}


	@Test
	@Given("#testMetaModelRegistration(modelManagement.EastModelLoader)")
	public EastModelLoader testDoIt(EastModelLoader aModelLoader) 
	throws InvalidModelException {
		try {
			aModelLoader.doIt();
		}
		catch (InvalidModelException e) {
			e.dumpInvalidObjectsToConsole();
			fail("Invalid Model, see the console for details.");
		}
		return aModelLoader;
	}

	@Test
	@Given("#testDoIt(modelManagement.EastModelLoader)")
	public void testGetTopElement(EastModelLoader aModelLoader) {
		EObject top = aModelLoader.getTopElement();
		assertNotNull(top);
		assertTrue(top.eClass().getName().equalsIgnoreCase("Model"));
	}
}

