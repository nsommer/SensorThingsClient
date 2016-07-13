package de.fraunhofer.iosb.ilt.sta.query;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import de.fraunhofer.iosb.ilt.sta.model.EntityType;

/**
 * Type safe builder of $expand queries.
 * 
 * @author Nils Sommer
 *
 */
public class Expansion {
	private final Set<ExpandedEntity> entities = new HashSet<>();

	public Expansion() {}

	/**
	 * Start an expansion query.
	 * 
	 * @param entity the referenced entity
	 * @return the Expansion instance
	 */
	public static Expansion with(ExpandedEntity entity) {
		return new Expansion().and(entity);
	}
	
	/**
	 * Expand to a referenced entity.
	 * 
	 * @param entity the referenced entity
	 * @return the Expansion instance
	 */
	public Expansion and(ExpandedEntity entity) {
		this.entities.add(entity);
		return this;
	}
	
	@Override
	public String toString() {		
		return this.entities
				.stream()
				.map(e -> e.toString())
				.collect(Collectors.joining(","));
	}
}
