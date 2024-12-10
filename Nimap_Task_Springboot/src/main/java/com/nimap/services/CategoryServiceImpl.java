package com.nimap.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nimap.entities.CategoryEntity;
import com.nimap.repositories.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	private CategoryRepo categoryRepo;

	public Page<CategoryEntity> getAllCategories(Pageable pageable) {
		return categoryRepo.findAll(pageable);
	}

	public CategoryEntity createCategory(CategoryEntity category) {
		return categoryRepo.save(category);
	}

	public Optional<CategoryEntity> getCategoryById(Long categoryId) {
		return categoryRepo.findById(categoryId);
	}

	public CategoryEntity updateCategory(Long categoryId, CategoryEntity categoryDetails) {
		CategoryEntity category = categoryRepo.findById(categoryId).orElseThrow(() -> new RuntimeException("Category not found"));
		category.setCategoryName(categoryDetails.getCategoryName());
		return categoryRepo.save(category);
	}

	public void deleteCategory(Long categoryId) {
		categoryRepo.deleteById(categoryId);
	}

}
