package com.nimap.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nimap.entities.ProductEntity;

public interface ProductRepo extends JpaRepository<ProductEntity, Long>{

}
