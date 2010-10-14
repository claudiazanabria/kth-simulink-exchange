package SimulinkOOAPI.util;

import SimulinkOOAPI.Model;
import SimulinkOOAPI.Port;
import SimulinkOOAPI.SimulinkOOAPIFactory;
import SimulinkOOAPI.SystemReference;
import SimulinkOOAPI.impl.SimulinkOOAPIFactoryImpl;


public class DemoModelBuilder {
	
	/**
	 * TODO: javadoc
	 * @return
	 */
	public static Model buildYourkModel(){
		//TODO: pass names to the constructor
		
		SimulinkOOAPIFactory factory = SimulinkOOAPIFactoryImpl.init();
		Model model = factory.createModel();
		
		SimulinkOOAPI.System rootSys = factory.createSystem();
		rootSys.getIdentity().setName("RootSystem");
		model.addChild(rootSys);
		
		SimulinkOOAPI.System system1 = factory.createSystem();
		system1.getIdentity().setName("System1");
		model.addChild(system1);
		
		SimulinkOOAPI.System system2 = factory.createSystem();
		system2.getIdentity().setName("System2");
		model.addChild(system2);
		
		SimulinkOOAPI.System primarySystem = factory.createSystem();
		primarySystem.getIdentity().setName("Primary");
		model.addChild(primarySystem);
		
		SimulinkOOAPI.System standBySystem = factory.createSystem();
		standBySystem.getIdentity().setName("StandBy");
		model.addChild(standBySystem);
		
		SystemReference sysRef1 = factory.createSystemReference(system1);
		sysRef1.getIdentity().setName("SysRef1");
		rootSys.addChild(sysRef1);
		
		SystemReference sysRef2 = factory.createSystemReference(system2);
		sysRef1.getIdentity().setName("SysRef2");
		rootSys.addChild(sysRef2);
		
		SystemReference sysRef3 = factory.createSystemReference(primarySystem);
		sysRef1.getIdentity().setName("SysRef3");
		rootSys.addChild(sysRef3);
		
		system2.addChild(primarySystem);
		system2.addChild(standBySystem);
		
		Port standBySystemTargetPort1 = factory.createPort();
		Port standBySystemTargetPort2 = factory.createPort();
		Port standBySystemSourcePort = factory.createPort();
		standBySystem.addChild(standBySystemTargetPort1);
		standBySystem.addChild(standBySystemTargetPort2);
		standBySystem.addChild(standBySystemSourcePort);
		
		Port primarySystemTargetPort = factory.createPort();
		Port primarySystemSourcePort = factory.createPort();
		primarySystem.addChild(primarySystemSourcePort);
		primarySystem.addChild(primarySystemTargetPort);
		
		Port system2TargetPort = factory.createPort();
		Port system2SourcePort = factory.createPort();
		system2.addChild(system2SourcePort);
		system2.addChild(system2TargetPort);
		
		system2.addChild(factory.createLine(system2TargetPort, primarySystemTargetPort));
		system2.addChild(factory.createLine(system2TargetPort, standBySystemTargetPort1));
		system2.addChild(factory.createLine(primarySystemSourcePort, standBySystemTargetPort2));
		system2.addChild(factory.createLine(primarySystemSourcePort, system2SourcePort));
		system2.addChild(factory.createLine(standBySystemSourcePort, system2SourcePort));
		
		return model;
	}

}
