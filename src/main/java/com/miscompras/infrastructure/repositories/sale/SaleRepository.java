package com.miscompras.infrastructure.repositories.sale;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.miscompras.domain.entity.Sale;

@Repository
public interface SaleRepository extends CrudRepository<Sale, Long> {

}
