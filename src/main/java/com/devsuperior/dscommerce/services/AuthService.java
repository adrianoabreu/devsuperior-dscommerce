package com.devsuperior.dscommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dscommerce.entities.User;
import com.devsuperior.dscommerce.services.exceptions.ForbiddenException;

// Objetivo: Implementar regras de negocio relacionadas a controle de acesso de Admin e Cliente;

@Service
public class AuthService {

	@Autowired
	private UserService userService;
	
	//Metodo que lanca retorno 403 caso o usuario não seja Admin ou não seja o usuário userId passado no parametro.
	public void validateSelfOrAdmin(Long userId) {
		User me = userService.authenticated();
		if (!me.hasRole("ROLE_ADMIN") && !me.getId().equals(userId)) {
			throw new ForbiddenException("Access denied");
		}
	}
}
