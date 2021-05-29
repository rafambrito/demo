package com.example.demo.service;

import com.example.demo.dominio.Categoria;

public interface CategoriaService {
	public void incluirCategoria();
	
	public Categoria pesquisarPorId(Integer id);
}
