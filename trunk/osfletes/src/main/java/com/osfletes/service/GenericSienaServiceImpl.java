package com.osfletes.service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import siena.Model;

import com.osfletes.dao.GenericSienaDAO;

public abstract class GenericSienaServiceImpl<T extends Model,K extends GenericSienaDAO<T>> implements IService<T>{

	protected K dao;
	
	@Autowired
	public void setDao(K dao) {
		this.dao = dao;
	}
	
	@Override
	@Transactional
	public void save(T obj) {
		dao.save(obj);
	}

	@Override
	@Transactional(readOnly=true)
	public List<T> list() {
		return dao.list();
	}

	@Override
	@Transactional
	public void delete(T obj) {
		dao.delete(obj);
	}
	
	@Override
	public T getById(Object id) {
		return dao.getById(id);
	}
	
	@Transactional
	public void saveAll(List<T> objList){
		for(T obj:objList){
			dao.save(obj);
		}
	}
}
