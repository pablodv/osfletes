package com.osfletes.dao.hibernate;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
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

	/*
	public ResultadoPaginado<AnuncioMultipleLocalizado> findAnuncios(FiltroDTO filtro) {
		Criteria criteria = this.createCriteria();
		criteria.add(Restrictions.eq("horaDesde", 12));
		//TODO FIND ANUNCIOS
		return this.findPageByCriteria(criteria, filtro.getPagina());
	}
	*/
	
	public ResultadoPaginado<AnuncioMultipleLocalizado> findAnuncios(FiltroDTO filtro) {
		Criteria criteria = this.createCriteria();
		//criteria.add(Restrictions.eq("horaDesde", 12));
		
		
		//Query q=null;
		if((filtro.getFechaDesde()!=null)&&(filtro.getFechaHasta()==null)){
			
		    String pattern = "yyyy-MM-dd";
		    SimpleDateFormat format = new SimpleDateFormat(pattern);
		    String formattedFechaDesde = format.format(filtro.getFechaDesde());			
			
			Format formatter = new SimpleDateFormat();
			//criteria.add(Restrictions.sqlRestriction("FECHA_DESDE > (?)",formattedFechaDesde, Hibernate.STRING));
						
			criteria.add(Restrictions.lt("fechaDesde",filtro.getFechaDesde()));
			
			
			//q = createHqlQuery("select aml from anuncioMultipeLocalizado aml where aml.fechaDesde > :fechaDesde");
			//q.setProperties(filtro);
		}else if((filtro.getFechaDesde()!=null)&&(filtro.getFechaDesde()!=null)){
			//q = createHqlQuery("from anuncioMultipeLocalizado as aml where (aml.fechaDesde > :fechaDesde) and (aml.fechaHasta < :fechaHasta)");
			//q.setProperties(filtro);
			criteria.add(Expression.ge("fechaDesde",filtro.getFechaDesde()));
			criteria.add(Expression.le("fechaHasta",filtro.getFechaHasta()));
		}else if((filtro.getFechaDesde()==null)&&(filtro.getFechaHasta()!=null)){
			//q = createHqlQuery("select aml from anuncioMultipeLocalizado aml where aml.fechaHasta < :fechaHasta");
			//q.setProperties(filtro);
			criteria.add(Expression.le("fechaHasta",filtro.getFechaHasta()));
		}
		//List<AnuncioMultipleLocalizado> lista = q.list();
		//return lista;
		return this.findPageByCriteria(criteria, filtro.getPagina());

	}
	

}
