/**************************************************************************
 * Copyright (c) 2010 KTH, Mechatronics group and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0,
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: KTH, Mechatronics group
 **************************************************************************/

package se.kth.md.simulinkExchange;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "se.kth.md.simulinkExchange";

	// The shared instance
	private static Activator plugin;

	private static ILog log; 
	private static String symbolicName;  // = se.kth.md...

	
	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		symbolicName = this.getBundle().getSymbolicName();
		log = plugin.getLog();
		log("Plugin started", Status.OK);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		log = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given
	 * plug-in relative path
	 *
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}
	
	public void log(String message , int status ){
		log.log(new Status(status, symbolicName, message) );
	}

	public void log(String message , int status, Throwable e ){
		log.log(new Status(status, symbolicName, message, e) );
	}

	public URI locateFile(String path) throws IOException {
		Path aPath = new Path( path ); 
		URL urlWithBundleProtocol 	= FileLocator.find(this.getBundle(), aPath, Collections.EMPTY_MAP);
		if ( urlWithBundleProtocol == null ) {
			throw new FileNotFoundException( path );
		}
		URL urlWithFileProtocol 	= FileLocator.toFileURL( urlWithBundleProtocol );
		String fileURLAsString 		= urlWithFileProtocol.getFile();
		URI result = URI.createFileURI( fileURLAsString );
		return result;
	}

	public URI locateFile(URI fileURI) throws IOException {
		return locateFile( fileURI.toFileString() );		
	}

}
