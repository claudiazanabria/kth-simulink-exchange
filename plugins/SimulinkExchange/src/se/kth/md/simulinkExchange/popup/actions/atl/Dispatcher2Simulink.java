/**
 * 
 */
package se.kth.md.simulinkExchange.popup.actions.atl;

import org.eclipse.jface.action.IAction;

import se.kth.md.simulinkExchange.popup.actions.Dispatcher;

/**
 * @author Alex Schenkman
 *
 */
public class Dispatcher2Simulink extends Dispatcher {

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		TheJob aJob = new TheJobEast2Simulink( this.selectedFilename() );
		aJob.setUser(true);
		aJob.schedule();		
	}

}
