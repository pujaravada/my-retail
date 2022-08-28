package com.pravada.retailapp.myRetail.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.pravada.retailapp.myRetail.Modal.ProductPricing;

public interface ProductRepository extends MongoRepository<ProductPricing, String> {

//	@Query("{productName:'?0'}")
//	ProductPricing findItemByName(String name);

	@Query("{'productId' : ?0}")
	ProductPricing findByProductId(Integer id);

//	@Query(value = "{category:'?0'}", fields = "{'productName' : 1, 'quantity' : 1}")
//	List<ProductPricing> findAll(String category);

	public long count();

	@Query("{'ProductPricing' : ?0}")
	ProductPricing saveOrUpdate(ProductPricing productPricing);


}