package com.osfletes.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.osfletes.model.Oferta;
import com.osfletes.web.dto.OfferFilterDTO;
import com.osfletes.web.model.ResultadoPaginado;

@Repository
public class OfertaDAO extends GenericHibernateDAO<Oferta> {

	
	@Autowired
	public OfertaDAO(SessionFactory sf) {
		super(sf);
	}

	@Override
	public Class<Oferta> getRepresentedClass() {
		return Oferta.class;
	}

	public ResultadoPaginado<Oferta> findOffers(OfferFilterDTO filter) {
		Criteria criteria = this.createCriteria();
		Criterion criterion = Restrictions.sqlRestriction(" 1 = 1");
		if(filter.getAnnouncementId()!=null){
			criterion = Restrictions.and(criterion, Restrictions.eq("anuncio.id", filter.getAnnouncementId()));
		}
		
		if(filter.getUsuarioCreacion()!=null){
			criterion = Restrictions.and(criterion, Restrictions.eq("usuarioCreacion.id", filter.getUsuarioCreacion()));
		}
		
		if(filter.getEstado() !=null){
			criterion = Restrictions.and(criterion, Restrictions.eq("state", filter.getEstado()));
		}
		
		criteria.add(criterion);
		return this.findPageByCriteria(criteria, filter);
	}

	public Oferta findOffers(Long announcementId, Long offerId) {
		Criteria criteria = this.createCriteria();
		criteria.add(Restrictions.and(Restrictions.eq("anuncio.id", announcementId), Restrictions.idEq(offerId)));
		return this.findUniqueByCriteria(criteria);
	}

	public List<Oferta> findNonSelectedOffers(Long announcementId, Long offerId) {
		Criteria criteria = this.createCriteria();
		criteria.add(Restrictions.not(Restrictions.eq("this_.id", offerId)));
		return this.findByCriteria(criteria);		
	}

	public boolean existOffer(Long offerId, Long providerId) {
		Criteria criteria = this.createCriteria();
		criteria.add(Restrictions.and(Restrictions.idEq(offerId),Restrictions.eq("usuarioCreacion.id", providerId)));
		return this.exist(criteria);
	}

}
