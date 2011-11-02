package com.osfletes.service;

import java.util.List;

import siena.Model;

public abstract class GenericSienaServiceImpl<T extends Model> implements IService<T>{

	 protected Class<T> representedClass;
	
	@Override
	public void save(T obj) {
		obj.getClass();		
	}

	@Override
	public List<T> list() {
		return null;
		}

	@Override
	public void delete(T obj) {
		// TODO Auto-generated method stub
		
	}
	
	protected abstract T getRepresentedClass();

}
