package com.osfletes.dao.hibernate;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.osfletes.dao.interfaces.AnuncioMultipleDAO;
import com.osfletes.model.AnuncioMultipleLocalizado;
import com.osfletes.web.dto.FiltroAnuncioDTO;
import com.osfletes.web.dto.ProviderAnnounceFilterDTO;
import com.osfletes.web.model.ResultadoPaginado;

@Repository
public class AnuncioMultipleLocalizadoDAO extends GenericHibernateDAO<AnuncioMultipleLocalizado> implements AnuncioMultipleDAO {

	@Autowired
	public AnuncioMultipleLocalizadoDAO(SessionFactory sf) {
		super(sf);
	}

	@Override
	public Class<AnuncioMultipleLocalizado> getRepresentedClass() {
		return AnuncioMultipleLocalizado.class;
	}

	@Override
	public ResultadoPaginado<AnuncioMultipleLocalizado> findAnuncios(FiltroAnuncioDTO filtro) {
		
		StringBuffer sb =new StringBuffer();
		
		sb.append("from ANUNCIO_MULTIPLE aml where 1=1 ");
		
		Query query = null;
		
		if((filtro.getFechaDesde()!=null)){
			sb.append("and aml.fechaDesde>= :fechaDesde ");

		}
		if((filtro.getFechaHasta()!=null)){
			sb.append("and aml.fechaHasta<= :fechaHasta ");
			
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
		
		if(filtro.getUsuarioCreacion() != null){
			sb.append("and aml.usuarioCreacion.id = :usuarioCreacion ");
		}
		
		if(filtro.getEstado()!=null){
			sb.append("and aml.estado = :estado ");
		}
		
		query = this.createHqlQuery(sb.toString());
		query.setProperties(filtro);
		
		
		return this.findPageByQuery(query, filtro);

	}

	@Override
	public AnuncioMultipleLocalizado findAnnoucement(Long announcementId,Long userId) {
		Criteria criteria = this.createCriteria();
		criteria.add(Restrictions.and(Restrictions.idEq(announcementId),Restrictions.eq("usuarioCreacion.id", userId)));
		return this.loadUniqueByCriteria(criteria);
	}

	@Override
	public boolean existAnnouncement(Long announcementId, Long userId) {
		Criteria criteria = this.createCriteria();
		criteria.add(Restrictions.and(Restrictions.idEq(announcementId),Restrictions.eq("usuarioCreacion.id", userId)));
		return this.exist(criteria);
	}

	@Override
	public ResultadoPaginado<AnuncioMultipleLocalizado> findAnuncios(ProviderAnnounceFilterDTO filter) {
		Criteria criteria = this.createCriteria();
		Criterion criterion = Restrictions.sqlRestriction(" this_.id not in (SELECT ANUNCIO_ID FROM oferta o where USR_CREACION = "+ filter.getProviderId()+")");
		
		if(filter.getStateId() != null){
			criterion = Restrictions.and(criterion, Restrictions.eq("estado", filter.getStateId()));
		}
		
		criteria.add(criterion);
		return this.findPageByCriteria(criteria, filter);
	}

	
	

}
