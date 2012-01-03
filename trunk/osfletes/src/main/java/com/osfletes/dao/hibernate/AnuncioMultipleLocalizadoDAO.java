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
		if((filtro.getFechaDesde()!=null)&&(filtro.getFechaHasta()==null)){
			q = createHqlQuery("select aml from anuncioMultipeLocalizado aml where aml.fechaDesde > :fechaDesde");
			//q.setParameter(":fechaDesde", filtro.getFechaDesde());
			q.setProperties(filtro);
		}else if((filtro.getFechaDesde()!=null)&&(filtro.getFechaDesde()!=null)){
			q = createHqlQuery("from anuncioMultipeLocalizado as aml where (aml.fechaDesde > :fechaDesde) and (aml.fechaHasta < :fechaHasta)");
			q.setProperties(filtro);
		}else if((filtro.getFechaDesde()==null)&&(filtro.getFechaHasta()!=null)){
			q = createHqlQuery("select aml from anuncioMultipeLocalizado aml where aml.fechaHasta < :fechaHasta");
			//q.setParameter(":fechaHasta", filtro.getFechaHasta());
			q.setProperties(filtro);
		}
		List<AnuncioMultipleLocalizado> lista = q.list();
		return lista;
		
	}



	

}
