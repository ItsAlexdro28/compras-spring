package com.miscompras.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class Sales_Products {

	@EmbeddedId
	private Sales_ProductsId id = new Sales_ProductsId();

	@ManyToOne
	@MapsId("compraId")
	@JoinColumn(name = "compra_id")
	private Sale compras;

	@ManyToOne
	@MapsId("productoId")
	@JoinColumn(name = "producto_id")
	private Product producto;
	
	@Column(length = 50, nullable = false)
	private int cantidad;

	@Column(length = 50, nullable = false)
	private Float total;

	@Column(length = 10, nullable = false)
	private int estado;


		
}
