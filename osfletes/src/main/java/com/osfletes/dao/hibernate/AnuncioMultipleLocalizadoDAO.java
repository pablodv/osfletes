package com.osfletes.dao.hibernate;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.osfletes.model.AnuncioMultipleLocalizado;
import com.osfletes.web.dto.FiltroAnuncioDTO;
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

	public ResultadoPaginado<AnuncioMultipleLocalizado> findAnuncios(FiltroAnuncioDTO filtro) {
		
		Query query = null;
		Criteria criteria = this.createCriteria();
		if((filtro.getFechaDesde()!=null)&&(filtro.getFechaHasta()==null)){
			query = this.createHqlQuery("from anuncioMultipeLocalizado aml where aml.fechaDesde>= :fechaDesde");
			query.setProperties(filtro);
			
		}else if((filtro.getFechaDesde()!=null)&&(filtro.getFechaDesde()!=null)){
			query = this.createHqlQuery("from anuncioMultipeLocalizado aml where aml.fechaDesde>= :fechaDesde and aml.fechaHasta <= :fechaHasta");
			query.setProperties(filtro);
			
			
		}else if((filtro.getFechaDesde()==null)&&(filtro.getFechaHasta()!=null)){
			query = this.createHqlQuery("from anuncioMultipeLocalizado aml where aml.fechaHasta <= :fechaHasta");
			query.setProperties(filtro);
			
			
		}
		
		return this.findPageByQuery(query, filtro.getPagina());

	}
	

}
