package com.osfletes.dao.interfaces;

import com.osfletes.model.Contract;
import com.osfletes.web.dto.ContractFilterDTO;
import com.osfletes.web.model.ResultadoPaginado;

public interface IContractDAO extends IGenericDAO<Contract> {

	ResultadoPaginado<Contract> findContracts(ContractFilterDTO filter);

}
