package com.spring.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
     
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String email;
    public User() {
    	
    }
	public User(String name, String string) {
		this.name = name;
		this.email= string;
	}
	@Override
	public String toString() {
		return String.format("User [id=%s, name=%s, email=%s]", id, name, email);
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}

}