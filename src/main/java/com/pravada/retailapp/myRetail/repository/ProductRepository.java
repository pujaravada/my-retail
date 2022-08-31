package com.pravada.retailapp.myRetail.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.pravada.retailapp.myRetail.Modal.ProductPricing;

public interface ProductRepository extends MongoRepository<ProductPricing, String> {

	@Query("{'productId' : ?0}")
	ProductPricing findByProductId(Integer id);

}