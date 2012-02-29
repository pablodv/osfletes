package com.osfletes.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.licitaciones.Workflow;
import com.licitaciones.exception.BusinessException;
import com.osfletes.dao.interfaces.IContractDAO;
import com.osfletes.mapper.ContractMapper;
import com.osfletes.model.Contract;
import com.osfletes.service.interfaces.IContractService;
import com.osfletes.web.controller.JsonMesagesResolver;
import com.osfletes.web.dto.ContractDTO;
import com.osfletes.web.dto.ContractFilterDTO;
import com.osfletes.web.model.ResultadoPaginado;

@Service(value="contractService")
public class ContractService extends GenericServiceImplementacion<Contract, IContractDAO> implements IContractService {

	private ContractMapper contractMapper;
	
	@Autowired
	@Qualifier(value="workflow-contrato")
	private Workflow workflow;
	
	
	
	public void setWorkflow(Workflow workflow) {
		this.workflow = workflow;
	}

	@Autowired
	public void setContractMapper(ContractMapper contractMapper) {
		this.contractMapper = contractMapper;
	}

	@Override
	public Contract createContract(ContractDTO contractDTO) {
		Contract contract = contractMapper.toModel(contractDTO);
		if(!contract.getAnnouncement().equals(contract.getOffer().getAnuncio())){
			throw new BusinessException(JsonMesagesResolver.getMessage("contract.invalid", null, null));
		}
		this.save(contract);
		return contract;
	}

	@Override
	public Serializable save(Contract contract) {
		try {
			workflow.initWorkflow(contract);
		} catch (Exception e) {
			throw new BusinessException(JsonMesagesResolver.getMessage("error.action.invalid", null, null));
		}
		
		return super.save(contract);	
	}

	@Override
	public ResultadoPaginado<Contract> findContracts(ContractFilterDTO filter) {
		return this.dao.findContracts(filter);
	}
	
	
	
	

}
