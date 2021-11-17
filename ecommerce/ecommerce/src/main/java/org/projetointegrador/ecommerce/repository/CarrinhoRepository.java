package org.projetointegrador.ecommerce.repository;

import org.projetointegrador.ecommerce.model.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CarrinhoRepository extends JpaRepository<Carrinho, Long>{
	
	
}
