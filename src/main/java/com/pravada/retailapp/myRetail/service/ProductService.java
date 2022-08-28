package com.pravada.retailapp.myRetail.service;

import com.pravada.retailapp.myRetail.dto.ProductInfoDTO;

public interface ProductService {

	public ProductInfoDTO getProductInfoById(int productId);
	
	public ProductInfoDTO updateProductInfoById(ProductInfoDTO productInfoDTO);


}
