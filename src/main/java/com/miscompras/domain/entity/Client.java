package com.miscompras.domain.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "clientes")
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 40, nullable = false)
	private String nombre;

	@Column(length = 100, nullable = false)
	private String apellido;

	@Column(length = 10, nullable = false)
	private int celular;

	@Column(length = 80, nullable = false)
	private String dirreccion;

	@Column(length = 70, nullable = false)
	private String correo;

	@OneToMany(mappedBy = "cliente")
	@JsonIgnore
	private List<Sale> sale;

}
