package com.pravada.retailapp.myRetail.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RedskyClientProductResponseDTO {

	Data data;

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "RedskyClientProductResponseDTO [data=" + data + "]";
	}

}
