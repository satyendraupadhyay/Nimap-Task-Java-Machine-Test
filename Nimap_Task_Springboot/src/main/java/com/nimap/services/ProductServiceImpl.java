package com.nimap.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nimap.entities.ProductEntity;
import com.nimap.repositories.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductRepo productRepo;

	public Page<ProductEntity> getAllProducts(Pageable pageable) {
		return productRepo.findAll(pageable);
	}

	public ProductEntity createProducts(ProductEntity product) {
		return productRepo.save(product);
	}

	public Optional<ProductEntity> getProductById(Long productId) {
		return productRepo.findById(productId);
	}

	public ProductEntity updateProduct(Long productId, ProductEntity productDetails) {
		ProductEntity product = productRepo.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
		product.setProductName(productDetails.getProductName());
		product.setProductPrice(productDetails.getProductPrice());
		return productRepo.save(product);
	}

	public void deleteProduct(Long productId) {
		productRepo.deleteById(productId);
	}

}
