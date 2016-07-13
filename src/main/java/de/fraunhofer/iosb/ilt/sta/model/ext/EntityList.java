package de.fraunhofer.iosb.ilt.sta.model.ext;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import de.fraunhofer.iosb.ilt.sta.model.Entity;

/**
 * An entity set.
 * 
 * @author Nils Sommer
 *
 * @param <T> the entity's type
 */
public class EntityList<T extends Entity> implements EntityCollection<T> {
	private final List<T> entities = new ArrayList<>();
	private long count;
	private URI nextLink;
	

	public EntityList() {}

	@Override
	public int size() {
		return this.entities.size();
	}

	@Override
	public boolean isEmpty() {
		return this.entities.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return this.entities.contains(o);
	}

	@Override
	public Iterator<T> iterator() {
		return this.entities.iterator();
	}

	@Override
	public Object[] toArray() {
		return this.entities.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return this.entities.<T>toArray(a);
	}

	@Override
	public boolean add(T e) {
		return this.entities.add(e);
	}

	@Override
	public boolean remove(Object o) {
		return this.entities.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return this.entities.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		return this.entities.addAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return this.entities.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return this.entities.retainAll(c);
	}

	@Override
	public void clear() {
		this.entities.clear();
	}

	@Override
	public List<T> toList() {
		return this.entities;
	}

	@Override
	public long getCount() {
		return this.count;
	}

	@Override
	public void setCount(long count) {
		this.count = count;
	}

	public URI getNextLink() {
		return nextLink;
	}

	public void setNextLink(URI nextLink) {
		this.nextLink = nextLink;
	}
}
