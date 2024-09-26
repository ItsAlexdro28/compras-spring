package com.miscompras.domain.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class Sales_ProductsId implements Serializable{

	private Long compraId;
	private Long productoId;

}
