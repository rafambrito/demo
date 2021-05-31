package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dominio.Categoria;
import com.example.demo.dominio.Livro;
import com.example.demo.exception.ObjectNotFound;
import com.example.demo.repository.LivroRepository;

@Service
public class LivroServiceImpl implements LivroService {
	
	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Override
	public Livro pesquisarPorId(Integer id) {
		Optional<Livro> obj = this.livroRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFound("Livro não encontrado!"));
	}

	@Override
	public List<Livro> pesquisarTodos() {
		return this.livroRepository.findAll();
	}

	@Override
	public Livro incluir(Livro livro) {
		livro.setId(null);
		return this.livroRepository.save(livro);
	}

	@Override
	public Livro atualizar(Integer id, Livro objIn) {
		Livro old = pesquisarPorId(id);
		
		old.setNome_autor(objIn.getNome_autor());
		old.setTexto(objIn.getTexto());
		old.setTitulo(objIn.getTitulo());
		
		return this.livroRepository.save(old);
	}

	@Override
	public void deletar(Integer id) {
		this.livroRepository.deleteById(id);		
	}

	@Override
	public List<Livro> pesquisarTodos(Integer idCategoria) {
		this.categoriaService.pesquisarPorId(idCategoria);
		return this.livroRepository.pesquisarPorCategoria(idCategoria);
	}

	@Override
	public Livro incluir(Integer idCategoria, Livro objIn) {
		Categoria cat = this.categoriaService.pesquisarPorId(idCategoria);
		objIn.setCategoria(cat);
		return incluir(objIn);
	}

}
