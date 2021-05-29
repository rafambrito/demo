package com.example.demo.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dominio.Categoria;
import com.example.demo.dominio.Livro;
import com.example.demo.repository.CategoriaRepository;
import com.example.demo.repository.LivroRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService {
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LivroRepository livroRepository;
	
	@Override
	public void incluirCategoria() {
		Categoria c1 = new Categoria(null, "Informatica", "Livro de TI");
		Categoria c2= new Categoria(null, "Romance", "Romance/Fantasia");
		
		Livro l1 = new Livro(null, "Java 8", "Sergio Furgeri", "bla bla bla bla", c1);
		Livro l2 = new Livro(null, "Java 7", "Sergio Furgeri", "bla bla bla bla", c1);
		Livro l3 = new Livro(null, "Cem Anos de Solidão", "Gabriel Garcia Marquez", "Coronel Aureliano Buendia...", c2);
		
		c1.setLivros(new ArrayList<Livro>());
		c1.getLivros().add(l1);
		c1.getLivros().add(l2);
		
		c2.setLivros(new ArrayList<Livro>());
		c2.getLivros().add(l3);
		
		this.categoriaRepository.save(c1);
		this.livroRepository.save(l1);		
		this.livroRepository.save(l2);	
		
		this.categoriaRepository.save(c2);
		this.livroRepository.save(l3);	
	}

	@Override
	public Categoria pesquisarPorId(Integer id) {
		Optional<Categoria> obj = categoriaRepository.findById(id);
		return obj.orElse(null);
	}

}
