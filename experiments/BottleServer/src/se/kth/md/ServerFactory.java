package se.kth.md;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.python.core.Py;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

public class ServerFactory {
	
	private PyObject serverClass;
	
	public ServerFactory() {
		System.out.println("init factory");
		Properties props = new Properties();		
		try {
			String current_dir = new File(".").getCanonicalPath();
			System.out.println("curre "+current_dir);
			props.setProperty("python.path", current_dir);			
			PythonInterpreter.initialize(System.getProperties(), props,
                    new String[] {""});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.exec("from server import Server");
        serverClass = interpreter.get("Server");
    }

    /**
     * The create method is responsible for performing the actual
     * coercion of the referenced python module into Java bytecode
     */
    public IBottleServer create (MatlabProxy proxy) {

        PyObject buildingObject = serverClass.__call__(Py.java2py(proxy));
        return (IBottleServer) buildingObject.__tojava__(IBottleServer.class);
    }  
   
    
}
