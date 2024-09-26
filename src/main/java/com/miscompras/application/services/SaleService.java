package com.miscompras.application.services;

import java.util.List;
import java.util.Optional;

import com.miscompras.domain.entity.Sale;

public interface SaleService {
	
	List<Sale> findAll();	

	Optional<Sale> findById(Long id);

	Sale save(Sale sale);

	Optional<Sale> update(Long id, Sale sale);

	Optional<Sale> delete(Long id);
}
