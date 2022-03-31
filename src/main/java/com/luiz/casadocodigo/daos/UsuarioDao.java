package com.luiz.casadocodigo.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.luiz.casadocodigo.models.Usuario;

public class UsuarioDao {

	@PersistenceContext
	private EntityManager manager;
	
	public void salvar(Usuario usuario) {
		manager.persist(usuario);
	}
	
}
