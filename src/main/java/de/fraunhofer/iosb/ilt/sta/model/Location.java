package de.fraunhofer.iosb.ilt.sta.model;

import org.geojson.GeoJsonObject;

import com.fasterxml.jackson.annotation.JsonProperty;

import de.fraunhofer.iosb.ilt.sta.model.ext.EntityList;

public class Location extends Entity {
	private String description;
	private String encodingType;
	private GeoJsonObject location;
	
	@JsonProperty("Things")
	private EntityList<Thing> things;
	
	@JsonProperty("HistoricalLocations")
	private EntityList<HistoricalLocation> historicalLocations;

	public Location() {}
	
	public Location(String description, String encodingType, GeoJsonObject location) {
		this.description = description;
		this.encodingType = encodingType;
		this.location = location;
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

	public EntityList<HistoricalLocation> getHistoricalLocations() {
		return this.historicalLocations;
	}

	public void setHistoricalLocations(EntityList<HistoricalLocation> historicalLocations) {
		this.historicalLocations = historicalLocations;
	}

	public GeoJsonObject getLocation() {
		return this.location;
	}
	
	public void setLocation(GeoJsonObject location) {
		this.location = location;
	}

	public EntityList<Thing> getThings() {
		return this.things;
	}
	
	public void setThings(EntityList<Thing> things) {
		this.things = things;
	}
}
