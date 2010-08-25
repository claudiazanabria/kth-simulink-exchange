package se.kth.md.simulinkExchange;

import java.io.IOException;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.ui.statushandlers.StatusManager;

public class PluginServices {

	static Activator plugin = Activator.getDefault();
	
	public static URI lookUpAbsolutePathWithinPlugin(String relativePath) {
		URI absolutePath = null;
		try {
			absolutePath = plugin.locateFile( relativePath );
		} catch (IOException e) {
			plugin.log("Internal error: ATL source not bundled within plugin.", Status.ERROR, e);
			Status status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, "ATL source not found. See Error log for details.");
			StatusManager.getManager().handle(status, StatusManager.SHOW);
		}
		return absolutePath;
	}

}
