package com.luiz.casadocodigo.beans;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.luiz.casadocodigo.daos.LivroDao;
import com.luiz.casadocodigo.models.Livro;

@Model
public class LivroDetalheBean {

	@Inject
	private LivroDao dao;
	private Livro livro;
	private Integer id;
	
	public void carregaDetalhe() {
		this.setLivro(dao.buscarPorId(getId()));
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
}
