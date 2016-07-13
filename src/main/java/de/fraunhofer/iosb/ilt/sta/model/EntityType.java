package de.fraunhofer.iosb.ilt.sta.model;

/**
 * This enum contains class and naming information about entities.
 * 
 * @author Nils Sommer
 *
 */
public enum EntityType {
	DATASTREAM(Datastream.class, "Datastreams"),
	FEATURE_OF_INTEREST(FeatureOfInterest.class, "FeaturesOfInterest"),
	HISTORICAL_LOCATION(HistoricalLocation.class, "HistoricalLocations"),
	LOCATION(Location.class, "Locations"),
	OBSERVATION(Observation.class, "Observations"),
	OBSERVED_PROPERTY(ObservedProperty.class, "ObservedProperties"),
	SENSOR(Sensor.class, "Sensors"),
	THING(Thing.class, "Things");
	
	private Class<? extends Entity> type;
	private String pluralizedName;
	
	EntityType(Class<? extends Entity> type, String pluralizedName) {
		this.type = type;
		this.pluralizedName = pluralizedName;
	}
	
	public Class<? extends Entity> getType() {
		return this.type;
	}
	
	public String getName() {
		return this.type.getSimpleName();
	}
	
	public String getPluralizedName() {
		return this.pluralizedName;
	}
	
	public static EntityType get(Class<? extends Entity> type) {
		if (type == Datastream.class)
			return DATASTREAM;
		if (type == FeatureOfInterest.class)
			return FEATURE_OF_INTEREST;
		if (type == HistoricalLocation.class)
			return HISTORICAL_LOCATION;
		if (type == Location.class)
			return LOCATION;
		if (type == Observation.class)
			return OBSERVATION;
		if (type == ObservedProperty.class)
			return OBSERVED_PROPERTY;
		if (type == Sensor.class)
			return SENSOR;
		if (type == Thing.class)
			return THING;
		
		return null;
	}
}
