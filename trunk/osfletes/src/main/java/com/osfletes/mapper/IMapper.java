package com.osfletes.mapper;

public interface IMapper<T,E>{
	public E toDTO(T model);
	public T toModel(E dto);

}
