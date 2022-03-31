package com.luiz.casadocodigo.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SystemRole {

	@Id
	private String name;
	
	public SystemRole() {}
	
	public SystemRole(String nome) {
		this.name = nome;
	}

	public String getNome() {
		return name;
	}

	public void setNome(String nome) {
		this.name = nome;
	}
	
	
	
}
