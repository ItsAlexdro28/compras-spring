package com.miscompras.infrastructure.repositories.category;

import java.util.List;
import java.util.Optional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miscompras.application.services.CategoryService;
import com.miscompras.domain.entity.Category;

@Service
public class CategoryImpl implements CategoryService {


	@Autowired
	private CategoryRepository categoryRepository;

	@Transactional(readOnly = true)
	@Override
	public List<Category> findAll() {
		return (List<Category>) categoryRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Category> findById(Long id) {
		return categoryRepository.findById(id);
	}

	@Transactional
	@Override
	public Category save(Category category) {
		return categoryRepository.save(category);
	}

	@Transactional
	@Override
	public Optional<Category> update(Long id, Category category) {
		Optional<Category> categoryOld = categoryRepository.findById(id);
		if(categoryOld.isPresent()){
			Category categoryDb = categoryOld.orElseThrow();
			categoryDb.setDescripcion(category.getDescripcion());
			categoryDb.setEstado(category.getEstado());
			return Optional.of(categoryRepository.save(categoryDb));
		}
		return Optional.empty();
	}

	@Transactional
	@Override
	public Optional<Category> delete(Long id) {
		Optional<Category> categoryOptional = categoryRepository.findById(id);
		categoryOptional.ifPresent(categorytDb -> {
			Hibernate.initialize(categorytDb.getProductos());
			categoryRepository.delete(categorytDb);
		});
		return categoryOptional;
	}

}
