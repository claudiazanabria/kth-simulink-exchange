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
		
		private IProtoObject childWith(String name, IContainer container){			
			if (container.childWith(name)!=null)
				return container.childWith(name);
			
			for (IProtoObject child: container.getAllChildren()){
				if (child instanceof IContainer){
					return childWith(name, (IContainer) child);
				}
			}
			return null;
		}
		
		@Override
		public void requestArrived(RequestEvent event) {
			String result = "Not Found";			
			HashMap map = (HashMap) event.request.getQuery();
			
			if (map.containsKey("name")){
				String name = (String) map.get("name");
				if (name.equals(simulinkModel.getName()))
					result = simulinkModel.getUuid();
				else{
					IProtoObject child = childWith(name, simulinkModel);
					if (child != null){
						result = child.getUuid();
					}
				}
			}else if (map.containsKey("uuid")){
				String uuid = (String) map.get("uuid");
				if (uuid.equals(simulinkModel.getUuid()))
					result = simulinkModel.getName();
				else{
					IProtoObject child = childWith(uuid, simulinkModel);
					if (child != null){
						result = child.getName();
					}
				}
			}
			
			event.request.setAnswer(result);
			event.request.notifyServerDataReady();		
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
