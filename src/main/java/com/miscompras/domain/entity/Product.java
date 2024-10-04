package com.miscompras.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "productos")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 45, nullable = false)
	private String nombre;

	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Category categoria;

	@Column(length = 120, nullable = false)
	private String codigoBarras;

	@Column(length = 20, nullable = false)
	private Long precioVenta;

	@Column(length = 30, nullable = false)
	private int cantidadStock;

	@Column(length = 10, nullable = false)
	private int estado;

	
}
