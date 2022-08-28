package com.pravada.retailapp.myRetail.dto;

public class Product {

	int tcin;

	Item item;

	public int getTcin() {
		return tcin;
	}

	public void setTcin(int tcin) {
		this.tcin = tcin;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "Product [tcin=" + tcin + ", item=" + item + "]";
	}

}
