package se.kth.md.simulinkExchange.atl;

import org.eclipse.emf.common.util.URI;

/**
 * Data Structure to hold an model URI, its metamodel, and their IDs.
 * The IDs are defined in the ATL source.
 * @author Alex Schenkman
 *
 */
public class ModelTower {
	private URI model;
	private URI metaModel;
	private String modelID;
	private String metaModelID;
	
	public void setModel(URI model) throws URInotFound {
		this.model = model;
	}
	public URI getModel() {
		return model;
	}
	public void setMetaModel(URI metaModel) throws URInotFound {
		this.metaModel = metaModel;
	}
	public URI getMetaModel() {
		return metaModel;
	}
	public void setModelID(String modelID) {
		this.modelID = modelID;
	}
	public String getModelID() {
		return modelID;
	}
	public void setMetaModelID(String metaModelID) {
		this.metaModelID = metaModelID;
	}
	public String getMetaModelID() {
		return metaModelID;
	}
	public void setModel(URI modelURI, String id) throws URInotFound {
		this.setModel( modelURI );
		this.setModelID( id );
		
	}
	public void setMetaModel(URI metaodelURI, String id) throws URInotFound {
		this.setMetaModel( metaodelURI );
		this.setMetaModelID( id );
		
	}	
}
