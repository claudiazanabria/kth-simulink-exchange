/**
 * 
 */
package se.kth.md.simulinkExchange.atl;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;

/**
 * @author Alex Schenkman
 *
 */
public class Utils {

	/**
	 * Can we read from fileURI? 
	 * @param fileURI
	 * @return
	 */
	public static boolean isReadable(URI fileURI) {
		if ( fileURI.isFile() ) {
			File test = new File( fileURI.toFileString() );
			return test.canRead();
		}
		return false;
	}

	
	/**
	 * Can we write to fileURI?
	 * @param fileURI
	 * @return
	 */
	public static boolean isWriteable(URI fileURI) {
		if ( fileURI.isFile() ) {
			File test = new File( fileURI.toFileString() );
			if (test.canRead()) { 
				return test.canWrite(); 
			}
			else { 
				try {
					test.createNewFile();
					test.delete();
					return true;
				} catch (IOException e) {
					return false;
				} }
		}
		return false;
	}
	
	public static void validateReadableURI(URI fileURI) throws URInotFound {
		if (! Utils.isReadable( fileURI )) {
			throw new URInotFound( fileURI );
		}
	}

	public static void validateWriteableURI(URI fileURI) throws URInotFound {
		if (! Utils.isWriteable(fileURI)) {
			throw new URInotFound( fileURI );
		}
	}

	public static void validateRegisteredMetamodel(URI metaModel) throws URInotFound {
		if (! Utils.isMetamodelRegistered( metaModel )) {
			throw new URInotFound( metaModel );
		}
	}


	public static boolean isMetamodelRegistered(URI metaModel) {
		return EPackage.Registry.INSTANCE.containsKey( metaModel.toString() );
	}

}
