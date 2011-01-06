package se.kth.md.SimulinkOOAPI.util;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.junit.Test;

import se.kth.md.SimulinkOOAPI.IModel;
import se.kth.md.SimulinkOOAPI.IProtoObject;
import se.kth.md.SimulinkOOAPI.ISimulinkOOAPIFactory;
import se.kth.md.SimulinkOOAPI.ISimulinkOOAPIPackage;
import se.kth.md.SimulinkOOAPI.exceptions.AddChildException;
import se.kth.md.SimulinkOOAPI.exceptions.ProtoObjectCreationException;
import se.kth.md.SimulinkOOAPI.impl.SimulinkOOAPIFactory;
import se.kth.md.SimulinkOOAPI.impl.SimulinkOOAPIPackage;


public class YorkModelTest {	
	
	
	@Test
	public void testModelsCompare() throws ProtoObjectCreationException, AddChildException{		
		IModel modelA = YorkModel.buildWithECoreAPI();
		IModel modelB = YorkModel.buildWithSimulinkOOAPI();    
		//MatchModel match = EMFCompareWrapper.getMatch(modelA, modelB);
		
		assertTrue(EMFCompareWrapper.matched(modelA, modelB));		
	}
	
	@Test
	public void test() throws ProtoObjectCreationException, IOException, AddChildException{
		  //IModel model = YorkModel.buildWithSimulinkOOAPI();
		  
		  ISimulinkOOAPIPackage pack = SimulinkOOAPIPackage.eINSTANCE;
		  
		  Resource poResource = pack.eResource();
		  
		  System.out.println(poResource.getContents());
		  //poResource.getResourceSet().getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		  		  
		  final Map<String, Object> options = new HashMap<String, Object>();
		  //options.put(XMLResource.OPTION_PROCESS_DANGLING_HREF, XMLResource.OPTION_PROCESS_DANGLING_HREF_DISCARD);
		  
		  IModel model = ((SimulinkOOAPIFactory)pack.getEFactoryInstance()).createModel();
		  ByteArrayOutputStream out = new ByteArrayOutputStream();		 
		  poResource.getContents().add(model);		  
		  System.out.println(poResource.getContents());
		  poResource.save(out, null);
		  
		  System.out.println(out.toString());
		  
		  for (IProtoObject child: model.getAllChildren()){
			  //poResource.getContents().add(0, child);
			  //poResource.save(out, options);
			  
		  }
		  //poResource.getContents().add(model);
		  //poResource.save(null);
		  
		 
		  
		 // System.out.println(out.toString());
	}
	

}
