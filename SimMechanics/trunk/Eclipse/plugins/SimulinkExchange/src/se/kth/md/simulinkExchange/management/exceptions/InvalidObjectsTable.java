package se.kth.md.simulinkExchange.management.exceptions;

import java.util.Hashtable;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

public class InvalidObjectsTable extends Hashtable<EObject, String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8042801816811465291L;

	/**
	 * Dumps the invalid objects to the console. Very useful for debugging a model.
	 */
	public void dumpToStdout() {
		for(Map.Entry<EObject, String> entry: this.entrySet()) {
			System.out.print(entry.getKey() + ": ");
			System.out.println(entry.getValue());
		}
	}
	
	/**
	 * Dumps the invalid objects to the console. Very useful for debugging a model.
	 */
	public String dumpToString() {
		StringBuffer buffer = new StringBuffer(1000);
		for(Map.Entry<EObject, String> entry: this.entrySet()) {
			buffer.append(entry.getKey());
			buffer.append(": ");
			buffer.append(entry.getValue());
			buffer.append("\n");
		}
		return buffer.toString();
	}
}
