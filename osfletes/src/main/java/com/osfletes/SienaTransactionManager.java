package com.osfletes;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.SimpleTransactionStatus;

import siena.PersistenceManagerFactory;

import com.osfletes.model.Anuncio;

public class SienaTransactionManager implements PlatformTransactionManager {

	public SienaTransactionManager() {
		super();
	}
	
	

	@Override
	public void commit(TransactionStatus arg0) throws TransactionException {
		PersistenceManagerFactory.getPersistenceManager(Anuncio.class).commitTransaction();
		
	}




	@Override
	public TransactionStatus getTransaction(TransactionDefinition arg0)
			throws TransactionException {
		
		PersistenceManagerFactory.getPersistenceManager(Anuncio.class).beginTransaction();
		
		return new SimpleTransactionStatus();
	}




	@Override
	public void rollback(TransactionStatus arg0) throws TransactionException {
		PersistenceManagerFactory.getPersistenceManager(Anuncio.class).rollbackTransaction();
		
	}

}
