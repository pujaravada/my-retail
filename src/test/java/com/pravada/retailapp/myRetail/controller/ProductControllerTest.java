package com.pravada.retailapp.myRetail.controller;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.pravada.retailapp.myRetail.dto.ProductInfoDTO;
import com.pravada.retailapp.myRetail.dto.ProductPriceDTO;
import com.pravada.retailapp.myRetail.service.ProductService;

@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {

	private ProductController productController;

	@Test
	public void testGetProductInfoById() {
		// given
		ProductService mockService = Mockito.mock(ProductService.class);
		productController = new ProductController();
		productController.setProductService(mockService);
		Mockito.when(mockService.getProductInfoById(Mockito.any())).thenReturn(getProductInfo());

		// when
		ResponseEntity<ProductInfoDTO> productInfoDTO = productController.getProductInfoById(13860428);

		// then
		Assert.assertEquals(productInfoDTO.getBody(), mockService.getProductInfoById(Mockito.any()));
	}

	private ProductInfoDTO getProductInfo() {
		ProductInfoDTO productInfoDTO = new ProductInfoDTO();
		productInfoDTO.setId(13860428);
		productInfoDTO.setProductName("The Big Lebowski (Blu-ray)");
		ProductPriceDTO productPriceDTO = new ProductPriceDTO();
		productPriceDTO.setCurrencyCode("USD");
		BigDecimal price = new BigDecimal(17.45);
		productPriceDTO.setProductPrice(price);
		productInfoDTO.setCurrentPrice(productPriceDTO);
		return productInfoDTO;
	}

}
