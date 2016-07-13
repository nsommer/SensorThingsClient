package de.fraunhofer.iosb.ilt.sta.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * This enum contains class and naming information about entities.
 * 
 * @author Nils Sommer
 *
 */
public enum EntityType {
	DATASTREAM(Datastream.class, "Datastream", "Sensor", "Thing", "ObservedProperty", "Observations"),
	DATASTREAMS(Datastream.class, "Datastreams", "Sensor", "Thing", "ObservedProperty", "Observations"),
	FEATURE_OF_INTEREST(FeatureOfInterest.class, "FeatureOfInterest", "Observations"),
	FEATURES_OF_INTEREST(FeatureOfInterest.class, "FeaturesOfInterest", "Observations"),
	HISTORICAL_LOCATION(HistoricalLocation.class, "HistoricalLocation", "Thing", "Locations"),
	HISTORICAL_LOCATIONS(HistoricalLocation.class, "HistoricalLocations", "Thing", "Locations"),
	LOCATION(Location.class, "Location", "Things", "HistoricalLocations"),
	LOCATIONS(Location.class, "Locations", "Things", "HistoricalLocations"),
	OBSERVATION(Observation.class, "Observation", "FeatureOfInterest", "Datastream"),
	OBSERVATIONS(Observation.class, "Observations", "FeatureOfInterest", "Datastream"),
	OBSERVED_PROPERTY(ObservedProperty.class, "ObservedProperty", "Datastreams"),
	OBSERVED_PROPERTIES(ObservedProperty.class, "ObservedProperties", "Datastreams"),
	SENSOR(Sensor.class, "Sensor", "Datastreams"),
	SENSORS(Sensor.class, "Sensors", "Datastreams"),
	THING(Thing.class, "Thing", "Datastreams", "Locations", "HistoricalLocations"),
	THINGS(Thing.class, "Things", "Datastreams", "Locations", "HistoricalLocations");
	
	private Class<? extends Entity> type;
	private String name;
	// Referenced as string instead of EntityType because we cannot access
	// fields before they are created :(
	private Set<String> relations;
	
	EntityType(Class<? extends Entity> type, String name, String...relations) {
		this.type = type;
		this.name = name;
		this.relations = new HashSet<>();
		this.relations.addAll(Arrays.asList(relations));
	}
	
	/**
	 * Get the class of this entity type.
	 * 
	 * @return the class
	 */
	public Class<? extends Entity> getType() {
		return this.type;
	}
	
	/**
	 * Get the name of this entity type.
	 * 
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Check whether this entity type has a relationship to another
	 * entity type.
	 * 
	 * @param other the other entity type
	 * @return true if they are related, otherwise false
	 */
	public boolean hasRelationTo(EntityType other) {
		return this.relations.contains(other.getName());
	}
	
	/**
	 * Get an EntityType by name.
	 * 
	 * @param name the name
	 * @return the EntityType
	 */
	public static EntityType byName(String name) {
		switch (name) {
		case "Datastream": return DATASTREAM;
		case "Datastreams": return DATASTREAMS;
		case "FeatureOfInterest": return FEATURE_OF_INTEREST;
		case "FeaturesOfInterest": return FEATURES_OF_INTEREST;
		case "HistoricalLocation": return HISTORICAL_LOCATION;
		case "HistoricalLocations": return HISTORICAL_LOCATIONS;
		case "Location": return LOCATION;
		case "Locations": return LOCATIONS;
		case "Observation": return OBSERVATION;
		case "Observations": return OBSERVATIONS;
		case "ObservedProperty": return OBSERVED_PROPERTY;
		case "ObservedProperties": return OBSERVED_PROPERTIES;
		case "Sensor": return SENSOR;
		case "Sensors": return SENSORS;
		case "Thing": return THING;
		case "Things": return THINGS;
		}
		
		return null;
	}
}
