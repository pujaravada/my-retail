package com.pravada.retailapp.myRetail.dto;

public class ProductDescription {

	String title;

	String downstream_description;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDownstream_description() {
		return downstream_description;
	}

	public void setDownstream_description(String downstream_description) {
		this.downstream_description = downstream_description;
	}

	@Override
	public String toString() {
		return "ProductDescription [title=" + title + ", downstream_description=" + downstream_description + "]";
	}

}
