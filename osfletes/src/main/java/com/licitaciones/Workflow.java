package com.licitaciones;

import java.util.ArrayList;
import java.util.List;

import com.licitaciones.exception.InvalidTransactionException;

public class Workflow {
	private List<Estado> estados;
	private List<Transaction> transactions;
	private Estado initialState;
	
	
	
	private Workflow() {
		super();
	}
	
	public Workflow(List<Estado> estados, List<Transaction> transactions) {
		new Workflow();
		this.estados = estados;
		this.transactions = transactions;
		for(Estado estado:estados){
			if(estado.isStartState()){
				this.initialState = estado;
			}
		}
	}

	public List<Estado> getEstados() {
		return estados;
	}
	
	public List<Transaction> getTransactions() {
		return transactions;
	}
	
	public Estado getStateById(int id) {
		for(Estado estado:estados){
			if(estado.getIdentityVector() == id){
				return estado;
			}
		}
		
		return null;
	}
	
	public List<Transaction> getEstadoTransactions(Estado estado){
		
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
		for(Transaction transaction:transactions){
			if(transaction.getIdentityVector() == id){
				return transaction;
			}
		}
		
		return null;
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
	
	public Estado emuleAction(String state, String transactionName) throws InvalidTransactionException{
		Estado actualState = this.getEstadoByName(state);
		Transaction transaction = this.getTransactionByName(transactionName);
		return getStateById(actualState.executeAction(transaction));
	}
	
	public boolean isTransactionValid(int state, String transactionName){
		Estado actualState = this.getStateById(state);
		Transaction transaction = this.getTransactionByName(transactionName);
		try {
			actualState.executeAction(transaction);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public Transaction getTransactionByName(String name){
		for(Transaction transaction:transactions){
			if(transaction.getName().equalsIgnoreCase(name)){
				return transaction;
			}
		}
		
		return null;
	}
	
	public Estado getEstadoByName(String name){
		for(Estado estado:estados){
			if(estado.getName().equalsIgnoreCase(name)){
				return estado;
			}
		}
		
		return null;
	}
	
	public Estado getInitialState(){
		return initialState;
	}

	public void initWorkflow(StateAware contract, Object... objects) throws InvalidTransactionException {
		Estado initialState = this.getInitialState();
		initialState.executeInitAction(contract, objects);
		contract.setState(initialState.getIdentityVector());
	}
	
}
