package SimulinkOOAPI.util;

import SimulinkOOAPI.Inport;
import SimulinkOOAPI.Line;
import SimulinkOOAPI.Model;
import SimulinkOOAPI.Outport;
import SimulinkOOAPI.SimulinkOOAPIFactory;
import SimulinkOOAPI.System;
import SimulinkOOAPI.SystemReference;
import SimulinkOOAPI.impl.CreationFactory;
import SimulinkOOAPI.impl.ProtoObjectCreationException;
import SimulinkOOAPI.impl.SimulinkOOAPIFactoryImpl;


public class DemoModelBuilder {
	
	/**
	 * Builds York model with SimulinkOO API.	 
	 */
	public static Model buildYorkModelWithSimulinkOOAPI() throws ProtoObjectCreationException{
		
		CreationFactory factory = new CreationFactory();
		
		Model model = factory.createModel().withName("model").please();
		
		System rootSys = factory.createSystem().within(model).withName("RootSystem").please();
		System system1 = factory.createSystem().within(model).withName("System1").please();
		System system2 = factory.createSystem().within(model).withName("System2").please();
		System primarySys = factory.createSystem().within(model).withName("Primary").please();		
		System standBySys = factory.createSystem().within(model).withName("StandBy").please();
		
		factory.createSystemReference().within(rootSys).targeting(system1).withName("SysRef1").please();
		factory.createSystemReference().within(rootSys).targeting(system2).withName("SysRef2").please();
		factory.createSystemReference().within(rootSys).targeting(primarySys).withName("SysRef3").please();		
		
		Inport system2Inport = factory.createInport().within(system2).withName("sys2In").please();
		Outport system2Outport = factory.createOutport().within(system2).withName("sys2Out").please();
		Inport primarySysInport = factory.createInport().within(primarySys).withName("primarysysIn").please();
		Outport primarySysOutport = factory.createOutport().within(primarySys).withName("primarysysOut").please();
		Inport standBySysInport1 = factory.createInport().within(standBySys).withName("standBySysInport1").please();
		Inport standBySysInport2 = factory.createInport().within(standBySys).withName("standBySysInport2").please();
		Outport standBySysOutport = factory.createOutport().within(standBySys).withName("standBySysOutport").please();
		
		factory.createLine().within(system2).from(system2Outport).to(primarySysInport).withName("line1").please();
		factory.createLine().within(system2).from(system2Outport).to(standBySysInport1).withName("line2").please();
		factory.createLine().within(system2).from(primarySysOutport).to(standBySysInport2).withName("line3").please();
		factory.createLine().within(system2).from(primarySysOutport).to(system2Inport).withName("line4").please();
		factory.createLine().within(system2).from(standBySysOutport).to(system2Inport).withName("line5").please();
		
		return model;
	}

	
	/**
	 * Builds York model by means of pure ECore API.
	 */
	public static Model buildYorkModelWithECoreAPI(){
		
		SimulinkOOAPIFactory factory = SimulinkOOAPIFactoryImpl.init();		
		Model model = factory.createModel();
		model.getIdentity().setName("model");
		
		System rootSys = factory.createSystem();
		rootSys.getIdentity().setName("RootSystem");
		model.addChild(rootSys);
		rootSys.setParent(model);
		
		System system1 = factory.createSystem();
		system1.getIdentity().setName("System1");
		model.addChild(system1);
		system1.setParent(model);
		
		System system2 = factory.createSystem();
		system2.getIdentity().setName("System2");
		model.addChild(system2);
		system2.setParent(model);
		
		System primarySystem = factory.createSystem();
		primarySystem.getIdentity().setName("Primary");
		model.addChild(primarySystem);
		primarySystem.setParent(model);
		
		System standBySystem = factory.createSystem();
		standBySystem.getIdentity().setName("StandBy");
		model.addChild(standBySystem);
		standBySystem.setParent(model);
		
		SystemReference sysRef1 = factory.createSystemReference();
		sysRef1.getIdentity().setName("SysRef1");
		sysRef1.setTarget(system1);
		rootSys.addChild(sysRef1);
		
		SystemReference sysRef2 = factory.createSystemReference();
		sysRef2.getIdentity().setName("SysRef2");
		sysRef2.setTarget(system2);
		rootSys.addChild(sysRef2);
		
		SystemReference sysRef3 = factory.createSystemReference();
		sysRef3.getIdentity().setName("SysRef3");
		sysRef3.setTarget(primarySystem);
		rootSys.addChild(sysRef3);
		
//		system2.addChild(primarySystem);
//		primarySystem.setParent(system2);
//		system2.addChild(standBySystem);
//		standBySystem.setParent(system2);
//		
		Inport system2Inport = factory.createInport();
		system2Inport.getIdentity().setName("sys2In");
		system2.addChild(system2Inport);		
		Outport system2Outport = factory.createOutport();
		system2Outport.getIdentity().setName("sys2Out");
		system2.addChild(system2Outport);
		Inport primarySysInport = factory.createInport();
		primarySysInport.getIdentity().setName("primarysysIn");
		primarySystem.addChild(primarySysInport);
		Outport primarySysOutport = factory.createOutport();
		primarySysOutport.getIdentity().setName("primarysysOut");
		primarySystem.addChild(primarySysOutport);		
		Inport standBySysInport1 = factory.createInport();
		standBySysInport1.getIdentity().setName("standBySysInport1");
		standBySystem.addChild(standBySysInport1);
		Inport standBySysInport2 = factory.createInport();
		standBySysInport1.getIdentity().setName("standBySysInport2");
		standBySystem.addChild(standBySysInport2);		
		Outport standBySysOutport = factory.createOutport();
		standBySysOutport.getIdentity().setName("standBySysOutport");
		standBySystem.addChild(standBySysOutport);
		
		
		Line line1 = factory.createLine();
		line1.getIdentity().setName("line1");
		line1.setSource(system2Outport);
		line1.setDestination(primarySysInport);
		system2.addChild(line1);
		
		Line line2 = factory.createLine();
		line2.getIdentity().setName("line2");
		line2.setSource(system2Outport);
		line2.setDestination(standBySysInport1);
		system2.addChild(line2);
		
		Line line3 = factory.createLine();
		line3.getIdentity().setName("line3");
		line3.setSource(primarySysOutport);
		line3.setDestination(standBySysInport2);
		system2.addChild(line3);
		
		Line line4 = factory.createLine();
		line4.getIdentity().setName("line4");
		line4.setSource(primarySysOutport);
		line4.setDestination(system2Inport);
		system2.addChild(line4);
		
		Line line5 = factory.createLine();
		line5.getIdentity().setName("line5");
		line5.setSource(standBySysOutport);
		line5.setDestination(system2Inport);
		system2.addChild(line5);
		
		return model;
	}
	
	
}
