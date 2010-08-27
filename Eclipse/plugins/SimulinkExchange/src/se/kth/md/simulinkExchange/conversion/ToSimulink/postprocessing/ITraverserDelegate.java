package se.kth.md.simulinkExchange.conversion.ToSimulink.postprocessing;

import Simulink.Inport;
import Simulink.Line;
import Simulink.Model;
import Simulink.Outport;
import Simulink.System;
import Simulink.SystemReference;

public interface ITraverserDelegate {

	void doIt(SystemReference with);

	void doIt(System with);

	void doIt(Model with);

	void doIt(Inport with);

	void doIt(Outport with);

	void doIt(Line with);

}
