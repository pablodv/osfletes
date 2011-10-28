package com.osfletes.service;

import java.util.List;

public interface IService<T> {
	public void save(T obj);
	public List<T> list();
	public void delete(T obj);
	
}
