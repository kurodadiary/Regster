package com.example.Thymeleaf;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author kuroda
 */
@Controller
@EnableAutoConfiguration
public class App {
  
	@Autowired
	AccountRepositry repository;

    @GetMapping({"/"})
    public String login(Model model) {

    	// 日時を取得、設定
		model.addAttribute("now", new Date().toString());

    	return "login";
    }

    @PostMapping({"/hello"})
  public String hello(@RequestParam(required=false) String name, Integer age,Model model) {
    	Account targetRecord = repository.findByname(name) ;
    	if(targetRecord == null) {
    		return "wrongAccount";
    	}
    	model.addAttribute("name", targetRecord.getName());
    	model.addAttribute("age", targetRecord.getAge());
    	return "hello";
    }

    @GetMapping({"/createAccount"})
    public String create(Model model) {
        return "createAccount";
    }

    @PostMapping({"/register"})
    public String regist(@RequestParam(required=false) Integer id,String name,Integer age,String password,Model model) {
    	Account account = new Account(id, name, age, password);
		repository.save(account);

		model.addAttribute("name", account.getName());
    	model.addAttribute("age", account.getAge());
    	model.addAttribute("password", account.getPassword());
		
    	return "createAccountResult";
    }

}