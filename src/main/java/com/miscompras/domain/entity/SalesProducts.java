package com.miscompras.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.Data;

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

	public SalesProductsId getId() {
		return id;
	}

	public void setId(SalesProductsId id) {
		this.id = id;
	}

	public Sale getCompras() {
		return compras;
	}

	public void setCompras(Sale compras) {
		this.compras = compras;
	}

	public Product getProducto() {
		return producto;
	}

	public void setProducto(Product producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}


		
}
