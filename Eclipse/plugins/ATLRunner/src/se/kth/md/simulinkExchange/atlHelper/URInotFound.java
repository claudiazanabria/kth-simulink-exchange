/**************************************************************************
 * Copyright (c) 2010 KTH, Mechatronics group and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0,
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: KTH, Mechatronics group
 **************************************************************************/

/**
 * 
 */
package se.kth.md.simulinkExchange.atlHelper;

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
