package com.luiz.casadocodigo.beans;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.luiz.casadocodigo.daos.LivroDao;
import com.luiz.casadocodigo.models.CarrinhoCompras;
import com.luiz.casadocodigo.models.CarrinhoItem;
import com.luiz.casadocodigo.models.Livro;

@Model
public class CarrinhoComprasBean {

	@Inject
	private LivroDao livroDao;
	
	@Inject
	private CarrinhoCompras carrinho;
	
	public String add(Integer id) {
		Livro livro = livroDao.buscarPorId(id);
		CarrinhoItem item = new CarrinhoItem(livro);
		carrinho.add(item);
		
		return "carrinho?faces-redirect=true";
	}
	
	public List<CarrinhoItem> getItens(){
		return carrinho.getItens();
	}
	
	public void remover(CarrinhoItem item) {
		carrinho.remover(item);
	}
}
