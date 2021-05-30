package com.example.demo.service;

import java.util.List;

import com.example.demo.dominio.Categoria;
import com.example.demo.dto.CategoriaDTO;

public interface CategoriaService {
	public void incluirCategoria();	
	public Categoria pesquisarPorId(Integer id);
	public List<Categoria> pesquisarTodos();
	public Categoria incluir(Categoria categoria);
	public Categoria atualizar(Integer id, CategoriaDTO objIn);
	public void deletar(Integer id);
}
