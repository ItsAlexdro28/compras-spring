package com.miscompras.infrastructure.repositories.client;

import java.util.List;
import java.util.Optional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miscompras.application.services.ClientService;
import com.miscompras.domain.entity.Client;

@Service
public class ClientImpl implements ClientService {


	@Autowired
	private ClientRepository clientRepository;

	@Transactional(readOnly = true)
	@Override
	public List<Client> findAll() {
		return (List<Client>) clientRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Client> findById(Long id) {
		return clientRepository.findById(id);
	}

	@Transactional
	@Override
	public Client save(Client client) {
		return clientRepository.save(client);
	}

	@Transactional
	@Override
	public Optional<Client> update(Long id, Client client) {
		Optional<Client> clientOld = clientRepository.findById(id);
		if(clientOld.isPresent()){
			Client clientDb = clientOld.orElseThrow();
			clientDb.setNombre(client.getNombre());
			clientDb.setApellido(client.getApellido());
			clientDb.setCelular(client.getCelular());
			clientDb.setDirreccion(client.getDirreccion());
			clientDb.setCorreo(client.getCorreo());
			clientDb.setSale(client.getSale());
			return Optional.of(clientRepository.save(clientDb));
		}
		return Optional.empty();
	}

	@Transactional
	@Override
	public Optional<Client> delete(Long id) {
		Optional<Client> clientOptional = clientRepository.findById(id);
		clientOptional.ifPresent(clienttDb -> {
			Hibernate.initialize(clienttDb.getSale());
			clientRepository.delete(clienttDb);
		});
		return clientOptional;
	}

}
