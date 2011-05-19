/**
 * 
 */
package se.kth.md.simulinkExchange.atl;

import org.eclipse.emf.common.util.URI;

/**
 * @author alesch
 *
 */
public class URInotFound extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 503725591392075978L;
	
	private URI wrongURI;

	public URInotFound(URI wrongURI) {
		this.wrongURI = wrongURI;
	}
	
	public String toString() {
		return String.format("Exception, URI not found: %s", wrongURI);		
	}
}
