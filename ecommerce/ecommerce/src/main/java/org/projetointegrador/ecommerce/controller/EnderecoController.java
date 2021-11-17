package org.projetointegrador.ecommerce.controller;

import java.util.List;

import org.projetointegrador.ecommerce.model.Endereco;

import org.projetointegrador.ecommerce.repository.EnderecoRepository;
import org.projetointegrador.ecommerce.repository.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/endereco")
public class EnderecoController {
	
	@Autowired
	private EnderecoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Endereco>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Endereco> getById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Endereco>> getByName(@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByEnderecoContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<Endereco> post (@RequestBody Endereco endereco){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(endereco));
	}

	@PutMapping
	public ResponseEntity<Endereco> put (@RequestBody Endereco endereco){
		return ResponseEntity.ok(repository.save(endereco));				
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
	
}