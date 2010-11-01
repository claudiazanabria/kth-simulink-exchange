package SimulinkOOAPI.util;

import SimulinkOOAPI.Inport;
import SimulinkOOAPI.Line;
import SimulinkOOAPI.Model;
import SimulinkOOAPI.Outport;
import SimulinkOOAPI.SimulinkOOAPIFactory;
import SimulinkOOAPI.System;
import SimulinkOOAPI.SystemReference;
import SimulinkOOAPI.impl.InportImpl;
import SimulinkOOAPI.impl.LineImpl;
import SimulinkOOAPI.impl.ModelImpl;
import SimulinkOOAPI.impl.OutportImpl;
import SimulinkOOAPI.impl.SimulinkOOAPIFactoryImpl;
import SimulinkOOAPI.impl.SystemImpl;
import SimulinkOOAPI.impl.SystemReferenceImpl;


public class DemoModelBuilder {
	
	/**
	 * Builds York model with SimulinkOO API.	 
	 */
	public static Model buildYorkModelWithSimulinkOOAPI(){
		
		Model model = ModelImpl.newNamed("model");
		
		System rootSys = SystemImpl.newNamedWithin("rootSys", model);
		System system1 = SystemImpl.newNamedWithin("System1", model);
		System system2 = SystemImpl.newNamedWithin("System2", model);
		System primarySys = SystemImpl.newNamedWithin("Primary", model);
		System standBySys = SystemImpl.newNamedWithin("StandBy", model);
		
		SystemReferenceImpl.newNamedWithinTargeting("SysRef1", rootSys, system1);
		SystemReferenceImpl.newNamedWithinTargeting("SysRef2", rootSys, system2);
		SystemReferenceImpl.newNamedWithinTargeting("SysRef3", rootSys, primarySys);
		
		Inport system2Inport = InportImpl.newNamedWithin("sys2In", system2);
		Outport system2Outport = OutportImpl.newNamedWithin("sys2Out", system2);
		Inport primarySysInport = InportImpl.newNamedWithin("primarysysIn", primarySys);
		Outport primarySysOutport = OutportImpl.newNamedWithin("primarysysOut", primarySys);
		Inport standBySysInport1 = InportImpl.newNamedWithin("standBySysInport1", standBySys);
		Inport standBySysInport2 = InportImpl.newNamedWithin("standBySysInport2", standBySys);
		Outport standBySysOutport = OutportImpl.newNamedWithin("standBySysOutport", standBySys);
		
		LineImpl.newNamedWithinFromTo("line1", system2, system2Outport, primarySysInport);
		LineImpl.newNamedWithinFromTo("line2", system2, system2Outport, standBySysInport1);
		LineImpl.newNamedWithinFromTo("line3", system2, primarySysOutport, standBySysInport2);
		LineImpl.newNamedWithinFromTo("line4", system2, primarySysOutport, system2Inport);
		LineImpl.newNamedWithinFromTo("line5", system2, standBySysOutport, system2Inport);		
		
		return model;
	}

	
	/**
	 * Builds York model by means of pure ECore API.
	 */
	public static Model buildYorkModelWithECoreAPI(){
		
		SimulinkOOAPIFactory factory = SimulinkOOAPIFactoryImpl.init();		
		Model model = factory.createModel();
		model.getIdentity().setName("name");
		
		System rootSys = factory.createSystem();
		rootSys.getIdentity().setName("RootSystem");
		model.addChild(rootSys);
		
		System system1 = factory.createSystem();
		system1.getIdentity().setName("System1");
		model.addChild(system1);
		
		System system2 = factory.createSystem();
		system2.getIdentity().setName("System2");
		model.addChild(system2);
		
		System primarySystem = factory.createSystem();
		primarySystem.getIdentity().setName("Primary");
		model.addChild(primarySystem);
		
		System standBySystem = factory.createSystem();
		standBySystem.getIdentity().setName("StandBy");
		model.addChild(standBySystem);
		
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
		
		system2.addChild(primarySystem);
		system2.addChild(standBySystem);
		
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
