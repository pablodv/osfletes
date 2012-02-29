package com.osfletes.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.licitaciones.Workflow;
import com.licitaciones.exception.BusinessException;
import com.licitaciones.exception.InvalidTransactionException;
import com.osfletes.dao.interfaces.AnuncioMultipleDAO;
import com.osfletes.model.AnuncioMultipleLocalizado;
import com.osfletes.model.AnuncioWFTransactionsEnum;
import com.osfletes.service.interfaces.IAnuncioService;
import com.osfletes.service.interfaces.IDireccionService;
import com.osfletes.web.controller.JsonMesagesResolver;
import com.osfletes.web.dto.FiltroAnuncioDTO;
import com.osfletes.web.dto.ProviderAnnounceFilterDTO;
import com.osfletes.web.model.ResultadoPaginado;

@Service(value="anuncioMultipleLocalizadoService")
public class AnuncioMultipleLocalizadoService extends GenericServiceImplementacion<AnuncioMultipleLocalizado,AnuncioMultipleDAO> implements IAnuncioService{

	@Autowired
	IDireccionService direccionService;
	@Autowired
	@Qualifier(value="workflow-anuncio")
	Workflow workflow;
	

	public void setDireccionService(IDireccionService direccionService) {
		this.direccionService = direccionService;
	}
	

	@Override
	public ResultadoPaginado<AnuncioMultipleLocalizado> findAnuncios(FiltroAnuncioDTO filtro) {
		
		ResultadoPaginado<AnuncioMultipleLocalizado> resultadoPaginado = dao.findAnuncios(filtro);
		
		return resultadoPaginado;
	}

	

	@Override
	public void delete(Serializable anuncioId) {
		ejecutarAccion((Long)anuncioId, AnuncioWFTransactionsEnum.ELIMINAR.getName());
	}


	@Override
	public void publicarAnuncio(Long anuncioId) {
		ejecutarAccion(anuncioId, AnuncioWFTransactionsEnum.PUBLICAR.getName());
	}
	
	@Override
	public void  cancelarAnuncio(Long anuncioId){
		ejecutarAccion(anuncioId, AnuncioWFTransactionsEnum.CANCELAR.getName());
	}
	
	@Override
	public void seleccionarProveedor(Long anuncioId, Long ofertaId){
		ejecutarAccion(anuncioId, AnuncioWFTransactionsEnum.SELECCIONAR.getName(),ofertaId);
	}
	
	@Override
	public void cerrarAnuncio(Long anuncioId){
		ejecutarAccion(anuncioId, AnuncioWFTransactionsEnum.CERRAR.getName());
	}
	
	@Override
	public void cerrarVencido(Long anuncioId){
		ejecutarAccion(anuncioId, AnuncioWFTransactionsEnum.TERMINAR_VENCIDO.getName());
	}
	
	private void ejecutarAccion(Long anuncioId, String nombreTransaccion, Object... args){
		AnuncioMultipleLocalizado anuncio = this.getById(anuncioId);
		try {
			workflow.executeAction(anuncio.getEstado(), nombreTransaccion ,anuncio, args);
		} catch (InvalidTransactionException e) {
			throw new BusinessException(JsonMesagesResolver.getMessage("error.action.invalid", null, null));
		}
		
		this.saveOrUpdate(anuncio);
	}


	@Override
	public Serializable save(AnuncioMultipleLocalizado entity) {
		try {
			workflow.initWorkflow(entity);
		} catch (Exception e) {
			throw new BusinessException(JsonMesagesResolver.getMessage("error.action.invalid", null, null));
		}
		
		return super.save(entity);
	}


	@Override
	public AnuncioMultipleLocalizado findAnuncio(Long announcementId,
			Long userId) {
		return dao.findAnnoucement(announcementId,userId);
	}


	@Override
	public boolean existAnnouncement(Long announcementId, Long userId) {
		return dao.existAnnouncement(announcementId,userId);		
	}


	@Override
	public ResultadoPaginado<AnuncioMultipleLocalizado> findAnuncios(ProviderAnnounceFilterDTO filter) {
		return this.dao.findAnuncios(filter);
	}

	
}
