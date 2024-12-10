package com.nimap.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nimap.entities.ProductEntity;
import com.nimap.services.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductControllers {
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public Page<ProductEntity> getAllProducts(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
	     Pageable pageable = PageRequest.of(page, size);
	     return productService.getAllProducts(pageable);
	 }
	
	@PostMapping
	public ProductEntity createProduct(@RequestBody ProductEntity product) {
	     return productService.createProducts(product);
	 }
	
	@GetMapping("/{productId}")
	public ResponseEntity<ProductEntity> getProductById(@PathVariable Long productId) {
	     Optional<ProductEntity> product = productService.getProductById(productId);
	     return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	 }
	
	
	@PutMapping("/{productId}")
	public ResponseEntity<ProductEntity> updateProduct(@PathVariable Long productId, @RequestBody ProductEntity productDetails) {
	     ProductEntity updatedProduct = productService.updateProduct(productId, productDetails);
	     return ResponseEntity.ok(updatedProduct);
	 }
	
	@DeleteMapping("/{productId}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
	     productService.deleteProduct(productId);
	     return ResponseEntity.noContent().build();
	 }

}
