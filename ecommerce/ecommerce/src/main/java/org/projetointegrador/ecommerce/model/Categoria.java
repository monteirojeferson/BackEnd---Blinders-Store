package org.projetointegrador.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name="categoria")
@Data
public class Categoria {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private long idCategoria;
	
	@Column(nullable=false)
	@NotNull
	private String nomeCategoria;

}