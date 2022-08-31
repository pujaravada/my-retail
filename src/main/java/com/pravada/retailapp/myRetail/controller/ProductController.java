package com.pravada.retailapp.myRetail.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pravada.retailapp.myRetail.dto.ProductInfoDTO;
import com.pravada.retailapp.myRetail.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("myRetail")
@Slf4j
public class ProductController {

	public static Logger logger = LogManager.getLogger(ProductController.class);

	@Autowired
	ProductService productService;


	@RequestMapping(value = "/products", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<ProductInfoDTO> getProductInfoById(@RequestParam int productId) {
		ProductInfoDTO productInfo = new ProductInfoDTO();
		try {
			productInfo = productService.getProductInfoById(productId);
		} catch (final Exception exception) {
			logger.error("Exception occured in getProductInfoById..." + exception.getMessage());
		}
		return new ResponseEntity<>(productInfo, HttpStatus.OK);
	}

	// For Unit testing
	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

}
