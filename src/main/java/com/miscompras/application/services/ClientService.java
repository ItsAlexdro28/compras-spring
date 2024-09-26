package com.miscompras.application.services;

import java.util.List;
import java.util.Optional;

import com.miscompras.domain.entity.Client;

public interface ClientService {
	
	List<Client> findAll();	

	Optional<Client> findById(Long id);

	Client save(Client client);

	Optional<Client> update(Long id, Client client);

	Optional<Client> delete(Long id);
}
