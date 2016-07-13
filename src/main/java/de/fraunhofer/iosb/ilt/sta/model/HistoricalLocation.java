package de.fraunhofer.iosb.ilt.sta.model;

import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import de.fraunhofer.iosb.ilt.sta.model.ext.EntityList;

public class HistoricalLocation extends Entity {
	private ZonedDateTime time;
	
	@JsonProperty("Locations")
	private EntityList<Location> locations;
	
	@JsonProperty("Thing")
	private Thing thing;

	public HistoricalLocation() {}
	
	public HistoricalLocation(ZonedDateTime time) {
		this.time = time;
	}

	public ZonedDateTime getTime() {
		return this.time;
	}

	public void setTime(ZonedDateTime time) {
		this.time = time;
	}

	public EntityList<Location> getLocations() {
		return this.locations;
	}
	
	public void setLocations(EntityList<Location> locations) {
		this.locations = locations;
	}

	public Thing getThing() {
		return this.thing;
	}
	
	public void setThing(Thing thing) {
		this.thing = thing;
	}
}
