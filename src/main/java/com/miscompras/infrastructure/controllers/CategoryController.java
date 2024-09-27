package com.miscompras.infrastructure.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miscompras.application.services.CategoryService;
import com.miscompras.domain.entity.Category;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping
	public List<Category> list() {
		return categoryService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> view(@PathVariable Long id) {
		Optional<Category> categoryOptional = categoryService.findById(id);
		if (categoryOptional.isPresent()) {	
			return ResponseEntity.ok(categoryOptional.orElseThrow());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<?> create(@RequestBody Category category) {
		return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.save(category));
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Category category, @PathVariable Long id) {
		Optional<Category> categoryOptional = categoryService.update(id, category);
		if (categoryOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.CREATED).body(categoryOptional.orElseThrow());
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Optional<Category> categoryOptional = categoryService.delete(id);
		if (categoryOptional.isPresent()) {
			return ResponseEntity.ok(categoryOptional.orElseThrow());
		}
		return ResponseEntity.notFound().build();
	}

}
