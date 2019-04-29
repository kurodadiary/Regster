package com.example.repository;

import javax.persistence.*;

@Entity
@Table(name = "account")
public class Account {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Integer id;	

private String name;	

  @Column(name="age")
  private Integer age;

  @Column(name="password")
  private String password;

  public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getAge() {
		return age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	  public Account() {};
	  
	  public Account(Integer id, String name, Integer age, String password) {
	      this.id = id;
	      this.name = name;
	      this.age = age;
	      this.password = password;
	  };
	
}