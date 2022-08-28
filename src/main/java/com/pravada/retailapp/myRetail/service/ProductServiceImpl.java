package com.pravada.retailapp.myRetail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pravada.retailapp.myRetail.Modal.ProductPricing;
import com.pravada.retailapp.myRetail.dto.ProductInfoDTO;
import com.pravada.retailapp.myRetail.dto.ProductPriceDTO;
import com.pravada.retailapp.myRetail.dto.RedskyClientProductResponseDTO;
import com.pravada.retailapp.myRetail.redskyClient.RedskyClient;
import com.pravada.retailapp.myRetail.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private RedskyClient redskyClient;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public ProductInfoDTO getProductInfoById(int productId) {
		final ProductInfoDTO productInfo = new ProductInfoDTO();
		try {

			// GET CALL to get product name
			RedskyClientProductResponseDTO clientProductResponse = redskyClient.getProductInfo(productId);

			productInfo.setId(clientProductResponse.getData().getProduct().getTcin());
			productInfo.setProductName(
					clientProductResponse.getData().getProduct().getItem().getProduct_description().getTitle());

			// DB call to get pricing info
			ProductPriceDTO productPriceDTO = new ProductPriceDTO();

			ProductPricing productPricingInfo = getProductPricingById(productId);

			productPriceDTO.setProductPrice(productPricingInfo.getPrice());
			productPriceDTO.setCurrencyCode(productPricingInfo.getCurrencyCode());
			productInfo.setCurrentPrice(productPriceDTO);

		} catch (final Exception e) {
			System.out.println("Exception occured in service call for getProductInfoById..." + e.getMessage());

		}

		return productInfo;
	}

	public ProductPricing getProductPricingById(Integer id) {
		System.out.println("Getting product pricing by id: " + id);
		ProductPricing productPricing = new ProductPricing();
		// DB CALL
		productPricing = productRepository.findByProductId(id);
		System.out.println(productPricing.toString());
		return productPricing;
	}

	@Override
	public ProductInfoDTO updateProductInfoById(ProductInfoDTO productInfoDTO) {

		// DB CALL to get product name and old price
		ProductPricing productPricing = productRepository.findByProductId(productInfoDTO.getId());

		// set variabkes to be edited
		productPricing.setPrice(productInfoDTO.getCurrentPrice().getProductPrice());
		
		System.out.println("Product pricing to be uodated is .. "+productPricing);

		// Update DB with new price
		ProductPricing updateProductPricing = productRepository.saveOrUpdate(productPricing);

		
		if(null != updateProductPricing) {
			// Return new price object in response
			ProductPriceDTO newPriceInfo = new ProductPriceDTO();
			newPriceInfo.setProductPrice(updateProductPricing.getPrice());
			newPriceInfo.setCurrencyCode(updateProductPricing.getCurrencyCode());
			productInfoDTO.setCurrentPrice(newPriceInfo);
		} else { 
			System.out.println("Price not updated");
			productInfoDTO = null;
		}
		
		return productInfoDTO;
	}

}
