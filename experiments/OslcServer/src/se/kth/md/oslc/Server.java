package se.kth.md.oslc;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

public class Server implements IServer{
	
	IServer pyServer;
	
	public Server(String pathToPythonModules) {		
		
		initPythonPath(pathToPythonModules);
		
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.exec("from server import ServerController");
        PyObject serverClass = interpreter.get("ServerController");
        
        PyObject buildingObject = serverClass.__call__();
        pyServer =  (IServer) buildingObject.__tojava__(IServer.class);   
      
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
	public void fireHTTPGetEvent(Object data) {
		pyServer.fireHTTPGetEvent(data);		
	}
	
	@Override
	public void addHTTPGETEventListener(IHTTPEventListener listener) {
		pyServer.addHTTPGETEventListener(listener);	
		
	}

	@Override
	public void removeHTTPGETEventListener(IHTTPEventListener listener) {
		pyServer.removeHTTPGETEventListener(listener);		
	}
	
    	
	public static void main(String[] args) throws Exception {
		String path = new File("./src/se/kth/md/oslc").getCanonicalPath();		
		System.out.println("Main thread; starting the server.");
		Server server = new Server(path);
		server.run();
		System.out.println("Main thread; server running.");
		Thread.sleep(5000);
		System.out.println("Main thread; about to stop.");
		//server.kill();
	}

	

}
