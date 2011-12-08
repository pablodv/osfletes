package com.osfletes.dao;

import java.util.List;

import siena.Model;
import siena.PersistenceManager;
import siena.PersistenceManagerFactory;
import siena.Query;

public abstract class GenericSienaDAO<T extends Model> implements IGenericDAO<T> {

	protected PersistenceManager getPersistenceManager(){
		return PersistenceManagerFactory.getPersistenceManager(getRepresentedClass());
	}
	
	protected abstract Class<T> getRepresentedClass();
	
	@Override
	public void save(T obj) {
		obj.insert();
		obj.getPersistenceManager().save(obj);
	}

	@Override
	public List<T> list() {
		return Model.all(getRepresentedClass()).fetch();
	}

	@Override
	public void delete(T obj) {
		obj.getPersistenceManager().delete(obj);
	}
	
	@Override
	public T getById(Object id) {
		PersistenceManager pm= getPersistenceManager();
		Query<T> q = pm.createQuery(getRepresentedClass());
		q.filter("id", id);
		return q.get();
	}
	
	public void saveAll(T...obj){
		obj[0].getPersistenceManager().save(obj);
	}
}
