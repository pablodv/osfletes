package com.licitaciones;

import java.util.ArrayList;
import java.util.List;

import com.licitaciones.exception.InvalidTransactionException;

public class Workflow {
	private List<Estado> estados;
	private List<Transaction> transactions;
	
	
	
	private Workflow() {
		super();
	}
	
	public Workflow(List<Estado> estados, List<Transaction> transactions) {
		new Workflow();
		this.estados = estados;
		this.transactions = transactions;
	}

	public List<Estado> getEstados() {
		return estados;
	}
	
	public List<Transaction> getTransactions() {
		return transactions;
	}
	
	public Estado getStateById(int id) {
		return estados.get(id);
	}
	
	public List<Transaction> getEstadoTransactions(int id){
		Estado estado= getStateById(id);
		int transactionVector = estado.getTransactionsVector();
		int bitCount = Integer.bitCount(transactionVector);
		List<Transaction> transactions = new ArrayList<Transaction>(bitCount);
		
		for(int i=0;i< bitCount;i++){
			int maxBit = Integer.highestOneBit(transactionVector);
			transactions.add(this.getTransactionById(Integer.numberOfTrailingZeros(maxBit)));
			transactionVector ^= maxBit;
		}
		
		return transactions;
	}
	
	public Transaction getTransactionById(int id){
		return transactions.get(id);
	}
	
	public Estado executeAction(int stateId, int transactionId) throws InvalidTransactionException{
		Estado actualState = this.getStateById(stateId);
		Transaction transaction = this.getTransactionById(transactionId);
		return getStateById(actualState.executeAction(transaction));
	}
	
}
