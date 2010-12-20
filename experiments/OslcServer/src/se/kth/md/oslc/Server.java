package se.kth.md.oslc;

import java.io.File;
import java.io.IOException;
import java.util.EventListener;
import java.util.EventObject;
import java.util.Properties;

import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.util.PythonInterpreter;

public class Server implements IServer{
	
	PyObject serverClass;
	IServer pyServer;
	
	public Server(String pathToPythonModules) {		
		
		initPythonPath(pathToPythonModules);		
    	initServerPythonClass();
		
        PyObject buildingObject = serverClass.__call__();
        pyServer =  (IServer) buildingObject.__tojava__(IServer.class);   
      
    }
	
    public Server(String pathToPythonModules, String host, int port) {
    	
    	initPythonPath(pathToPythonModules);		
    	initServerPythonClass();
        
        PyObject buildingObject = serverClass.__call__(new PyString(host), new PyInteger(port));
        pyServer =  (IServer) buildingObject.__tojava__(IServer.class);      
    }
    
    private void initServerPythonClass(){    	
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.exec("from server import ServerController");
        serverClass = interpreter.get("ServerController");
    }
	
	/**
	 * Sets python.path property of PythonInterpreter
	 * @param pathToPythonModules - path to the directory that contains bottle.py and server.py
	 */
	private void initPythonPath(String pathToPythonModules){
		Properties props = new Properties();		
		try {
			String dir = new File(pathToPythonModules).getCanonicalPath();			
			props.setProperty("python.path", dir);			
			PythonInterpreter.initialize(System.getProperties(), props,
                    new String[] {""});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run(){
		pyServer.run();
	}
	
	@Override
	public void kill() {		
		pyServer.kill();		
	}
	
	@Override
	public void addRequestEventListener(RequestEventListener listener) {
		pyServer.addRequestEventListener(listener);			
	}

	@Override
	public void removeRequestEventListener(RequestEventListener listener) {
		pyServer.addRequestEventListener(listener);		
	}	
	
	public static interface RequestEventListener extends EventListener {

		public void requestArrived(RequestEvent event);		
		
	}
	
	public static class RequestEvent extends EventObject {
		
		public IRequest request;		
		
		public IRequest getRequest() {
			return request;
		}

		public RequestEvent(Object source, IRequest request) {
			super(source);
			this.request = request;
		}	
		
		private static final long serialVersionUID = 1L;
	}
	
	public static void main(String[] args) throws Exception {
		String path = new File("./src/se/kth/md/oslc").getCanonicalPath();		
		System.out.println("Main thread; starting the server.");
		Server server = new Server(path);
		
		server.addRequestEventListener(new RequestEventListener() {
			
			@Override
			public void requestArrived(RequestEvent event) {
				event.request.setAnswer(new Integer(42));
				event.request.setAnswer_ready(true);		
				
			}
		});
		server.run();
		//System.out.println("Main thread; server running.");
		//Thread.sleep(5000);
		//System.out.println("Main thread; about to stop.");
		//server.kill();
	}

	

}
