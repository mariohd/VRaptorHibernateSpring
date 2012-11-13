package br.com.triadworks.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.triadworks.blog.dao.FilmeDao;
import br.com.triadworks.blog.model.Filme;

@Resource
public class FilmeController {

	private FilmeDao filmeDao;
	private Result result;

	public FilmeController(Result result,
			@Qualifier("filmeHibernate") FilmeDao filmeDao) {
		this.result = result;
		this.filmeDao = filmeDao;
	}

	@Path("/")
	public List<Filme> listarFilmes() {
		return filmeDao.listarFilmes();
	}

	@Path("/filme/novo")
	public void inserirFilme(Filme novoFilme) {
		filmeDao.inserirFilme(novoFilme);
		result.redirectTo(this).listarFilmes();
	}

	@Path("/filme/excluir/{filme.codigo}")
	public void excluirFilme(Filme filme) {
		filmeDao.excluirFilme(filme);
		result.redirectTo(this).listarFilmes();
	}

}
