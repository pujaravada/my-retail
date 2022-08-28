package com.pravada.retailapp.myRetail.dto;

public class Item {

	ProductDescription product_description;

	public ProductDescription getProduct_description() {
		return product_description;
	}

	public void setProduct_description(ProductDescription product_description) {
		this.product_description = product_description;
	}

	@Override
	public String toString() {
		return "Item [product_description=" + product_description + "]";
	}

}
