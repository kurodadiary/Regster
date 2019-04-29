package com.example.service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.repository.Account;
import com.example.repository.AccountRepository;
import com.example.util.hashSha2;

@Service
public class Authorization {
	

	//永続化
	@Autowired
	AccountRepository repository;

	public boolean isAuthorized(String name, String password) throws NoSuchAlgorithmException {
    	String hashedPassword = new hashSha2().convertToSha256(password);
    	
    	Account target = repository.findByNameAndPassword(name, hashedPassword);
		return (target != null);
	}
}
