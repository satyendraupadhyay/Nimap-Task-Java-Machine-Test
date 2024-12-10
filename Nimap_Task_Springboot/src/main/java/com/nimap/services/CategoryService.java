package com.nimap.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nimap.entities.CategoryEntity;

public interface CategoryService {
	
	Page<CategoryEntity> getAllCategories(Pageable pageable);
	
	CategoryEntity createCategory(CategoryEntity category);
	
	Optional<CategoryEntity> getCategoryById(Long categoryId);
	
	CategoryEntity updateCategory(Long categoryId, CategoryEntity categoryDetails);
	
	void deleteCategory(Long categoryId);
	
}
