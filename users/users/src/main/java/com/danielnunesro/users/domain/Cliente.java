package com.danielnunesro.users.domain;

public class Cliente {
	
	private Long id;
	
	private String name;
	
	private String cpf;
	
	private int age;
	
	public Cliente() {
		
	}

	public Cliente(String name, String cpf, int age) {
		super();
		this.name = name;
		this.cpf = cpf;
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	
	
}
