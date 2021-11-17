package org.projetointegrador.ecommerce.repository;

import java.util.List;

import org.projetointegrador.ecommerce.model.Endereco;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository  extends JpaRepository<Endereco, Long>{
	public List<Endereco> findAllByEnderecoContainingIgnoreCase(String endereco);
}

