package com.ecommercesolution.ecommerceapplication.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Embeddable
public class Address {

	
	private String addressline1;
	private String addressline2;
	private String city;
	private String state;
	private String zip;
	
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Address(String addressline1, String addressline2, String city, String state, String zip) {
		super();
		this.addressline1 = addressline1;
		this.addressline2 = addressline2;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}


	public String getAddressline1() {
		return addressline1;
	}


	public void setAddressline1(String addressline1) {
		this.addressline1 = addressline1;
	}


	public String getAddressline2() {
		return addressline2;
	}


	public void setAddressline2(String addressline2) {
		this.addressline2 = addressline2;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getZip() {
		return zip;
	}


	public void setZip(String zip) {
		this.zip = zip;
	}
	
	
}
