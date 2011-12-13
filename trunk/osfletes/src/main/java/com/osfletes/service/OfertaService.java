package com.osfletes.service;

import org.springframework.stereotype.Service;

import com.osfletes.dao.hibernate.OfertaDAO;
import com.osfletes.model.Oferta;
import com.osfletes.service.interfaces.IOfertaService;

@Service(value="ofertaService")
public class OfertaService extends GenericServiceImplementacion<Oferta,OfertaDAO> implements IOfertaService {

}
