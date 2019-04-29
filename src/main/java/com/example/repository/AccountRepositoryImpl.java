package com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;

public class AccountRepositoryImpl {

	@Autowired
	AccountRepository repositry;
	
	public  Account find(String name) {
		return repositry.findByName(name);	
	}

}
