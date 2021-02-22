package com.ecommercesolution.ecommerceapplication.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OrderLine {
	
	@ManyToOne
	private Item item;

	@Id
	@GeneratedValue
	private long id;
	
	@Column(name = "F_COUNT")
	private int order_item_qty;
	
	public OrderLine() {
		
	}

	public OrderLine(Item item, int order_item_qty) {
	
		this.item = item;
		this.order_item_qty = order_item_qty;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getOrder_item_qty() {
		return order_item_qty;
	}

	public void setOrder_item_qty(int order_item_qty) {
		this.order_item_qty = order_item_qty;
	}
	
	

}
