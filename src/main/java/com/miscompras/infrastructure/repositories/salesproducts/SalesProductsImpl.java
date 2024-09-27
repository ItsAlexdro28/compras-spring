package com.miscompras.infrastructure.repositories.salesproducts;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miscompras.application.services.SalesProductsService;
import com.miscompras.domain.entity.SalesProducts;
import com.miscompras.domain.entity.SalesProductsId;

@Service
public class SalesProductsImpl implements SalesProductsService {


	@Autowired
	private SalesProductsRepository salesProductsRepository;

	@Transactional(readOnly = true)
	@Override
	public List<SalesProducts> findAll() {
		return (List<SalesProducts>) salesProductsRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<SalesProducts> findById(SalesProductsId id) {
		return salesProductsRepository.findById(id);
	}

	@Transactional
	@Override
	public SalesProducts save(SalesProducts salesProducts) {
		return salesProductsRepository.save(salesProducts);
	}

	@Transactional
	@Override
	public Optional<SalesProducts> update(SalesProductsId id, SalesProducts salesProducts) {
		Optional<SalesProducts> salesProductsOld = salesProductsRepository.findById(id);
		if(salesProductsOld.isPresent()){
			SalesProducts salesProductsDb = salesProductsOld.orElseThrow();
			salesProductsDb.setCompras(salesProducts.getCompras());
			salesProductsDb.setProducto(salesProducts.getProducto());
			salesProductsDb.setCantidad(salesProducts.getCantidad());
			salesProductsDb.setTotal(salesProducts.getTotal());
			salesProductsDb.setEstado(salesProducts.getEstado());
			return Optional.of(salesProductsRepository.save(salesProductsDb));
		}
		return Optional.empty();
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<SalesProducts> delete(SalesProductsId id) {
		Optional<SalesProducts> salesProductsOptional = salesProductsRepository.findById(id);
		salesProductsOptional.ifPresent(salesProductstDb -> {
			salesProductsRepository.delete(salesProductstDb);
		});
		return salesProductsOptional;
	}

}
