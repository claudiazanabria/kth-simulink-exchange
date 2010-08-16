/**************************************************************************
 * Copyright (c) 2010 KTH, Mechatronics group and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0,
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: KTH, Mechatronics group
 **************************************************************************/

package se.kth.md.simulinkExchange.popup.actions.atl;

import static org.junit.Assert.*;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("unused")
public class TheJobTest {

	TheJob job;
	private IPath aPath = new Path("./resources/testFiles/demo2.uml");
	
	@Before
	public void setUp() throws Exception {
		job = new TheJobEast2Simulink( aPath );
	}

	@After
	public void tearDown() throws Exception {
		job = null;
	}

	@Test
	public final void testRunIProgressMonitor() {
		NullProgressMonitor monitor = new NullProgressMonitor();
		job.run(monitor);
	}

}
