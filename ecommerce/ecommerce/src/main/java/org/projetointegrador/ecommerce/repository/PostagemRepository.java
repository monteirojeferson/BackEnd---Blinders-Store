package org.projetointegrador.ecommerce.repository;

import java.util.List;

import org.projetointegrador.ecommerce.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long>{
	public List<Postagem> findAllByNomeContainingIgnoreCase (String nome);
}
