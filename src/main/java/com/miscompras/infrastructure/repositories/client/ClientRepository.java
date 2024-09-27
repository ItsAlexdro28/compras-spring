package com.miscompras.infrastructure.repositories.client;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.miscompras.domain.entity.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

}
