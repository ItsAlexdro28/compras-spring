package com.miscompras.infrastructure.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miscompras.application.services.SalesProductsService;
import com.miscompras.domain.entity.SalesProducts;
import com.miscompras.domain.entity.SalesProductsId;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/salesProducts")
public class SalesProductsController {

	@Autowired
	private SalesProductsService salesProductsService;

	@GetMapping
	public List<SalesProducts> list() {
		return salesProductsService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> view(@PathVariable SalesProductsId id) {
		Optional<SalesProducts> salesProductsOptional = salesProductsService.findById(id);
		if (salesProductsOptional.isPresent()) {	
			return ResponseEntity.ok(salesProductsOptional.orElseThrow());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<?> create(@RequestBody SalesProducts salesProducts) {
		return ResponseEntity.status(HttpStatus.CREATED).body(salesProductsService.save(salesProducts));
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody SalesProducts salesProducts, @PathVariable SalesProductsId id) {
		Optional<SalesProducts> salesProductsOptional = salesProductsService.update(id, salesProducts);
		if (salesProductsOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.CREATED).body(salesProductsOptional.orElseThrow());
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable SalesProductsId id) {
		Optional<SalesProducts> salesProductsOptional = salesProductsService.delete(id);
		if (salesProductsOptional.isPresent()) {
			return ResponseEntity.ok(salesProductsOptional.orElseThrow());
		}
		return ResponseEntity.notFound().build();
	}

}
