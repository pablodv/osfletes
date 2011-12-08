package com.osfletes.service;

import org.springframework.stereotype.Service;

import com.osfletes.dao.OfertaDAO;
import com.osfletes.model.Oferta;

@Service(value="ofertaService")
public class OfertaService extends GenericSienaServiceImpl<Oferta,OfertaDAO> implements IOfertaService {

}
