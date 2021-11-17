package org.projetointegrador.ecommerce.repository;

import java.util.List;

import org.projetointegrador.ecommerce.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
	public List<Categoria> findAllByNomeCategoriaContainingIgnoreCase (String nomeCategoria);
	
	

}