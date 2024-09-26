package com.miscompras.infrastructure.repositories.category;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.miscompras.domain.entity.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

}
