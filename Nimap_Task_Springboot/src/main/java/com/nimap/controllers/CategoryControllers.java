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

import com.nimap.entities.CategoryEntity;
import com.nimap.services.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryControllers {
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public Page<CategoryEntity> getAllCategories(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
	     Pageable pageable = PageRequest.of(page, size);
	     return categoryService.getAllCategories(pageable);
	 }
	
	@PostMapping
	public CategoryEntity createcategory(@RequestBody CategoryEntity category) {
		return categoryService.createCategory(category);
	}
	
	@GetMapping("/{categoryId}")
	public ResponseEntity<CategoryEntity> getCategoryById(@PathVariable Long categoryId) {
	     Optional<CategoryEntity> category = categoryService.getCategoryById(categoryId);
	     return category.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	 }
	
	@PutMapping("/{categoryId}")
	public ResponseEntity<CategoryEntity> updateCategory(@PathVariable Long categoryId, @RequestBody CategoryEntity categoryDetails) {
	     CategoryEntity updatedCategory = categoryService.updateCategory(categoryId, categoryDetails);
	     return ResponseEntity.ok(updatedCategory);
	 }
	
	@DeleteMapping("/{categoryId}")
	public ResponseEntity<Void> deleteCategory(@PathVariable Long categoryId) {
	     categoryService.deleteCategory(categoryId);
	     return ResponseEntity.noContent().build();
	 }
	
	
	
}
