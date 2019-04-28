package com.example.Thymeleaf;

import org.springframework.beans.factory.annotation.Autowired;

public class AccountRepositryImpl {

	@Autowired
	AccountRepositry repositry;
	
	public  Account find(String name) {
		return repositry.findByname(name);	
	}

}
