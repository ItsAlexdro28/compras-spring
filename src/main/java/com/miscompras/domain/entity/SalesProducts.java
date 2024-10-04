package com.miscompras.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class SalesProducts {

	@EmbeddedId
	private SalesProductsId id = new SalesProductsId();

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
