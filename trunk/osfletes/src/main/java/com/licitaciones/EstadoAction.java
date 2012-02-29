package com.licitaciones;

import com.licitaciones.exception.InvalidTransactionException;

public interface EstadoAction<T extends StateAware> {
	
	public void exceute(T obj, Object... args) throws InvalidTransactionException;
}
