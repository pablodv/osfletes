package com.osfletes.dao.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.osfletes.model.AnuncioMultipleLocalizado;
import com.osfletes.web.dto.FiltroDTO;

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

	public List<AnuncioMultipleLocalizado> findAnuncios(FiltroDTO filtro) {
		Query q=null;
		if((filtro.getFechaDesde()!=null)&&(filtro.getFechaDesde()==null)){
			q = createHqlQuery("select aml from AnuncioMultipleLocalizado aml where aml.fechaDesde > :fechaDesde");
			q.setParameter(":fechaDesde", filtro.getFechaDesde());
		}else if((filtro.getFechaDesde()!=null)&&(filtro.getFechaDesde()!=null)){
			q = createHqlQuery("select aml from AnuncioMultipleLocalizado aml where aml.fechaDesde >= :fechaDesde and aml.fechaHasta<= :fechaHasta");
			q.setParameter(":fechaDesde", filtro.getFechaDesde());
			q.setParameter(":fechaHasta", filtro.getFechaHasta());
		}
		
		return q.list();
		
	}



	

}
