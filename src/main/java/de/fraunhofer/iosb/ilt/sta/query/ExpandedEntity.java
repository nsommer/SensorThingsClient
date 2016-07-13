package de.fraunhofer.iosb.ilt.sta.query;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import de.fraunhofer.iosb.ilt.sta.model.EntityType;

/**
 * An expanded entity is an entity to be included into a request.
 * 
 * @author Nils Sommer
 *
 */
public class ExpandedEntity {
	private final List<EntityType> entities;
	
	private ExpandedEntity(EntityType...entities) {
		this.entities = new ArrayList<>(entities.length);
		
		for (EntityType entity : entities) {
			this.entities.add(entity);
		}
	}
	
	public static ExpandedEntity from(EntityType...entities) {
		return new ExpandedEntity(entities);
	}
	
	@Override
	public String toString() {
		return this.entities
				.stream()
				.map(e -> e.getName())
				.collect(Collectors.joining("/"));		
	}
}
