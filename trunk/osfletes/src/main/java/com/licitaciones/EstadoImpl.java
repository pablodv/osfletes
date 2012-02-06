package com.licitaciones;

import com.licitaciones.exception.InvalidTransactionException;

public class EstadoImpl implements Estado {

	private int identityVector;
	private int transactionsVector;
	private String name;
	private boolean finalState;
	private boolean startState;
	private EstadoAction action;
	
	private EstadoImpl(){};
	
	public EstadoImpl(int identityVector, int transactionsVector, String name){
		super();
		this.identityVector = identityVector;
		this.transactionsVector = transactionsVector;
		this.name = name;
	}
	
	@Override
	public int getIdentityVector() {
		return identityVector;
	}

	@Override
	public int getTransactionsVector() {
		return transactionsVector;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int executeAction(Transaction transaction) throws InvalidTransactionException {
		int resultState = ((int)Math.pow(2,transaction.getIdentityVector())) & transactionsVector;
		if(resultState == 0){
			throw new InvalidTransactionException();
		}
		return   Integer.numberOfTrailingZeros(resultState);
		
	}
	
	@Override
	public boolean isFinalState() {
		return finalState;
	}

	@Override
	public boolean isStartState() {
		return startState;
	}

	@Override
	public boolean equals(Object obj) {
		
		if(null == obj)
			return false;
		
		if(!(obj instanceof EstadoImpl))
			return false;
		
		return obj.hashCode() == this.hashCode();
	}

	@Override
	public int hashCode() {
		return Integer.valueOf(identityVector).hashCode();
	}

	@Override
	public void executeInitAction(Object obj, Object... args) {
		action.exceute(obj,args);		
	}
	
	

}
