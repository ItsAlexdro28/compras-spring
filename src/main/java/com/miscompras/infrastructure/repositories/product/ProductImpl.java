package com.miscompras.infrastructure.repositories.product;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miscompras.application.services.ProductService;
import com.miscompras.domain.entity.Product;

@Service
public class ProductImpl implements ProductService {


	@Autowired
	private ProductRepository productRepository;

	@Transactional(readOnly = true)
	@Override
	public List<Product> findAll() {
		return (List<Product>) productRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Product> findById(Long id) {
		return productRepository.findById(id);
	}

	@Transactional
	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}

	@Transactional
	@Override
	public Optional<Product> update(Long id, Product product) {
		Optional<Product> productOld = productRepository.findById(id);
		if(productOld.isPresent()){
			Product productDb = productOld.orElseThrow();
			productDb.setNombre(product.getNombre());
			productDb.setCategoria(product.getCategoria());
			productDb.setCodigoBarras(product.getCodigoBarras());
			productDb.setPrecioVenta(product.getPrecioVenta());
			productDb.setCantidadStock(product.getCantidadStock());
			productDb.setEstado(product.getEstado());
			return Optional.of(productRepository.save(productDb));
		}
		return Optional.empty();
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Product> delete(Long id) {
		Optional<Product> productOptional = productRepository.findById(id);
		productOptional.ifPresent(producttDb -> {
			productRepository.delete(producttDb);
		});
		return productOptional;
	}

}
