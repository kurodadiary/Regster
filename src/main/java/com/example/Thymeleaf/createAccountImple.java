package com.example.Thymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class createAccountImple {
	
	//永続化
	@Autowired
	AccountRepositry repositry;
	
	public Account createAccount(Integer id, String name, Integer age, String password) {
			Account newRecord = new Account(id, name, age, password);
			repositry.save(newRecord);
	return newRecord;
	};
}
