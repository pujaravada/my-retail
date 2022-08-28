package com.pravada.retailapp.myRetail.dto;

import java.math.BigDecimal;

public class ProductPriceDTO {

	// TODO : Rename json to value
	private BigDecimal productPrice;

	private String currencyCode;

	public BigDecimal getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	@Override
	public String toString() {
		return "ProductPriceDTO [productPrice=" + productPrice + ", currencyCode=" + currencyCode + "]";
	}

}
