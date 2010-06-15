/**
 * 
 */
package se.kth.md.simulinkExchange.atl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Scanner;

import org.eclipse.emf.common.util.URI;

/**
 * @author alesch
 *
 */
public class XmlCombiner extends java.lang.Object {

	private File eastFile;
	private File umlFile;

	private Scanner eastScanner;
	private Scanner umlScanner;
	
	private String 	resultFileName;	
	private String encoding = "ISO-8859-1";
	private String NL = System.getProperty("line.separator");
	private Writer writer;
	
	public XmlCombiner(String eastPath, String umlPath, String resultPath) {
		eastFile 	= new File(eastPath);
		umlFile 	= new File(umlPath);
		resultFileName = resultPath;
	}
	
	public XmlCombiner(URI umlModel2, URI umlModel1, URI resultUML) {
		this(	umlModel2.toFileString(), 
				umlModel1.toFileString(),
				resultUML.toFileString());
	}

	public void doIt() throws IOException {
		init();
		@SuppressWarnings("unused")
		String data, ignored;
		try {
			ignored = readXMLline( eastScanner );
			data = readXMLline(umlScanner);
			writer.write( data );
			data = readXMILine( eastScanner );
			writer.write( data );
			data = readEverythingElse( umlScanner );
			writer.write( data );
			data = readEverythingElse( eastScanner );
			writer.write( data );
		}
		finally {
			eastScanner.close();
			umlScanner.close();
			writer.close();
		}
	}

	private void init() throws FileNotFoundException,
			UnsupportedEncodingException {
		eastScanner = new Scanner( eastFile, encoding);
		umlScanner	= new Scanner( umlFile , encoding);
		
		FileOutputStream stream = new FileOutputStream( resultFileName );
		writer = new OutputStreamWriter(stream, encoding);
	}

	public String readLine(Scanner scanner) {
		scanner.useDelimiter("\\n");
		if ( scanner.hasNextLine() ) {
			return scanner.nextLine() + NL;
		}
		return null;
	}
	
	private String readXMLline(Scanner scanner) {
		return readLine(scanner);
	}
	
	public String readXMILine(Scanner scanner) {
		return readLine(scanner);
	}
	
	public String readEverythingElse(Scanner scanner) {
		StringBuilder result = new StringBuilder();		
		String data = readLine( scanner );
		while (data != null) { 
			result.append( data );
			data = readLine( scanner );
		}		
		return result.toString();
	}
		

	public static void main(String [] args) {
		XmlCombiner c = new XmlCombiner("./resources/testFiles/demo2.uml", 
				"./resources/testFiles/demo.uml", "./resources/testFiles/demox.uml");
		try {
			c.doIt();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public static void doIt(URI umlModel2, URI umlModel1, URI resultUML) throws IOException {
		XmlCombiner c = new XmlCombiner(umlModel2, umlModel1, resultUML);
		c.doIt();
		
	}
}
