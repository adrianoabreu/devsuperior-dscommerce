package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.OrderItem;

//Esta classe representa o objeto OrderItem(abaixo) do JSON com dados do pedido.
/*
* "items" : [
*     {
* 		  "productId"  : 1,
* 		  "name": "The Lord of the Rings"
		  "price": 90.5,
		  "quantity": 2,
		  "subTotal": 181.0
	  },
	  {
* 		  "productId"  : 3,
* 		  "name": "Macbook Pro"
		  "price": 1250.5,
		  "quantity": 1,
		  "subTotal": 1250.0
	  }
	],
*/
public class OrderItemDTO {

	private Long productId;
	private String name;
	private Double price;
	private Integer quantity;
	
	public OrderItemDTO(Long productId, String name, Double price, Integer quantity) {
		this.productId = productId;
		this.name      = name;
		this.price     = price;
		this.quantity  = quantity;
	}
	
	public OrderItemDTO(OrderItem entity) {
		productId = entity.getProduct().getId();
		name      = entity.getProduct().getName();
		price     = entity.getPrice();
		quantity  = entity.getQuantity();
	}

	public Long getProductId() {
		return productId;
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}

	public Integer getQuantity() {
		return quantity;
	}
	
	public Double getSubTotal() {
		return price * quantity;
	}
	
	
}
