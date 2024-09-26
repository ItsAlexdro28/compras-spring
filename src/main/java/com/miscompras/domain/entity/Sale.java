package com.miscompras.domain.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "compras")
public class Sale {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Client cliente;

	@Column(length = 100, nullable = false)
	private Date fecha;

	@Column(length = 1, nullable = false)
	private String medio_pago;

	@Column(length = 300, nullable = false)
	private String comentario;

	@Column(length = 1, nullable = false)
	private String estado;

}
