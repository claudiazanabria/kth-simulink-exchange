/**
 * 
 */
package se.kth.md.simulinkExchange.popup.actions.atl;

import org.eclipse.jface.action.IAction;

import se.kth.md.simulinkExchange.popup.actions.Dispatcher;

/**
 * @author alesch
 *
 */
public class Dispatcher2EAST extends Dispatcher {

	/* (non-Javadoc)
	 * @see se.kth.md.simulinkExchange.popup.actions.ATLdispatcher#run(org.eclipse.jface.action.IAction)
	 */
	@Override
	public void run(IAction action) {
		TheJob aJob = new TheJobSimulink2East( this.selectedFilename() );
		aJob.setUser(true);
		aJob.schedule();		
	}

}
