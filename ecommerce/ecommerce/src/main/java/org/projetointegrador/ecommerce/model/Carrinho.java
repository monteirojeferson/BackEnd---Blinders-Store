package org.projetointegrador.ecommerce.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;


@Entity
@Table(name="carrinho")
@Data
public class Carrinho {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCarrinho;
	
	@NotNull
	@Column(nullable=false)
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date dtCompra = new java.sql.Date(System.currentTimeMillis());
	
	@Column(nullable=false)
	@NotNull
	private double totalCarrinho;
	
	@ManyToOne
	@JoinColumn(name="idProduto") 
	     private Produto produto;	

	@ManyToOne
	@JoinColumn(name="idUsuario") 
	     private Usuario usuario;

	
}
