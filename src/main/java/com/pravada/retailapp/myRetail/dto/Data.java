package com.pravada.retailapp.myRetail.dto;

public class Data {

	Product product;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Data [product=" + product + "]";
	}

}
