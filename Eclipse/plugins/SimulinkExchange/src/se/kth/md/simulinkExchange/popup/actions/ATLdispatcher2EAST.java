/**
 * 
 */
package se.kth.md.simulinkExchange.popup.actions;

import org.eclipse.jface.action.IAction;

/**
 * @author alesch
 *
 */
public class ATLdispatcher2EAST extends ATLdispatcher {

	/* (non-Javadoc)
	 * @see se.kth.md.simulinkExchange.popup.actions.ATLdispatcher#run(org.eclipse.jface.action.IAction)
	 */
	@Override
	public void run(IAction action) {
		ATLjob aJob = new ATLjobSimulink2East( this.selectedFilename() );
		aJob.setUser(true);
		aJob.schedule();		
	}

}
