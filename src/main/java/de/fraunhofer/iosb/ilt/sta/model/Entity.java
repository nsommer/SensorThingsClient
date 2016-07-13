package de.fraunhofer.iosb.ilt.sta.model;

import java.net.URI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * An abstract representation of an entity.
 * 
 * @author Nils Sommer
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class Entity {
	@JsonProperty("@iot.id")
	protected Long id;
	
	@JsonProperty("@iot.selfLink")
	protected URI selfLink;
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public URI getSelfLink() {
		return this.selfLink;
	}
	
	public void setSelfLink(URI selfLink) {
		this.selfLink = selfLink;
	}
}
