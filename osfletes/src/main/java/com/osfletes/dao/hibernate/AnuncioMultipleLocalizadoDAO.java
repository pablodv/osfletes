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
		
		StringBuffer sb =new StringBuffer();
		
		sb.append("from ANUNCIO_MULTIPLE aml where 1=1 ");
		
		Query query = null;
		
		if((filtro.getFechaDesde()!=null)){
			sb.append("and aml.fechaDesde>= :fechaDesde ");

		}
		if((filtro.getFechaHasta()!=null)){
			sb.append("and aml.fechaHasta>= :fechaHasta ");
			
		}
		if((filtro.getHoraDesde()!=null)){
			sb.append("and aml.horaDesde>= :horaDesde ");
			
		}
		if((filtro.getHoraHasta()!=null)){
			sb.append("and aml.horaHasta>= :horaHasta ");
			
		}
		if((filtro.getFechaCierre()!=null)){
			sb.append("and aml.fechaCierre>= :fechaCierre ");
			
		}
		
		query = this.createHqlQuery(sb.toString());
		query.setProperties(filtro);
		
		
		return this.findPageByQuery(query, filtro);

	}
	

}
