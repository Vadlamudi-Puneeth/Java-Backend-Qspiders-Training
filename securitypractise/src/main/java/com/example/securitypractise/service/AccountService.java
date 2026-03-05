package com.example.securitypractise.service;

import java.time.LocalDateTime;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.securitypractise.dto.AccountRequestDTO;
import com.example.securitypractise.dto.AccountResponseDTO;
import com.example.securitypractise.entity.Account;
import com.example.securitypractise.repo.AccountJpaRepository;

@Service
public class AccountService {

	private AccountJpaRepository jpa;
	
	private PasswordEncoder encode;
	
	public AccountService(AccountJpaRepository jpa, PasswordEncoder encode) {
		this.jpa = jpa;
		this.encode = encode;
	}
	
	
	public AccountResponseDTO createAccount(AccountRequestDTO dto) {
		if(jpa.existsByUsername(dto.getUsername())){
			throw new RuntimeException("User Name already exist");
		}
		if(jpa.existsByEmail(dto.getEmail())) {
			throw new RuntimeException("User Email already exist");
		}
		
		Account account = new Account();
		
		account.setUsername(dto.getUsername());
		account.setFullName(dto.getFullName());
		account.setPassword(encode.encode(dto.getPassword()));
		account.setPhone(dto.getPhone());
		account.setCreatedAt(LocalDateTime.now());
		account.setEmail(dto.getEmail());
		account.setRole(normalizeAndValidateRole(dto.getRole()));
		
	    Account saved = jpa.save(account);

	    return toResponse(saved);
	}
	
	
	public String normalizeAndValidateRole(String role) {
		if(role == null || role.trim().isEmpty()) {
			return "ROLE_USER";
		}
		String r = role.trim().toUpperCase();
		if(!r.startsWith("ROLE_")) {
			r = "ROLE_" + r;
		}
		
		if(!r.equalsIgnoreCase("ROLE_USER") && !r.equalsIgnoreCase("ROLE_ADMIN")) {
			throw new RuntimeException("Invalid role for Authorization");
		}
		
		return r;
	}
	
	public AccountResponseDTO toResponse(Account a) {
		AccountResponseDTO dto = new AccountResponseDTO();
		dto.setEmail(a.getEmail());
		dto.setFullName(a.getFullName());
		dto.setUsername(a.getUsername());
		
		return dto;
		
	}
	
}
