package com.osfletes.service;
import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.osfletes.dao.interfaces.IGenericDAO;
import com.osfletes.service.interfaces.IGenericService;



public abstract class GenericServiceImplementacion<T,K extends IGenericDAO<T>> implements IGenericService<T>{

	protected K dao; 
	
	@Override
	public Serializable save(T entity) {
		return getDao().save(entity);
	}

	@Override
	public void delete(T entity) {
		dao.delete(entity);
	}

	@Override
	public List<T> getAll() {
		return dao.findAll();
	}

	@Override
	public void saveOrUpdate(T entity) {
		dao.saveOrUpdate(entity);	
	}

	@Override
	public void persist(T entity) {
		dao.persist(entity);		
	}

	@Override
	public T load(Serializable id) {
		return dao.load(id);
	}

	@Override
	public void update(T entity) {
		dao.update(entity);
	}

	@Autowired
	public void setDao(K dao) {
		this.dao = dao;
	}
	
	public K getDao(){
	  return dao;
	}
	
	@Override
	public T getById(Serializable id){
		return dao.findById(id);
	}

	@Override
	public void delete(Serializable entityId) {
		T entity = this.load(entityId);
		dao.delete(entity);
	}
	
	

	
}
