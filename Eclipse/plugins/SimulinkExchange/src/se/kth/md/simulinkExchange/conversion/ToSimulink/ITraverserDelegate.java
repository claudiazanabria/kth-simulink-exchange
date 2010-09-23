package se.kth.md.simulinkExchange.conversion.ToSimulink;

import Simulink.Inport;
import Simulink.Line;
import Simulink.Model;
import Simulink.Outport;
import Simulink.System;
import Simulink.SystemReference;

public interface ITraverserDelegate {

	void doIt(SystemReference sysRef);

	void doIt(System system);

	void doIt(Model model);

	void doIt(Inport inport);

	void doIt(Outport outport);

	void doIt(Line line);
}
