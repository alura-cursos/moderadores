package br.com.caelum.vraptor.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.vraptor.model.Produto;

@RequestScoped
public class ProdutoDao {

	private final EntityManager em;

	@Inject
	public ProdutoDao(EntityManager em) {
		this.em = em;
	}
	
	public ProdutoDao() {
		this(null);
	}
	
	public void adiciona(Produto produto) {
		em.persist(produto);
	}

	public void remove(Produto produto) {
		em.remove(busca(produto));
	}

	public Produto busca(Produto produto) {
		return em.find(Produto.class, produto.getId());
	}

	@SuppressWarnings("unchecked")
	public List<Produto> lista() {
		return em.createQuery("select p from Produto p").getResultList();
	}
}