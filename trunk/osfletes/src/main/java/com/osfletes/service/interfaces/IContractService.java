package com.osfletes.service.interfaces;

import org.springframework.transaction.annotation.Transactional;

import com.osfletes.model.Contract;
import com.osfletes.web.dto.ContractDTO;
import com.osfletes.web.dto.ContractFilterDTO;
import com.osfletes.web.model.ResultadoPaginado;

public interface IContractService extends IGenericService<Contract> {

	/**
	 * Crea un contrato a partir de un dto con los ids del anuncio y la oferta setteados
	 * @param contractDTO
	 * @param userId 
	 * @return
	 */
	@Transactional
	public Contract createContract(ContractDTO contractDTO);

	@Transactional
	public ResultadoPaginado<Contract> findContracts(ContractFilterDTO filter);

	

}
