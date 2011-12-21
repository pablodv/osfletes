package com.osfletes.mapper;

import java.util.List;

public interface IMapper<M,D>{
	public D toDTO(M model);
	public M toModel(D dto);
	public List<D> listToDto(List<M> lista);
}
