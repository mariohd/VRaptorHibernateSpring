package br.com.triadworks.blog.dao.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.triadworks.blog.dao.FilmeDao;
import br.com.triadworks.blog.model.Filme;

//Imports necessários

@Component("filmeHibernate")
public class FilmeDaoHibernate implements FilmeDao {
		
	private SessionFactory sessionFactory;
	
	@Autowired
	public FilmeDaoHibernate(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void inserirFilme(Filme novofilme) {
		Session session = getSession();
		session.save(novofilme);
		session.getTransaction().commit();
	}

	@Override
	public void excluirFilme(Filme filme) {
		Session session = getSession();
		session.delete(filme);
		session.getTransaction().commit();
	}	

	@SuppressWarnings("unchecked")
	@Override
	public List<Filme> listarFilmes() {
		return getSession()
				.createQuery("from Filme order by ano desc")
				.list();
	}
	
	private Session getSession(){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		return session;
	}
}
