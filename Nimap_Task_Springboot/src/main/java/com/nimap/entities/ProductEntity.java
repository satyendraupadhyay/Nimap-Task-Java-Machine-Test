package com.nimap.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ProductEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	private String productName;
	private double productPrice;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id")
	@JsonIgnoreProperties("products")
	private CategoryEntity category;
	
	//Constructors
	public ProductEntity() {
		
	}
	
	public ProductEntity(String productName, double productPrice, CategoryEntity category) {
		this.productName = productName;
		this.productPrice = productPrice;
		this.category = category;
	}
	
	//Getters and Setters

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}
	
	// toStringMethod
	 public String toString() {
	        return "Product{" +
	                "id=" + productId +
	                ", name='" + productName + '\'' +
	                ", price=" + productPrice +
	                ", category=" + category +
	                '}';
	    }
	
	
	
}
