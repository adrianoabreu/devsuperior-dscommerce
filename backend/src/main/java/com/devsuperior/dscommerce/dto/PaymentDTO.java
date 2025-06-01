package com.devsuperior.dscommerce.dto;

import java.time.Instant;

import com.devsuperior.dscommerce.entities.Payment;

//Esta classe representa o objeto payment(abaixo) do JSON com dados do pedido.
/*
* "payment" : {
* 		"id"  : 1,
* 		"moment": "2022-07-25T15:00:00Z"
	},
*/
public class PaymentDTO {

	private Long id;
	private Instant moment;
	
	public PaymentDTO(Long id, Instant moment) {
		this.id     = id;
		this.moment = moment;
	}
	
	public PaymentDTO(Payment entity) {
		id     = entity.getId();
		moment = entity.getMoment();
	}

	public Long getId() {
		return id;
	}

	public Instant getMoment() {
		return moment;
	}
	
	
	
	
}
