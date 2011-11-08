package com.osfletes.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.osfletes.service.IAnuncioService;

@Controller
public class AnuncioController {
	
	IAnuncioService anuncioService;
	
	@Autowired
	public void setAnuncioService(IAnuncioService anuncioService) {
		this.anuncioService = anuncioService;
	}


	@RequestMapping(value="/anuncio")
	public String saveAnuncio(HttpServletRequest request, HttpServletResponse response){
		return "redirect:index"; 
	}
	
}
