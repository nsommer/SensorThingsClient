SensorThingsClient
==================

This is a client library to connect java applications to servers providing a [SensorThingsAPI](https://github.com/opengeospatial/sensorthings) service.

## Features

* CRUD operations
* Queries on entity sets
* Loading of referenced entities

## Unsupported

* Batch requests
* *$select*
* MultiDatastream
* dataArray
* MQTT

## Build

SensorThingsClient is built with maven.

```bash
mvn install
```

## Installation

At the moment, there is no centralized maven repository which serves SensorThingsClient, therefore you need a copy a local copy of the library. Put this into your pom.xml:

```xml
<dependency>
	<groupId>de.fraunhofer.iosb.ilt</groupId>
	<artifactId>SensorThingsClient</artifactId>
	<version>0.0.1-SNAPSHOT</version>
</dependency>
```

## API

The `SensorThingsService` class is central to the library. An instantiation of it represents a SensorThings service and is identified by an URI.

### CRUD operations

The source code below demonstrates the CRUD operations for Thing objects. Operations for other entities work similarily.

```java
URI serviceEndpoint = URI.create("http://example.org/v1.0/");
SensorThingsService service = new SensorThingsService(serviceEndpoint);
```

```java
Thing thing = new Thing();
thing.setDescription("I'm a thing!");
service.things().create(thing);

thing = service.things().find(1l);

thing.setDescription("Things change...");
service.things().update(thing);

service.things().delete(thing);
```

### Entity Sets

Entity Sets are represented by instances of `EntityList<>`. The query parameters specified by the SensorThingsAPI standard can be applied to queries.

```java
EntityList<Thing> things = service.things()
							.query()
							.count()
							.orderBy("description")
							.filter("")
							.skip(5)
							.top(10)
							.list();

for (Thing thing : things) {
	System.out.println("So many things!");
}
```

### Loading referenced objects

Loading referenced objects in one operation (and therefore in one request) is supported. The *$expand* option of the SensorThingsAPI standard is used internally.

```java
Thing thing = service.things().find(1l, 
				Expansion.of(EntityType.THING)
				.with(ExpandedEntity.from(EntityType.LOCATIONS)));
EntityList<Location> locations = thing.getLocations();
```
