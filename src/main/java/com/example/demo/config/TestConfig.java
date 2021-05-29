package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.demo.service.CategoriaService;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	CategoriaService categoriaService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	@Bean
	public void incluirCategoria() {
		if(this.strategy.equals("create")){
			this.categoriaService.incluirCategoria();
		}
	}

}
