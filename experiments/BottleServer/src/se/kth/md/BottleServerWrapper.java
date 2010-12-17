package se.kth.md;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.python.core.Py;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

import se.kth.md.SimulinkOOAPI.exceptions.ProtoObjectCreationException;
import se.kth.md.SimulinkOOAPI.util.YorkModel;

/**
 * A Java wrapper around python bottle server.
 * 
 * The class is responsible for performing the conversion of the referenced python module into Java bytecode
 * and running the server in a thread. Stop() method interrupts the thread and thus stops the server.     
 *
 */
public class BottleServerWrapper {
	
    //private ServerThread serverThread;
	
	public BottleServerWrapper(String pathToPythonModules, IMatlabProxy proxy) {		
		
		initPythonPath(pathToPythonModules);
		
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.exec("from server import Server");
        PyObject serverClass = interpreter.get("Server");
        
        PyObject buildingObject = serverClass.__call__(Py.java2py(proxy));
        IBottleServer bottleServer =  (IBottleServer) buildingObject.__tojava__(IBottleServer.class);
        
     //   serverThread = new ServerThread(bottleServer);
      
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

    /**
     * Runs python server.
     */
    public void runBottleServer () {        
    	//serverThread.start();
    }  
    
    /**
     * Stops python server.
     */
    public void stopServer () {   	
    	//serverThread.interrupt();
    }
    
    
    
//    class ServerThread extends Thread {
//    	private IBottleServer bottleServer;
//    	
//    	public ServerThread(IBottleServer bottleServer){
//    		this.bottleServer = bottleServer;
//    	}    	
//    	
//    	public void wakeUp(){
//    		super.resume();
//    		System.out.println("push server");
//    		bottleServer.wakeUp();
//    	}
//    	
//    	@Override
//    	public void run() {    		
//    		bottleServer.runServer();
//    		try {			
//    			// let other threads to perform actions
//    			Thread.sleep(60);
//    		} catch (InterruptedException e) {}
//    	}
//    }   
//    
//    public static void main(String[] args) throws Exception {    	
//      	String path = new File(".").getCanonicalPath();
//      	BottleServerWrapper wr = new BottleServerWrapper(path, new MatlabProxy());
//      	wr.run();
//		try {			
//			// let other threads to perform actions
//			Thread.sleep(60);
//		} catch (InterruptedException e) {}
//		wr.waikUp();
//	}

}
