package com.osfletes.dao;

import java.util.List;

public interface IGenericDAO<T> {

	public void save(T obj);
	public List<T> list();
	public T getById(Object id);
	public void delete(T obj);
}
