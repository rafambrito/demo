package com.example.demo.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.dominio.Livro;
import com.example.demo.service.CategoriaService;
import com.example.demo.service.LivroService;

@RestController
@RequestMapping(value = "/livros")
public class LivroResource {
	
	@Autowired
	private LivroService livroService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Livro> pesquisarPorId(@PathVariable Integer id){
		Livro obj = this.livroService.pesquisarPorId(id);
		return ResponseEntity.ok().body(obj);
	}	
	
	@GetMapping
	public ResponseEntity<List<Livro>> pesquisarTodos(@RequestParam(value = "categoria", defaultValue = "0") Integer idCategoria){
		this.categoriaService.pesquisarPorId(idCategoria);
		List<Livro> list = this.livroService.pesquisarTodos(idCategoria);
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Livro> incluir(@Valid @RequestParam(value = "categoria", defaultValue = "0") Integer idCategoria, @RequestBody Livro objIn){
		Livro obj = this.livroService.incluir(idCategoria, objIn);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Livro> atualizar(@Valid @PathVariable Integer id, @RequestBody Livro objIn){
		Livro obj = this.livroService.atualizar(id, objIn);
		return ResponseEntity.ok().body(obj);
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<Livro> atualizarPatch(@PathVariable Integer id, @RequestBody Livro objIn){
		Livro obj = this.livroService.atualizar(id, objIn);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Integer id){
		this.livroService.deletar(id);
		return ResponseEntity.noContent().build();
	}

}
