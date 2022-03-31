package com.luiz.casadocodigo.security;

import com.luiz.casadocodigo.daos.SecurityDao;
import com.luiz.casadocodigo.models.SystemUser;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Model
public class CurrentUser {

    @Inject
    private HttpServletRequest request;
    @Inject
    private SecurityDao securityDao;

    private SystemUser systemUser;

    @PostConstruct
    private void loadSystemUser(){
        Principal principal = request.getUserPrincipal();

        if(principal !=  null){
            String email = request.getUserPrincipal().getName();
            systemUser = securityDao.findByEmail(email);
        }
    }

    public SystemUser get(){
        return systemUser;
    }

    public boolean hasRole(String role){
        return request.isUserInRole(role);
    }

    public String logout(){
        request.getSession().invalidate();

        return "/livros/lista.xhtml?faces-redirect=true";
    }

}
