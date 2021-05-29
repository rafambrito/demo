package com.example.demo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dominio.Categoria;
import com.example.demo.dominio.Livro;
import com.example.demo.repository.CategoriaRepository;
import com.example.demo.repository.LivroRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LivroRepository livroRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria c1 = new Categoria(null, "Informatica", "Livro de TI");
		
		Livro l1 = new Livro(null, "Java 8", "Sergio Furgeri", "bla bla bla bla", c1);
		
		c1.setLivros(new ArrayList<Livro>());
		c1.getLivros().add(l1);
		
		this.categoriaRepository.save(c1);
		this.livroRepository.save(l1);
		
	}

}
