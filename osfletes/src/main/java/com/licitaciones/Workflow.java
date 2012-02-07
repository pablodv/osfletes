package com.licitaciones;

import java.util.ArrayList;
import java.util.List;

import com.licitaciones.exception.InvalidTransactionException;
import com.osfletes.model.AnuncioMultipleLocalizado;

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
	
	public void executeAction(int stateId, int transactionId, StateAware obj, Object ... args) throws InvalidTransactionException{
		Estado actualState = this.getStateById(stateId);
		Transaction transaction = this.getTransactionById(transactionId);
		Estado newState = getStateById(actualState.executeAction(transaction));
		newState.executeInitAction(obj,args);
		obj.setState(newState.getIdentityVector());
	}
	
	public void executeAction(int stateId, String transactionName, StateAware obj, Object ... args) throws InvalidTransactionException{
		Estado actualState = this.getStateById(stateId);
		Transaction transaction = this.getTransactionByName(transactionName);
		Estado newState = getStateById(actualState.executeAction(transaction));
		newState.executeInitAction(obj,args);
		obj.setState(newState.getIdentityVector());
	}
	
	public void executeAction(Estado actualState, Transaction transaction, StateAware obj, Object ... args) throws InvalidTransactionException{
		Estado newState = getStateById(actualState.executeAction(transaction));
		newState.executeInitAction(obj,args);
		obj.setState(newState.getIdentityVector());
	}
	
	public Estado emuleAction(int stateId, int transactionId) throws InvalidTransactionException{
		Estado actualState = this.getStateById(stateId);
		Transaction transaction = this.getTransactionById(transactionId);
		return getStateById(actualState.executeAction(transaction));
	}
	
	public Transaction getTransactionByName(String name){
		for(Transaction transaction:transactions){
			if(transaction.getName().equals(name)){
				return transaction;
			}
		}
		
		return null;
	}
	
}
