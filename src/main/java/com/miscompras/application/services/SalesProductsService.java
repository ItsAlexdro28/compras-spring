package com.miscompras.application.services;

import java.util.List;
import java.util.Optional;

import com.miscompras.domain.entity.SalesProducts;
import com.miscompras.domain.entity.SalesProductsId;

public interface SalesProductsService {
	
	List<SalesProducts> findAll();	

	Optional<SalesProducts> findById(SalesProductsId id);

	SalesProducts save(SalesProducts salesProducts);

	Optional<SalesProducts> update(SalesProductsId id, SalesProducts salesProducts);

	Optional<SalesProducts> delete(SalesProductsId id);
}
