package com.osfletes.dao.interfaces;

import java.io.Serializable;
import java.util.List;

public interface IGenericDAO<T> {
     /**
     * Crea una nueva entidad.
     * @param entity
     * @return representacion del id generado
     */
    public Serializable save(T entity);

    /**
     * Elimina la entidad.
     * @param entity
     */
    public void delete(T entity) ;

    /**
     * Retorna todas las instancias de la Entidad representada.
     * @return List con 0 o mas elementos
     */
    public List<T> findAll();

    /**
     * Crea o Actualiza la entidad, dependiendo si tiene o no un id seteado existente.
     * @param entity
     */
    public void saveOrUpdate(T entity);

    /**
     * Crea una nueva instancia.
     * @param entity
     */
    public void persist(T entity);

    /**
     * Retorna una instancia de la Entidad representada por el parametro id<br/>
     * @param id
     * @return
     */
    public T load(Serializable id);

    /**
     * Actualiza. y si el nombre lo dice todo
     * @param entity
     */
    public void update(T entity);
    
    /**
     * persiste todas las entities
     * @param entities
     */
    public void persistAll(List<T> entities);

    /**
     * Load an entity by id
     * @param id
     */
    public T findById(Serializable id);
}
