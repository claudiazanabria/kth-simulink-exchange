/**
 * 
 */
package se.kth.md.simulinkExchange.popup.actions;

import org.eclipse.jface.action.IAction;

/**
 * @author Alex Schenkman
 *
 */
public class ATLdispatcher2Simulink extends ATLdispatcher {

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		ATLjob aJob = new ATLjobEast2Simulink( this.selectedFilename() );
		aJob.setUser(true);
		aJob.schedule();		
	}

}
