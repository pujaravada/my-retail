package com.pravada.retailapp.myRetail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pravada.retailapp.myRetail.dto.ProductInfoDTO;
import com.pravada.retailapp.myRetail.service.ProductService;

@RestController
@RequestMapping("myRetail")
public class ProductController {

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
			System.out.println("Exception occured in getProductInfoById..." + exception.getMessage());
		}
		return new ResponseEntity<>(productInfo, HttpStatus.OK);
	}

	@RequestMapping(value = "/products", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<ProductInfoDTO> updateProductInfoById(@RequestParam int productId,
			@RequestBody final ProductInfoDTO productInfoDTO) {
		ProductInfoDTO updateProductInfo = new ProductInfoDTO();
		try {
			updateProductInfo = productService.updateProductInfoById(productInfoDTO);
		} catch (final Exception exception) {
			System.out.println("Exception occured in update ProductInfoById..." + exception.getMessage());
		}
		return new ResponseEntity<>(updateProductInfo, HttpStatus.OK);

	}

}
