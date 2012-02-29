package com.osfletes.service;

import org.springframework.stereotype.Service;

import com.osfletes.service.interfaces.IMailService;

@Service(value="mailService")
public class MailService implements IMailService {

	@Override
	public void sendMail() {
		System.out.println("service");		
	}

}
