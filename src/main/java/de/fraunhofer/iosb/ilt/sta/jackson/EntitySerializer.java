package de.fraunhofer.iosb.ilt.sta.jackson;

import java.io.IOException;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.introspect.BasicBeanDescription;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;

import de.fraunhofer.iosb.ilt.sta.model.Entity;

/**
 * Serializer for SensorThings Entities.
 * 
 * @author Nils Sommer
 *
 */
public class EntitySerializer extends JsonSerializer<Entity> {
	private static final Logger logger = LoggerFactory.getLogger(EntitySerializer.class);
	
	@Override
	public void serialize(Entity entity, JsonGenerator gen, SerializerProvider serializers)
			throws IOException, JsonProcessingException {
		gen.writeStartObject();
		
		final BasicBeanDescription beanDesc = serializers.getConfig().introspect(serializers.constructType(entity.getClass()));
		
		for (BeanPropertyDefinition def : beanDesc.findProperties()) {
			Object rawValue = def.getAccessor().getValue(entity);			
			// TODO: Check if prop is collection
			
			// Write field if not null.
			if (rawValue != null) {
				if (rawValue instanceof Entity) {
					// It's a referenced entity. -> <Entity>: { "@iot.id": <id> }
					gen.writeFieldName(rawValue.getClass().getSimpleName());
					gen.writeStartObject();
					gen.writeFieldName("@iot.id");
					gen.writeNumber(((Entity) rawValue).getId());
					gen.writeEndObject();
				} else if(rawValue instanceof Collection<?>) {
					// Ignore collections during serialization.
					continue;
				} else {
					TypeSerializer typeSerializer = serializers.findTypeSerializer(serializers.constructType(def.getAccessor().getRawType()));	
					BeanPropertyWriter writer = new BeanPropertyWriter(
							def,
							def.getAccessor(),
							beanDesc.getClassAnnotations(),
							def.getAccessor().getType(),
							null, // will be searched automatically
							typeSerializer, // will not be searched automatically
							def.getAccessor().getType(),
							true, // ignore null values
							null);
					try {
						writer.serializeAsField(entity, gen, serializers);
					} catch (Exception e) {
						logger.error("Failed to serialize entity.", e);
					}
				}
			}
		}
		
		gen.writeEndObject();
	}
}
