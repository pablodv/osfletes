package com.osfletes.dao.hibernate;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.osfletes.dao.interfaces.IContractDAO;
import com.osfletes.model.Contract;
import com.osfletes.web.dto.ContractFilterDTO;
import com.osfletes.web.model.ResultadoPaginado;

@Repository
public class ContractDAO extends GenericHibernateDAO<Contract> implements IContractDAO {

	@Autowired
	public ContractDAO(SessionFactory sf) {
		super(sf);
	}

	@Override
	public Class<Contract> getRepresentedClass() {
		return Contract.class;
	}

	@Override
	public ResultadoPaginado<Contract> findContracts(ContractFilterDTO filter) {
		Criteria criteria = this.createCriteria("contract");
		Criterion criterion = Restrictions.sqlRestriction(" 1 = 1 ");
		
		if(filter.getUsuarioCreacion() != null){
			criteria = criteria.createCriteria("announcement").add(Restrictions.eq("usuarioCreacion.id", filter.getUsuarioCreacion()));
		}

		if(filter.getProveedor() != null){
			criteria = criteria.createCriteria("offer").add(Restrictions.eq("usuarioCreacion.id", filter.getProveedor()));
		}

		criteria.add(criterion);
		return this.findPageByCriteria(criteria,filter);
	}

}
