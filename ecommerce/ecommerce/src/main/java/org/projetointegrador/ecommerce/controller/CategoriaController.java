package org.projetointegrador.ecommerce.controller;

import java.util.List;

import org.projetointegrador.ecommerce.model.Categoria;
import org.projetointegrador.ecommerce.repository.CategoriaRepository;
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


import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/categoria")
@CrossOrigin("*")
@RequiredArgsConstructor
public class CategoriaController {
	
	
	@Autowired
	private CategoriaRepository repositoryCategoria;
	
	
	@GetMapping("/{idCategoria}")
	public ResponseEntity <Categoria> 
	GetById(@PathVariable long id){	
		return repositoryCategoria.findById(id).
		map(resp->ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping
	public ResponseEntity<List<Categoria>> getAll(){
		return ResponseEntity.ok(repositoryCategoria.findAll());
	}
		
	@GetMapping("/categoria/{nomeCategoria}")
	public ResponseEntity<List<Categoria>> GetByName(@PathVariable String nomeCategoria){
		return ResponseEntity.ok(repositoryCategoria.findAllByNomeCategoriaContainingIgnoreCase(nomeCategoria));
	}
	
	@PostMapping
	public ResponseEntity<Categoria> post(@RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(repositoryCategoria.save(categoria));
	}
	
	@PutMapping
	public ResponseEntity<Categoria> put(@RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.OK).body(repositoryCategoria.save(categoria));
	}
	
	@DeleteMapping("/{idCategoria}")
	public void delete(@PathVariable long id) {
		repositoryCategoria.deleteById(id);                                  
	}


}
