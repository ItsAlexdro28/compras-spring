package com.miscompras.domain.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class SalesProductsId implements Serializable{

	private Long compraId;
	private Long productoId;

}
