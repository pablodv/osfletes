package com.licitaciones;

public class TransactionImpl implements Transaction {

	private int identityVector;
	private String name;
	
	
	
	private TransactionImpl() {
		super();
	}
	
	public TransactionImpl(int identityVector, String name){
		new TransactionImpl();
		this.identityVector = identityVector;
		this.name = name;
	}

	@Override
	public int getIdentityVector() {
		return identityVector;
	}

	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(null == obj)
			return false;
		
		if(!(obj instanceof TransactionImpl))
			return false;
		
		return obj.hashCode() == this.hashCode();
	}

	@Override
	public int hashCode() {
		return Integer.valueOf(identityVector).hashCode();
	}
	
}
