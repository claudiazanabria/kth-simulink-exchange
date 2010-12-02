package se.kth.md.SimulinkOOAPI.util;

import se.kth.md.SimulinkOOAPI.IInport;
import se.kth.md.SimulinkOOAPI.ILine;
import se.kth.md.SimulinkOOAPI.IModel;
import se.kth.md.SimulinkOOAPI.IOutport;
import se.kth.md.SimulinkOOAPI.ISimulinkOOAPIFactory;
import se.kth.md.SimulinkOOAPI.ISystem;
import se.kth.md.SimulinkOOAPI.ISystemReference;
import se.kth.md.SimulinkOOAPI.exceptions.ProtoObjectCreationException;
import se.kth.md.SimulinkOOAPI.impl.Factory;
import se.kth.md.SimulinkOOAPI.impl.SimulinkOOAPIFactory;

public class YorkModel {
	
	/**
	 * Builds York model with SimulinkOO API.	 
	 *
	 */	
	public static IModel buildWithSimulinkOOAPI() throws ProtoObjectCreationException{
		
		IModel model = Factory.newModelNamed("model");
		
		ISystem rootSys = Factory.newSystemNamedWithin("RootSystem", model);
		ISystem system1 = Factory.newSystemNamedWithin("System1", model);
		ISystem system2 = Factory.newSystemNamedWithin("System2", model);
		ISystem primarySys = Factory.newSystemNamedWithin("Primary", model);
		ISystem standBySys = Factory.newSystemNamedWithin("StandBy", model);		
		
		Factory.newSystemReferemceNamedWithinTargeting("SysRef1", rootSys, system1);
		Factory.newSystemReferemceNamedWithinTargeting("SysRef2", rootSys, system2);
		Factory.newSystemReferemceNamedWithinTargeting("SysRef3", rootSys, primarySys);
		
		IInport system2Inport = Factory.newInportNamedWithin("sys2In", system2);
		IOutport system2Outport = Factory.newOutportNamedWithin("sys2Out", system2);
		IInport primarySysInport = Factory.newInportNamedWithin("primarysysIn", primarySys);
		IOutport primarySysOutport = Factory.newOutportNamedWithin("primarysysOut", primarySys);
		IInport standBySysInport1 = Factory.newInportNamedWithin("standBySysInport1", standBySys);
		IInport standBySysInport2 = Factory.newInportNamedWithin("standBySysInport2", standBySys);
		IOutport standBySysOutport = Factory.newOutportNamedWithin("standBySysOutport", standBySys);
		
		Factory.newLineNameWithinFromTo("line1", system2, system2Outport, primarySysInport);
		Factory.newLineNameWithinFromTo("line2", system2, system2Outport, standBySysInport1);
		Factory.newLineNameWithinFromTo("line3", system2, primarySysOutport, standBySysInport2);
		Factory.newLineNameWithinFromTo("line4", system2, primarySysOutport, system2Inport);
		Factory.newLineNameWithinFromTo("line5", system2, standBySysOutport, system2Inport);
		
		return model;
		
//		IModel model = new Factory.Builder().named("model").createModel();
//		
//		ISystem rootSys = new Factory.Builder().within(model).named("RootSystem").createSystem();
//		ISystem system1 = new Factory.Builder().within(model).named("System1").createSystem();
//		ISystem system2 = new Factory.Builder().within(model).named("System2").createSystem();
//		ISystem primarySys = new Factory.Builder().within(model).named("Primary").createSystem();		
//		ISystem standBySys = new Factory.Builder().within(model).named("StandBy").createSystem();
//		
//		new Factory.Builder().within(rootSys).targeting(system1).named("SysRef1").createSystemReferemce();
//		new Factory.Builder().within(rootSys).targeting(system2).named("SysRef2").createSystemReferemce();
//		new Factory.Builder().within(rootSys).targeting(primarySys).named("SysRef3").createSystemReferemce();		
//		
//		IInport system2Inport = new Factory.Builder().within(system2).named("sys2In").createInport();
//		IOutport system2Outport = new Factory.Builder().within(system2).named("sys2Out").createOutport();
//		IInport primarySysInport = new Factory.Builder().within(primarySys).named("primarysysIn").createInport();
//		IOutport primarySysOutport = new Factory.Builder().within(primarySys).named("primarysysOut").createOutport();
//		IInport standBySysInport1 = new Factory.Builder().within(standBySys).named("standBySysInport1").createInport();
//		IInport standBySysInport2 = new Factory.Builder().within(standBySys).named("standBySysInport2").createInport();
//		IOutport standBySysOutport = new Factory.Builder().within(standBySys).named("standBySysOutport").createOutport();
//		
//		new Factory.Builder().within(system2).from(system2Outport).to(primarySysInport).named("line1").createLine();
//		new Factory.Builder().within(system2).from(system2Outport).to(standBySysInport1).named("line2").createLine();
//		new Factory.Builder().within(system2).from(primarySysOutport).to(standBySysInport2).named("line3").createLine();
//		new Factory.Builder().within(system2).from(primarySysOutport).to(system2Inport).named("line4").createLine();
//		new Factory.Builder().within(system2).from(standBySysOutport).to(system2Inport).named("line5").createLine();
//		
//		return model;
	}

	
	/**
	 * Builds York model by means of pure ECore API.
	 */
	public static IModel buildWithECoreAPI(){
		
		ISimulinkOOAPIFactory factory = SimulinkOOAPIFactory.init();		
		IModel model = factory.createModel();
		model.getIdentity().setName("model");
		
		ISystem rootSys = factory.createSystem();
		rootSys.getIdentity().setName("RootSystem");
		model.addChild(rootSys);
		rootSys.setParent(model);
		
		ISystem system1 = factory.createSystem();
		system1.getIdentity().setName("System1");
		model.addChild(system1);
		system1.setParent(model);
		
		ISystem system2 = factory.createSystem();
		system2.getIdentity().setName("System2");
		model.addChild(system2);
		system2.setParent(model);
		
		ISystem primarySystem = factory.createSystem();
		primarySystem.getIdentity().setName("Primary");
		model.addChild(primarySystem);
		primarySystem.setParent(model);
		
		ISystem standBySystem = factory.createSystem();
		standBySystem.getIdentity().setName("StandBy");
		model.addChild(standBySystem);
		standBySystem.setParent(model);
		
		ISystemReference sysRef1 = factory.createSystemReference();
		sysRef1.getIdentity().setName("SysRef1");
		sysRef1.setTarget(system1);
		rootSys.addChild(sysRef1);
		
		ISystemReference sysRef2 = factory.createSystemReference();
		sysRef2.getIdentity().setName("SysRef2");
		sysRef2.setTarget(system2);
		rootSys.addChild(sysRef2);
		
		ISystemReference sysRef3 = factory.createSystemReference();
		sysRef3.getIdentity().setName("SysRef3");
		sysRef3.setTarget(primarySystem);
		rootSys.addChild(sysRef3);
		
//		system2.addChild(primarySystem);
//		primarySystem.setParent(system2);
//		system2.addChild(standBySystem);
//		standBySystem.setParent(system2);
//		
		IInport system2Inport = factory.createInport();
		system2Inport.getIdentity().setName("sys2In");
		system2.addChild(system2Inport);		
		IOutport system2Outport = factory.createOutport();
		system2Outport.getIdentity().setName("sys2Out");
		system2.addChild(system2Outport);
		IInport primarySysInport = factory.createInport();
		primarySysInport.getIdentity().setName("primarysysIn");
		primarySystem.addChild(primarySysInport);
		IOutport primarySysOutport = factory.createOutport();
		primarySysOutport.getIdentity().setName("primarysysOut");
		primarySystem.addChild(primarySysOutport);		
		IInport standBySysInport1 = factory.createInport();
		standBySysInport1.getIdentity().setName("standBySysInport1");
		standBySystem.addChild(standBySysInport1);
		IInport standBySysInport2 = factory.createInport();
		standBySysInport1.getIdentity().setName("standBySysInport2");
		standBySystem.addChild(standBySysInport2);		
		IOutport standBySysOutport = factory.createOutport();
		standBySysOutport.getIdentity().setName("standBySysOutport");
		standBySystem.addChild(standBySysOutport);
		
		
		ILine line1 = factory.createLine();
		line1.getIdentity().setName("line1");
		line1.setSource(system2Outport);
		line1.setDestination(primarySysInport);
		system2.addChild(line1);
		
		ILine line2 = factory.createLine();
		line2.getIdentity().setName("line2");
		line2.setSource(system2Outport);
		line2.setDestination(standBySysInport1);
		system2.addChild(line2);
		
		ILine line3 = factory.createLine();
		line3.getIdentity().setName("line3");
		line3.setSource(primarySysOutport);
		line3.setDestination(standBySysInport2);
		system2.addChild(line3);
		
		ILine line4 = factory.createLine();
		line4.getIdentity().setName("line4");
		line4.setSource(primarySysOutport);
		line4.setDestination(system2Inport);
		system2.addChild(line4);
		
		ILine line5 = factory.createLine();
		line5.getIdentity().setName("line5");
		line5.setSource(standBySysOutport);
		line5.setDestination(system2Inport);
		system2.addChild(line5);
		
		return model;
	}
	
	
}
