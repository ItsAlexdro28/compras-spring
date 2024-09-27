package com.miscompras.infrastructure.repositories.salesproducts;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.miscompras.domain.entity.SalesProducts;
import com.miscompras.domain.entity.SalesProductsId;

@Repository
public interface SalesProductsRepository extends CrudRepository<SalesProducts, SalesProductsId> {

}
