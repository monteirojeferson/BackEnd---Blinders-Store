package org.projetointegrador.ecommerce.dto;


import lombok.Data;

@Data
public class ProdutoDTO {
	
	private long idProduto;
	
	private String nome;
	
	private String descricao;
	
	private long qtd;
	
	private String ativo;
	
	private double preco;
	
	
	private String imagem;
	
	private long idCategoria;
	
	

}
