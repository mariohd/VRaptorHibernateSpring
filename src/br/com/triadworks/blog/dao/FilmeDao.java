package br.com.triadworks.blog.dao;

import java.util.List;

import br.com.triadworks.blog.model.Filme;

public interface FilmeDao {
	
	public void inserirFilme(Filme novofilme);
	public void excluirFilme(Filme filme);
	public List<Filme> listarFilmes();
}
