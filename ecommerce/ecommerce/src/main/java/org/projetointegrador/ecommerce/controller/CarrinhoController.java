package org.projetointegrador.ecommerce.controller;

import org.projetointegrador.ecommerce.dto.CarrinhoDTO;
import org.projetointegrador.ecommerce.model.Carrinho;
import org.projetointegrador.ecommerce.model.Produto;
import org.projetointegrador.ecommerce.model.Usuario;
import org.projetointegrador.ecommerce.repository.CarrinhoRepository;
import org.projetointegrador.ecommerce.repository.ProdutoRepository;
import org.projetointegrador.ecommerce.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/*import br.com.fancybox.fancybox.dto.CarrinhoDTO;
import br.com.fancybox.fancybox.model.Carrinho;
import br.com.fancybox.fancybox.model.Produto;
import br.com.fancybox.fancybox.model.Usuario;
import br.com.fancybox.fancybox.repository.CarrinhoRepository;
import br.com.fancybox.fancybox.repository.ProdutoRepository;
import br.com.fancybox.fancybox.repository.UsuarioRepository;*/
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/carrinho") 
@CrossOrigin("*")
@RequiredArgsConstructor
public class CarrinhoController {
	

	private final CarrinhoRepository repositoryCarrinho;
	
	private final ProdutoRepository repositoryProduto;
	
	private final UsuarioRepository repositoryUsuario;
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Carrinho> GetById(@PathVariable long id){
		return repositoryCarrinho.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
			
	@PostMapping
	public Carrinho salvar(@RequestBody CarrinhoDTO dtoCarrinho) {
		long idUsuario = dtoCarrinho.getIdUsuario();
		long idProduto = dtoCarrinho.getIdProduto();
		

	Usuario usuario = 
				repositoryUsuario.findById(idUsuario)
				.orElseThrow(()->
				new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario Inexistente"));
	
	Produto produto = 
			repositoryProduto.findById(idProduto)
			.orElseThrow(()->
			new ResponseStatusException(HttpStatus.BAD_REQUEST, "Produto Inexistente"));

	Carrinho carrinho = new Carrinho();
	carrinho.setUsuario(usuario);
	carrinho.setProduto(produto);
	carrinho.setDtCompra(dtoCarrinho.getDtCompra());
	carrinho.setTotalCarrinho(produto.getQtd() * produto.getPreco());
	


	
	return repositoryCarrinho.save(carrinho);
	}
	
	@PutMapping
		public Carrinho editar(@RequestBody CarrinhoDTO dtoCarrinho) {
		long idUsuario = dtoCarrinho.getIdUsuario();
		long idProduto = dtoCarrinho.getIdProduto();
		

	Usuario usuario = 
				repositoryUsuario.findById(idUsuario)
				.orElseThrow(()->
				new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario Inexistente"));
	
	Produto produto = 
			repositoryProduto.findById(idProduto)
			.orElseThrow(()->
			new ResponseStatusException(HttpStatus.BAD_REQUEST, "Produto Inexistente"));

	Carrinho carrinho = new Carrinho();
	carrinho.setUsuario(usuario);
	carrinho.setProduto(produto);
	carrinho.setDtCompra(dtoCarrinho.getDtCompra());
	carrinho.setTotalCarrinho(produto.getQtd() * produto.getPreco());
	


	return repositoryCarrinho.save(carrinho);
	
	
	}
	
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repositoryCarrinho.deleteById(id);                                  
	}


}