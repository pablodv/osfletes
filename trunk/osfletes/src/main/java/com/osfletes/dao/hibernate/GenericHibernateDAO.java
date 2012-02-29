package com.osfletes.dao.hibernate;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.osfletes.dao.interfaces.IGenericDAO;
import com.osfletes.web.dto.GenericFilterDTO;
import com.osfletes.web.model.ResultadoPaginado;

/**
 * Implementacion Generica para <i><b>Hibernate</b></i> y <i><b>Spring</b></i>,
 * superclase de todo Data Access Object.<br/>
 * Contiene implementaciones de metodos de operaciones <b>CRUD</b> basicas.
 * 
 * @author gaston
 * 
 * @param <T>
 */
@SuppressWarnings("unchecked")
public abstract class GenericHibernateDAO<T> extends HibernateDaoSupport
		implements IGenericDAO<T> {

	protected Class<T> representedClass;
	//protected final Integer PAGE_SIZE = 20;
	

	public abstract Class<T> getRepresentedClass();
	
	public GenericHibernateDAO(SessionFactory sf) {
		this.setSessionFactory(sf);
		representedClass = getRepresentedClass();
	}

	@Override
	public Serializable save(T entity) {
		return getHibernateTemplate().save(entity);
	}

	@Override
	public void delete(T entity) {
		getHibernateTemplate().delete(entity);
	}
	
	@Override
	public List<T> findAll() {
		return (List<T>) getHibernateTemplate().loadAll(representedClass);
	}

	@Override
	public void saveOrUpdate(T entity) {
		getHibernateTemplate().saveOrUpdate(entity);
	}

	@Override
	public void persist(T entity) {
		getHibernateTemplate().persist(entity);
	}

	@Override
	public T load(Serializable id) {
		return (T) getHibernateTemplate().load(representedClass, id);
	}

	@Override
	public void update(T entity) {
		getHibernateTemplate().update(entity);
	}

	@Override
	public void persistAll(List<T> entities) {
		for (T entity : entities) {
			this.persist(entity);
		}
	}

	@Override
	public T findById(Serializable id) {
		return (T) getHibernateTemplate().load(representedClass, id);
	}

	/**
	 * Crea una Instancia de una Implmentacion de la
	 * interfaz<i>org.hibernate.Criteria</i> para la clase representada.
	 * 
	 * @return Criteria
	 */
	protected Criteria createCriteria() {
		return getSession().createCriteria(representedClass);
	}
	
	protected Criteria createCriteria(String alias) {
		return getSession().createCriteria(representedClass,alias);
	}

	/**
	 * Crea una Instancia de una Implmentacion de la
	 * interfaz<i>org.hibernate.Criteria</i> para la clase pasada por parametro.
	 * 
	 * @return Criteria
	 */
	protected Criteria createCriteriaForClass(Class clazz) {
		return getSession().createCriteria(clazz);
	}

	/**
	 * Ejecuta la busqueda por el "criterio" indicado.
	 * 
	 * @param criterion
	 * @return List con 0 o mas elementos.
	 */
	protected List<T> findByCriteria(Criteria criteria) {
		return criteria.list();
	}

	/**
	 * Ejecuta la busqueda por el "criterio" indicado<br/>
	 * retorna un elemento o null si no existe quien cumpla con el criterio
	 * 
	 * @param criterion
	 * @return
	 * @throws Exception
	 * @throws NegocioExcepcion
	 *             : si existe mas de un elemento para el criterio
	 */
	protected T findUniqueByCriteria(Criteria criteria) {
		List<T> results = findByCriteria(criteria);
		if (results.size() > 1) {
			throw new RuntimeException("No unique");
		}

		return results.isEmpty() ? null : results.get(0);
	}

	/**
	 * Ejecuta la busqueda por el "criterio" indicado<br/>
	 * retorna un elemento si no existe quien cumpla con el criterio lanza una
	 * exception
	 * 
	 * @param criterion
	 * @return
	 * @throws Exception
	 * @throws NegocioExcepcion
	 *             : si existe mas de un elemento para el criterio
	 */
	protected T loadUniqueByCriteria(Criteria criteria) {
		T result = this.findUniqueByCriteria(criteria);
		if (result == null) {
			throw new RuntimeException("No existe");
		}

		return result;
	}

	/**
	 * Creat an instance of Query for the HQL statement
	 * 
	 * @param hqlQuery HQL statement
	 * @return
	 */
	protected Query createHqlQuery(String hqlQuery) {
		return getSession().createQuery(hqlQuery);
	}

	/**
	 * 
	 * @param criteria
	 * @return
	 */
	protected boolean exist(Criteria criteria) {
		List<T> results = findByCriteria(criteria);
		return results != null && results.size() > 0;
	}

	/**
	 * Retorna la cuenta de la busqueda
	 * @param criteria
	 * @return
	 */
	protected Integer count(Criteria criteria) {
		
		Integer count = (Integer) criteria.setProjection(Projections.rowCount()).uniqueResult();
		criteria.setProjection(null);
		criteria.setResultTransformer(Criteria.ROOT_ENTITY);
		return count;
	}
	
	
	/**
     * Ejecuta la busqueda por el "criterio" indicado.
     * @param criterion
     * @return List con 0 o mas elementos.
     */
	protected List<T> findByCriterion(Criterion criterion){
        Criteria criteria = createCriteria().add(criterion);
        return findByCriteria(criteria);
    }
    
    
     /**
     * Ejecuta la busqueda por el "criterio" indicado<br/>
     * retorna un elemento o null si no existe quien cumpla con el criterio
     * @param criterion
     * @return
     * @throws Exception 
     * @throws NegocioExcepcion: si existe mas de un elemento para el criterio
     */
    protected T findUniqueByCriterion(Criterion criterion) {
        List<T> results = findByCriterion(criterion);
        if(results.size() > 1){
                throw new RuntimeException("No unique");
        }
        
        return results.isEmpty()? null: results.get(0); 
    }
    
    /**
     * Ejecuta la busqueda por el "criterio" indicado<br/>
     * retorna un elemento si no existe quien cumpla con el criterio lanza una exception
     * @param criterion
     * @return
     * @throws Exception 
     * @throws NegocioExcepcion: si existe mas de un elemento para el criterio
     */
    protected T loadUniqueByCriteria(Criterion criterion) {
      T result = this.findUniqueByCriterion(criterion);
      if(result == null){
        throw new RuntimeException("No existe");
      }
      
      return result;
    }
    
    protected <E extends GenericFilterDTO> ResultadoPaginado<T> findPageByCriteria(Criteria criteria, E filterDTO){
    	ResultadoPaginado<T> resultado = new ResultadoPaginado<T>();
    	resultado.setPagina(filterDTO.getPage());
    	
    	resultado.setCantidad( new Double(Math.ceil(new Float(count(criteria))/new Float(filterDTO.getPageSize()))).intValue()  );

    	
    	criteria.setFirstResult(filterDTO.getPageSize() * (filterDTO.getPage()-1));
        criteria.setMaxResults(filterDTO.getPageSize());
        resultado.setResultados(findByCriteria(criteria));
        return resultado;
    }

    protected <E extends GenericFilterDTO> ResultadoPaginado<T> findPageByQuery(Query query, E filterDTO){
    	ResultadoPaginado<T> resultado = new ResultadoPaginado<T>();
    	resultado.setPagina(filterDTO.getPage());
    	resultado.setCantidad( new Double(Math.ceil(count(query)/filterDTO.getPageSize())).intValue()  );

    	query.setFirstResult(filterDTO.getPageSize() * (filterDTO.getPage()-1));
        query.setMaxResults(filterDTO.getPageSize());
        resultado.setResultados(findByQuery(query));
        return resultado;
    }

	private Integer count(Query query) {
		Integer count = (Integer) query.list().size();
		return count;
	}

	private List<T> findByQuery(Query query) {
		return query.list();
	}
    
}
