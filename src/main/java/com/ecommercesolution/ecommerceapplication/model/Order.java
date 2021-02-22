package com.ecommercesolution.ecommerceapplication.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "ORDERTABLE")
public class Order {
	
	@Id
	@GeneratedValue
	private long order_id;
	private String order_status;
	private long order_customer_id;
	private LocalDate updated;
	
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "addressline1", column = @Column(name = "SHIPPING_addressline1")),
		 @AttributeOverride(name = "addressline2", column = @Column(name = "SHIPPING_addressline2")),
			@AttributeOverride(name = "city", column = @Column(name = "SHIPPING_CITY")),
			@AttributeOverride(name = "state", column = @Column(name = "SHIPPING_state")),
			@AttributeOverride(name = "zip", column = @Column(name = "SHIPPING_ZIP")),})
	private Address shippingAddress = new Address();

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "addressline1", column = @Column(name = "BILLING_addressline1")),
		 @AttributeOverride(name = "addressline2", column = @Column(name = "BILLING_addressline2")),
			@AttributeOverride(name = "city", column = @Column(name = "BILLING_CITY")),
			@AttributeOverride(name = "state", column = @Column(name = "BILLING_state")),
			@AttributeOverride(name = "zip", column = @Column(name = "BILLING_ZIP")),})
	private Address billingAddress = new Address();

	@OneToMany(cascade = CascadeType.ALL)
	private List<OrderLine> orderLine;
	
	public Order() {
		super();
		orderLine = new ArrayList<>();
		updated();
	}

	private void updated() {
		updated = LocalDate.now();
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		updated();
		this.shippingAddress = shippingAddress;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		updated();
		this.billingAddress = billingAddress;
	}

	public void setId(long id) {
		this.order_id = id;
	}

	public long getId() {
		return order_id;
	}

	public LocalDate getUpdated() {
		return updated;
	}

	public void setUpdated(LocalDate created) {
		this.updated = created;
	}



	public List<OrderLine> getOrderLine() {
		return orderLine;
	}



	public void setOrderLine(List<OrderLine> orderLine) {
		this.orderLine = orderLine;
		updated();
	}

	public void addLine( int count,Item item) {
		this.orderLine.add(new OrderLine( item,count));
		updated();
	}

	public int getNumberOfLines() {
		return orderLine.size();
	}

	public double totalPrice() {
		return orderLine.stream().map((ol) -> ol.getOrder_item_qty() * ol.getItem().getOrder_subtotal()).reduce(0.0, (d1, d2) -> d1 + d2);
	}
	
	

}
