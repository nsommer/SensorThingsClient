package de.fraunhofer.iosb.ilt.sta.model;

import java.net.URI;

import com.fasterxml.jackson.annotation.JsonProperty;

import de.fraunhofer.iosb.ilt.sta.model.ext.EntityList;

public class ObservedProperty extends Entity {
	private String name;
	private URI definition;
	private String description;
	
	@JsonProperty("Datastreams")
	private EntityList<Datastream> datastreams;
	
	public ObservedProperty() {}
	
	public ObservedProperty(String name, URI definition, String description) {
		this.name = name;
		this.definition = definition;
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public URI getDefinition() {
		return this.definition;
	}

	public void setDefinition(URI definition) {
		this.definition = definition;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public EntityList<Datastream> getDatastreams() {
		return this.datastreams;
	}
	
	public void setDatastreams(EntityList<Datastream> datastreams) {
		this.datastreams = datastreams;
	}
}
