package de.fraunhofer.iosb.ilt.sta.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import de.fraunhofer.iosb.ilt.sta.model.ext.EntityList;

public class Sensor extends Entity {
	private String description;
	private String encodingType;
	private Object metadata;
	
	@JsonProperty("Datastreams")
	private EntityList<Datastream> datastreams;
	
	public Sensor() {}
	
	public Sensor(String description, String encodingType, Object metadata) {
		this.description = description;
		this.encodingType = encodingType;
		this.metadata = metadata;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getEncodingType() {
		return this.encodingType;
	}
	
	public void setEncodingType(String encodingType) {
		this.encodingType = encodingType;
	}

	public Object getMetadata() {
		return metadata;
	}

	public void setMetadata(Object metadata) {
		this.metadata = metadata;
	}
	
	public EntityList<Datastream> getDatastreams() {
		return this.datastreams;
	}
	
	public void setDatastreams(EntityList<Datastream> datastreams) {
		this.datastreams = datastreams;
	}
}
