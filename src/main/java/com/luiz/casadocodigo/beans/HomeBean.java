package com.luiz.casadocodigo.beans;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.luiz.casadocodigo.daos.LivroDao;
import com.luiz.casadocodigo.models.Livro;

@Model
public class HomeBean {
	
	
	@Inject
	private LivroDao dao;
	
	public List<Livro> ultimosLancamentos(){
		
		return dao.ultimosLancamentos();
		
	}
	
	public List<Livro> demaisLivros(){
		return dao.demaisLivros();
	}
	
	
}
