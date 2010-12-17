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
        interpreter.exec("from server import Server");
        PyObject serverClass = interpreter.get("Server");
        
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
	public void stop() {		
		pyServer.stop();		
	}
	
	public static void main(String[] args) throws Exception {
		String path = new File("./src/se/kth/md/oslc").getCanonicalPath();		
		Server server = new Server(path);
		server.run();
		Thread.sleep(10000);
		server.stop();
	}
	

}
