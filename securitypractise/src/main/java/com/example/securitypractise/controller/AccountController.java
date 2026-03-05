package com.example.securitypractise.controller;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.securitypractise.dto.AccountRequestDTO;
import com.example.securitypractise.dto.AccountResponseDTO;
import com.example.securitypractise.service.AccountService;

@RestController
public class AccountController {

	private  AccountService service;
	
	public AccountController(AccountService service) {
		super();
		this.service = service;
	}



	@PostMapping("/create")
	public AccountResponseDTO create(@RequestBody AccountRequestDTO dto) {
		return service.createAccount(dto);
	}
	
	
}
