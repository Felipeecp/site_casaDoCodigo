package com.luiz.casadocodigo.daos;

import com.luiz.casadocodigo.models.SystemUser;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class SecurityDao {

    @PersistenceContext
    private EntityManager manager;

    public SystemUser findByEmail(String email){

        return manager.createQuery("select su from SystemUser  su " +
                 "where su.email = :email", SystemUser.class)
                .setParameter("email", email)
                .getSingleResult();

    }

}
