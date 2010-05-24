package se.kth.md.simulinkExchange.popup.actions;

import static org.junit.Assert.*;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ATLjobTest {

	ATLjob job;
	private IPath aPath = new Path("./resources/testFiles/demo2.uml");
	
	@Before
	public void setUp() throws Exception {
		job = new ATLjobEast2Simulink( aPath );
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
