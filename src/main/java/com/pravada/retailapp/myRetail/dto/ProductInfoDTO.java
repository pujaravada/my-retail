package com.pravada.retailapp.myRetail.dto;

public class ProductInfoDTO {

	private int id;

	private String productName;

	private ProductPriceDTO currentPrice;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public ProductPriceDTO getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(ProductPriceDTO currentPrice) {
		this.currentPrice = currentPrice;
	}

	@Override
	public String toString() {
		return "ProductInfoDTO [id=" + id + ", productName=" + productName + ", currentPrice="
				+ currentPrice + "]";
	}

}
