package org.projetointegrador.ecommerce.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "endereco")
public class Endereco {

	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
    private String endereco;
	
	private String cep;
	
	private int numero;
	
	private String bairro;
	
	private String cidade;
	
	private String estado;
	

	@OneToMany(mappedBy = "endereco", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("endereco")
	private List<Usuario> usuario;

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public List<Usuario> getUsuario() {
		return usuario;
	}


	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}
/*

	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public List<Usuario> getUsuario() {
		return usuario;
	}


	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}


	/*public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}*/
	
	

	
}