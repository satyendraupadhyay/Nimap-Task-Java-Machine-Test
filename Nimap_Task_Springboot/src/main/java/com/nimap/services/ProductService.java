package com.nimap.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nimap.entities.ProductEntity;

public interface ProductService {
	
	Page<ProductEntity> getAllProducts(Pageable pageable);
	
	ProductEntity createProducts(ProductEntity product);
	
	Optional<ProductEntity> getProductById(Long productId);
	
	ProductEntity updateProduct(Long productId, ProductEntity productDetails);
	
	void deleteProduct(Long productId);
	
	

}
