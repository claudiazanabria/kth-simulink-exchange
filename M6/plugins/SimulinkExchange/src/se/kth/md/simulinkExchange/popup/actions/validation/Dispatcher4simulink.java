/**
 * 
 */
package se.kth.md.simulinkExchange.popup.actions.validation;

import org.eclipse.jface.action.IAction;

import se.kth.md.simulinkExchange.popup.actions.Dispatcher;

public class Dispatcher4simulink extends Dispatcher {

	/* (non-Javadoc)
	 * @see se.kth.md.simulinkExchange.popup.actions.Dispatcher#run(org.eclipse.jface.action.IAction)
	 */
	@Override
	public void run(IAction action) {
		TheJob aJob = new TheJob4Simulink( "Validating", this.selectedFilename() );
		aJob.setUser(true);
		aJob.schedule();		
	}

}
