package com.miscompras.infrastructure.repositories.sale;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miscompras.application.services.SaleService;
import com.miscompras.domain.entity.Sale;

@Service
public class SaleImpl implements SaleService {


	@Autowired
	private SaleRepository saleRepository;

	@Transactional(readOnly = true)
	@Override
	public List<Sale> findAll() {
		return (List<Sale>) saleRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Sale> findById(Long id) {
		return saleRepository.findById(id);
	}

	@Transactional
	@Override
	public Sale save(Sale sale) {
		return saleRepository.save(sale);
	}

	@Transactional
	@Override
	public Optional<Sale> update(Long id, Sale sale) {
		Optional<Sale> saleOld = saleRepository.findById(id);
		if(saleOld.isPresent()){
			Sale saleDb = saleOld.orElseThrow();
			saleDb.setCliente(sale.getCliente());
			saleDb.setFecha(sale.getFecha());
			saleDb.setMedioPago(sale.getMedioPago());
			saleDb.setComentario(sale.getComentario());
			saleDb.setEstado(sale.getEstado());
			return Optional.of(saleRepository.save(saleDb));
		}
		return Optional.empty();
	}

	@Transactional
	@Override
	public Optional<Sale> delete(Long id) {
		Optional<Sale> saleOptional = saleRepository.findById(id);
		saleOptional.ifPresent(saletDb -> {
			saleRepository.delete(saletDb);
		});
		return saleOptional;
	}

}
