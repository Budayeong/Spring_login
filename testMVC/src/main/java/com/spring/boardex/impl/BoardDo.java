package com.spring.boardex.impl;

public class BoardDo {
	private String id;
	private String name;
	private String password;
	private String number;
	
	@Override
	public String toString() {
		return "BoardDo [id=" + id + ", name=" + name + ", password=" + password + ", number=" + number + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
}
