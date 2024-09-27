package com.miscompras.infrastructure.repositories.product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.miscompras.domain.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}
