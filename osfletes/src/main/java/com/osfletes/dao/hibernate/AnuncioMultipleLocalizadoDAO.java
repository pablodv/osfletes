package com.osfletes.dao.hibernate;

import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.osfletes.model.AnuncioMultipleLocalizado;
import com.osfletes.web.dto.FiltroDTO;
import com.osfletes.web.model.ResultadoPaginado;

@Repository
public class AnuncioMultipleLocalizadoDAO extends GenericHibernateDAO<AnuncioMultipleLocalizado> {

	@Autowired
	public AnuncioMultipleLocalizadoDAO(SessionFactory sf) {
		super(sf);
	}

	@Override
	public Class<AnuncioMultipleLocalizado> getRepresentedClass() {
		return AnuncioMultipleLocalizado.class;
	}

	
	public ResultadoPaginado<AnuncioMultipleLocalizado> findAnuncios(FiltroDTO filtro) {
		Criteria criteria = this.createCriteria();
		if((filtro.getFechaDesde()!=null)&&(filtro.getFechaHasta()==null)){
			criteria.add(Restrictions.ge("fechaDesde",filtro.getFechaDesde()));
			
		}else if((filtro.getFechaDesde()!=null)&&(filtro.getFechaDesde()!=null)){
			criteria.add(Restrictions.ge("fechaDesde",filtro.getFechaDesde()));
			criteria.add(Restrictions.le("fechaHasta",filtro.getFechaHasta()));
		}else if((filtro.getFechaDesde()==null)&&(filtro.getFechaHasta()!=null)){
			criteria.add(Restrictions.le("fechaHasta",filtro.getFechaHasta()));
		}
		return this.findPageByCriteria(criteria, filtro.getPagina());

	}
	

}
