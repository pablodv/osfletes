package com.osfletes.model.hibernate;



import java.io.Serializable;
import java.util.Date;

import org.hibernate.classic.Lifecycle;
import org.hibernate.classic.Validatable;

public interface IObjetoPersistente extends Validatable, Lifecycle, Serializable {
	
	/**
     *  Todos los objetos persistentes deberian implementar este metodo para obtener la fecha de creacion
     * 
     * @return date correspondiente a la fecha de creacion
     */
    Date getFechaCreacion();

    /**
     *  Todos los objetos persistentes deberian implementar este metodo para setear la fecha de creacion
     * 
     * @param date correspondiente a la fecha de modificacion.
     */
    void setFechaModificacion(Date date);
    
    /**
     *  Todos los objetos persistentes deberian implementar este metodo que permite obtener una fecha de creacion
     * 
     * @return Date de la fecha de modificacion del objeto
     */
    Date getFechaModificacion();
    
    /**
     * Todos los objetos persistentes deberian implementar este metodo que permite setear una fecha de creacion
     * @param date
     */
    void setFechaCreacion(Date date);
}
