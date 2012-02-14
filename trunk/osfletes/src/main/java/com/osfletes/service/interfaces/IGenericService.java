package com.osfletes.service.interfaces;

import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

public interface IGenericService<T> {

  /**
   * Crea una nueva entidad.
   * 
   * @param entity
   * @return representacion del id generado
   */
  @Transactional
  public Serializable save(T entity);

  /**
   * Elimina la entidad.
   * 
   * @param entity
   */
  @Transactional
  public void delete(T entity);

  /**
   * Retorna todas las instancias de la Entidad representada.
   * 
   * @return List con 0 o mas elementos
   */
  @Transactional(readOnly=true)
  public List<T> getAll();

  /**
   * Crea o Actualiza la entidad, dependiendo si tiene o no un id seteado
   * existente.
   * 
   * @param entity
   */
  @Transactional
  public void saveOrUpdate(T entity);

  /**
   * Crea una nueva instancia.
   * 
   * @param entity
   */
  @Transactional
  public void persist(T entity);

  /**
   * Retorna una instancia de la Entidad representada por el parametro id<br/>
   * 
   * @param id
   * @return
   */
  @Transactional(readOnly=true)
  public T load(Serializable id);

  /**
   * Actualiza. y si el nombre lo dice todo
   * 
   * @param entity
   */
  @Transactional
  public void update(T entity);

  @Transactional(readOnly=true)
  public T getById(Serializable id);
  
  @Transactional
  public void delete(Serializable entityId);
}
