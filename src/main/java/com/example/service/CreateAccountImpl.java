package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.repository.Account;
import com.example.repository.AccountRepository;

@Service
public class CreateAccountImpl {
	
	//永続化
	@Autowired
	AccountRepository repositry;
	
	public Account createAccount(Integer id, String name, Integer age, String password) {
			Account newRecord = new Account(id, name, age, password);
			repositry.save(newRecord);
	return newRecord;
	};
}
