package com.osfletes.workflow;

import com.licitaciones.EstadoAction;
import com.licitaciones.exception.InvalidTransactionException;
import com.osfletes.model.Contract;

public class CreateContractInitAction implements EstadoAction<Contract> {

	@Override
	public void exceute(Contract contract, Object... args) throws InvalidTransactionException {
		
		
	}

}
