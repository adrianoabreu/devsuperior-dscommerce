package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.User;

//Esta classe representa o objeto client(abaixo) do JSON com dados do pedido.
/*
 * "client" : {
 * 		"id"  : 1,
 * 		"name": "Maria Brown"
	},
*/
public class ClientDTO {

	private Long id;
	private String name;
	
	public ClientDTO(Long id, String name) {
		this.id   = id;
		this.name = name;
	}
	
	public ClientDTO(User entity) {
		id   = entity.getId();
		name = entity.getName();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}	
	
}
