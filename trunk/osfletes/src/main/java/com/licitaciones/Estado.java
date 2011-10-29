package com.licitaciones;

import com.licitaciones.exception.InvalidTransactionException;

public interface Estado {
	
	public int getIdentityVector();
	
	public int getTransactionsVector();
	
	public String getName();
	
	public boolean isFinalState();

	public boolean isStartState();

	public int executeAction(Transaction transaction) throws InvalidTransactionException;
}
