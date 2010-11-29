package se.kth.md.simulinkExchange.popup.actions.validation;

import org.eclipse.jface.action.IAction;

import se.kth.md.simulinkExchange.popup.actions.Dispatcher;

public class Dispatcher4east extends Dispatcher {

	/* (non-Javadoc)
	 * @see se.kth.md.simulinkExchange.popup.actions.Dispatcher#run(org.eclipse.jface.action.IAction)
	 */
	@Override
	public void run(IAction action) {
		TheJob aJob = new TheJob4East( "Validating", this.selectedFilename() );
		aJob.setUser(true);
		aJob.schedule();		
	}

}
