package com.osfletes.model.hibernate;



import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.CallbackException;
import org.hibernate.Session;
import org.hibernate.classic.ValidationFailure;
import org.springframework.security.core.context.SecurityContextHolder;

import com.osfletes.security.User;

/**
 * Implementacion de Superclase para todo objeto persistente<br/>
 * Implementa un id autogenerado de tipo uuid y pose el campos:<br/>
 * fecha de Creacion, fecha de Modificacion, Usuario.
 * @author gaston.dubra
 *
 */
@MappedSuperclass
public abstract class ObjetoPersistente implements IObjetoPersistente {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected Long id;
	
	@Temporal(TemporalType.DATE)
    @Column(name="FECHA_ULTIMA_MODIFICACION")
	protected Date fechaModificacion;
	@Temporal(TemporalType.DATE)
    @Column(name="FECHA_CREACION")
	protected Date fechaCreacion;
	
	@ManyToOne(targetEntity=User.class, fetch=FetchType.LAZY)
	@JoinColumn(name="USR_CREACION")
	protected User usuarioCreacion;
	@ManyToOne(targetEntity=User.class, fetch=FetchType.LAZY)
	@JoinColumn(name="USR_MODIFICACION")
	protected User usuarioModificacion;

	@Override
	public void validate() throws ValidationFailure {
				
	}


	@Override
	public boolean onDelete(Session arg0) throws CallbackException {
		return false;
	}


	@Override
	public void onLoad(Session arg0, Serializable arg1) {
		
	}


	@Override
	public boolean onSave(Session arg0) throws CallbackException {
		this.setFechaCreacion(new Date());
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof User && ! (this instanceof User)) {
			usuarioCreacion = (User) principal;
		}

		return false;
	}


	@Override
	public boolean onUpdate(Session arg0) throws CallbackException {
		this.setFechaModificacion(new Date());

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof User) {
			usuarioModificacion = (User) principal;
		}
		return false;
	}


	public Date getFechaModificacion() {
		return fechaModificacion;
	}


	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}


	public Date getFechaCreacion() {
		return fechaCreacion;
	}


	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public boolean equals(Object o) {
        if ( this == o ) {
            return true;
        }
        if ( !(o instanceof ObjetoPersistente) ) {
            return false;
        }
        ObjetoPersistente objeto = (ObjetoPersistente)o;
        if ( this.getId() != null ? !this.getId().equals(objeto.getId()) : this.getId() != null ) {
            return false;
        }

        return true;
    }


    public int hashCode() {
        if (this.getId() != null )
        	return this.getId().hashCode();
        else
        	throw new RuntimeException("el objeto no posee Id");
    }


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	


	
}
