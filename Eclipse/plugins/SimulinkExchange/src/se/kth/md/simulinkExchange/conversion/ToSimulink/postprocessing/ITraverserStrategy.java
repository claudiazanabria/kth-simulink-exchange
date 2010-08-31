package se.kth.md.simulinkExchange.conversion.ToSimulink.postprocessing;

import Simulink.Model;
import Simulink.System;
import Simulink.SystemReference;

public interface ITraverserStrategy {
	
	public void doIt(Model model, ITraverserDelegate delegate);

	public void doIt(System system, ITraverserDelegate delegate);

	public void doIt(SystemReference systemReference, ITraverserDelegate delegate);
}