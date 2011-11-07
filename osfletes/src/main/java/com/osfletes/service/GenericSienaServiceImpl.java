package com.osfletes.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import siena.Model;
import siena.PersistenceManager;
import siena.PersistenceManagerFactory;
import siena.Query;

public abstract class GenericSienaServiceImpl<T extends Model> implements IService<T>{

	@Override
	@Transactional
	public void save(T obj) {
		obj.insert();
		obj.getPersistenceManager().save(obj);
	}

	@Override
	@Transactional(readOnly=true)
	public List<T> list() {
		return Model.all(getRepresentedClass()).fetch();
	}

	@Override
	@Transactional
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
	
	protected PersistenceManager getPersistenceManager(){
		return PersistenceManagerFactory.getPersistenceManager(getRepresentedClass());
	}

	protected abstract Class<T> getRepresentedClass();

}
