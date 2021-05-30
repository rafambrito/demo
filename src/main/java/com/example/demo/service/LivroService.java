package com.example.demo.service;

import java.util.List;

import com.example.demo.dominio.Categoria;
import com.example.demo.dominio.Livro;

public interface LivroService {
	public Livro pesquisarPorId(Integer id);
	public List<Livro> pesquisarTodos();
	public Categoria incluir(Livro livro);
	public Categoria atualizar(Integer id, Livro objIn);
	public void deletar(Integer id);
}
