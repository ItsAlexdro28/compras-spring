package com.miscompras.application.services;

import java.util.List;
import java.util.Optional;

import com.miscompras.domain.entity.Sales_Products;

public interface Sales_ProductsService {
	
	List<Sales_Products> findAll();	

	Optional<Sales_Products> findById(Long id);

	Sales_Products save(Sales_Products sales_Products);

	Optional<Sales_Products> update(Long id, Sales_Products sales_Products);

	Optional<Sales_Products> delete(Long id);
}
