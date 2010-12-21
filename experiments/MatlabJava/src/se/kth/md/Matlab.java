package se.kth.md;

import java.io.File;
import java.util.HashMap;

import se.kth.md.SimulinkOOAPI.IContainer;
import se.kth.md.SimulinkOOAPI.IModel;
import se.kth.md.SimulinkOOAPI.IProtoObject;
import se.kth.md.SimulinkOOAPI.exceptions.ProtoObjectCreationException;
import se.kth.md.SimulinkOOAPI.util.YorkModel;
import se.kth.md.oslc.Server;
import se.kth.md.oslc.Server.RequestEvent;
import se.kth.md.oslc.Server.RequestEventListener;

/***
 * This is a test class, which is playing the role of Matlab 
 *
 */
public class Matlab {
	
	private IModel simulinkModel;
	public MatlabListener listener = null;
	
	public Matlab() throws ProtoObjectCreationException{
		this.simulinkModel = YorkModel.buildWithSimulinkOOAPI();
		this.listener = new MatlabListener(simulinkModel);
	}	
	
	
	class MatlabListener implements RequestEventListener{
		IModel simulinkModel;
		
		public MatlabListener(IModel simulinkModel){
			this.simulinkModel = simulinkModel;
		}
		
		
		@Override
		public void requestArrived(RequestEvent event) {
			
			String result = "Not Found";			
			HashMap map = (HashMap) event.request.getQuery();
			String nameOrUuid = "";
			boolean searchByName = false;
			
			if (map.containsKey("name")){
				nameOrUuid = (String) map.get("name");
				searchByName = true;
			}else if (map.containsKey("uuid")){
				nameOrUuid = (String) map.get("uuid");				
			}
			
			IProtoObject child = simulinkModel.searchInModel(nameOrUuid);
			if (child != null){
				if (searchByName)
					result = child.getUuid();
				else
					result = child.getName();
			}		
			
			event.request.setAnswer(result);
			event.request.setAnswer_ready(true);					
		}
		
		
	}
	
	public static void main(String[] args) throws Exception {
		String path = new File("../OslcServer/src/se/kth/md/oslc").getCanonicalPath();		
		Server server = new Server(path);
		
		Matlab matlab = new Matlab();
		
		server.addRequestEventListener(matlab.listener);
		server.run();
	}

}
