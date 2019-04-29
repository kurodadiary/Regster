package com.example.controller;

import java.security.NoSuchAlgorithmException;
import java.util.Date;

import org.mahjong4j.HandsOverFlowException;
import org.mahjong4j.IllegalMentsuSizeException;
import org.mahjong4j.MahjongTileOverFlowException;
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

import com.example.repository.Account;
import com.example.repository.AccountRepository;
import com.example.service.Authorization;
import com.example.service.Mahjong;
import com.example.util.hashSha2;

/**
 *
 * @author kuroda
 */
@Controller
@EnableAutoConfiguration
public class AppController {
  
	@Autowired
	AccountRepository repository;

	@Autowired
	Authorization authorization;
	
    @GetMapping({"/"})
    public String login(Model model) {

    	// 日時を取得、設定
		model.addAttribute("now", new Date().toString());
		model.addAttribute("message", "WELLCOME TO MY PAGE!");
		return "login";
    }

    @PostMapping({"/hello"})
    public String hello(@RequestParam(required=false) String name, String password, Model model) throws NoSuchAlgorithmException {
    	boolean isAuthrized = authorization.isAuthorized(name, password);
    	if(isAuthrized) {
        	model.addAttribute("name", name);
        	return "hello";
    	}else {
			model.addAttribute("message", "your authorization is failed, please try again");
			model.addAttribute("now", new Date().toString());
			return "login";
		}
    }

    @GetMapping({"/createAccount"})
    public String create(Model model) {
        return "createAccount";
    }

    @PostMapping({"/register"})
    public String regist(@RequestParam(required=false) Integer id,String name,Integer age,String password,Model model) throws NoSuchAlgorithmException {
    	String hash = new hashSha2().convertToSha256(password);
    	Account account = new Account(id, name, age, hash);
		repository.save(account);

		model.addAttribute("name", account.getName());
    	model.addAttribute("age", account.getAge());
    	model.addAttribute("password", account.getPassword());
		
    	return "createAccountResult";
    }
    
    @GetMapping({"/error"})	
    public String error(Model model) {
        return "error";
    }

    @GetMapping({"/mahjong"})
    public String mahjong(Model model) throws HandsOverFlowException, MahjongTileOverFlowException, IllegalMentsuSizeException {
    	Mahjong majong = new Mahjong();
    	majong.sample();
    	return "hello";
    }


}