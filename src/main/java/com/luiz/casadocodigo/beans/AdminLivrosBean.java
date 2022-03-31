package com.luiz.casadocodigo.beans;

import java.io.IOException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;
import javax.transaction.Transactional;

import com.luiz.casadocodigo.daos.AutorDao;
import com.luiz.casadocodigo.daos.LivroDao;
import com.luiz.casadocodigo.infra.FileSaver;
import com.luiz.casadocodigo.models.Autor;
import com.luiz.casadocodigo.models.Livro;

// CDI
@Named
@RequestScoped
public class AdminLivrosBean {
	
	private Livro livro = new Livro(); 
	
	//Context and Dependency Injection
	@Inject
	private LivroDao dao;
	@Inject
	private AutorDao autorDao;
	@Inject
	private FacesContext context;
	
	private Part capaLivro;
		
	@Transactional
	public String salvar() throws IOException {
		dao.salvar(livro);
		FileSaver fileSaver = new FileSaver();
		livro.setCapaPath(fileSaver.writeArquivo(capaLivro, "capasLivros"));
		
		context.getExternalContext().getFlash().setKeepMessages(true);
		context.addMessage(null, new FacesMessage("Livro cadastrado com sucesso!"));;
		
		return "/livros/lista?faces-redirect=true";
	}

	public List<Autor> getAutores(){
		return autorDao.listar();
	}
	
	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Part getCapaLivro() {
		return capaLivro;
	}

	public void setCapaLivro(Part capaLivro) {
		this.capaLivro = capaLivro;
	}

}
