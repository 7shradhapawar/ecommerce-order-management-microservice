package com.ecommercesolution.ecommerceapplication.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Item {

	@Id
	@GeneratedValue
	private Long itemId;
	private String order_item_name;
	private double order_subtotal;
	
	
	public Item(Long itemId, String order_item_name, double order_subtotal) {
		super();
		this.itemId = itemId;
		this.order_item_name = order_item_name;
		this.order_subtotal = order_subtotal;
	}


	public Long getItemId() {
		return itemId;
	}


	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}


	public String getOrder_item_name() {
		return order_item_name;
	}


	public void setOrder_item_name(String order_item_name) {
		this.order_item_name = order_item_name;
	}


	public double getOrder_subtotal() {
		return order_subtotal;
	}


	public void setOrder_subtotal(double order_subtotal) {
		this.order_subtotal = order_subtotal;
	}
	
	
	
}
