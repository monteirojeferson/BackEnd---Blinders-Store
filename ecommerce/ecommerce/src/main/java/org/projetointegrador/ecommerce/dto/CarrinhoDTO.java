package org.projetointegrador.ecommerce.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data

public class CarrinhoDTO {

	private long idCarrinho;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date dtCompra = new java.sql.Date(System.currentTimeMillis());
	
	private double totalCarrinho;
	
	 private long idProduto;	
	 
	   private long idUsuario;
}