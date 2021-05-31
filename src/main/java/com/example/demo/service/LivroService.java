package com.example.demo.service;

import java.util.List;

import com.example.demo.dominio.Livro;

public interface LivroService {
	public Livro pesquisarPorId(Integer id);
	public List<Livro> pesquisarTodos();
	public Livro incluir(Livro livro);
	public Livro atualizar(Integer id, Livro objIn);
	public void deletar(Integer id);
	public List<Livro> pesquisarTodos(Integer idCategoria);
	public Livro incluir(Integer idCategoria, Livro objIn);
}
