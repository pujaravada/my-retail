package com.pravada.retailapp.myRetail.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

	public static Logger logger = LogManager.getLogger(ProductServiceImpl.class);

	@Autowired
	private RedskyClient redskyClient;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public ProductInfoDTO getProductInfoById(int productId) {
		final ProductInfoDTO productInfo = new ProductInfoDTO();
		try {
			logger.info("Entering the RedSky client... ");

			// GET CALL to get product name
			RedskyClientProductResponseDTO clientProductResponse = redskyClient.getProductInfo(productId);

			productInfo.setId(clientProductResponse.getData().getProduct().getTcin());
			productInfo.setProductName(
					clientProductResponse.getData().getProduct().getItem().getProduct_description().getTitle());

			// DB call to get pricing info
			ProductPriceDTO productPriceDTO = new ProductPriceDTO();
			ProductPricing productPricingInfo = getProductPricingById(productId);

			if (productPricingInfo != null) {

				productPriceDTO.setProductPrice(productPricingInfo.getPrice());
				productPriceDTO.setCurrencyCode(productPricingInfo.getCurrencyCode());
				productInfo.setCurrentPrice(productPriceDTO);
			} else {
				logger.warn("ProductPricing is missing from the db");
			}

		} catch (final Exception e) {
			logger.error("Exception occured in service call for getProductInfoById..." + e.getMessage());

		}

		return productInfo;
	}

	/**
	 * gets the product pricing from db
	 * 
	 * @param id
	 * @return
	 */
	public ProductPricing getProductPricingById(Integer id) {
		logger.info("Getting product pricing by id: " + id);
		ProductPricing productPricing = new ProductPricing();
		// DB CALL
		productPricing = productRepository.findByProductId(id);
		return productPricing;
	}

}
