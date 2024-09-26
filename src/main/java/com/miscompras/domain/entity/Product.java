package com.miscompras.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 45, nullable = false)
	private String nombre;

	@ManyToOne
	private Category categoria;

	@Column(length = 120, nullable = false)
	private String codigo_barras;

	@Column(length = 20, nullable = false)
	private Long precio_venta;

	@Column(length = 30, nullable = false)
	private int catidad_stock;

	@Column(length = 10, nullable = false)
	private int estado;


}
