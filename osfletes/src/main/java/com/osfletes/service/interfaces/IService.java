package com.osfletes.service.interfaces;

import java.util.List;

public interface IService<T> {
	
	
	public void save(T obj);
	public List<T> list();
	public T getById(Object id);
	public void delete(T obj);
	public void saveAll(List<T> objList);	
}
