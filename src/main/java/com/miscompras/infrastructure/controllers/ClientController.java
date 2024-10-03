package com.miscompras.infrastructure.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miscompras.application.services.ClientService;
import com.miscompras.domain.entity.Client;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/client")
public class ClientController {

	@Autowired
	private ClientService clientService;

	@GetMapping
	public List<Client> list() {
		return clientService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> view(@PathVariable Long id) {
		Optional<Client> clientOptional = clientService.findById(id);
		if (clientOptional.isPresent()) {	
			return ResponseEntity.ok(clientOptional.orElseThrow());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<?> create(@RequestBody Client client) {
		return ResponseEntity.status(HttpStatus.CREATED).body(clientService.save(client));
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Client client, @PathVariable Long id) {
		Optional<Client> clientOptional = clientService.update(id, client);
		if (clientOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.CREATED).body(clientOptional.orElseThrow());
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Optional<Client> clientOptional = clientService.delete(id);
		if (clientOptional.isPresent()) {
			return ResponseEntity.ok(clientOptional.orElseThrow());
		}
		return ResponseEntity.notFound().build();
	}

}
