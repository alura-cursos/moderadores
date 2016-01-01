package br.com.caelum.vraptor.observers;

import javax.enterprise.event.Observes;
import javax.persistence.EntityManager;

import br.com.caelum.vraptor.dao.ProdutoDao;
import br.com.caelum.vraptor.dao.UsuarioDao;
import br.com.caelum.vraptor.events.VRaptorInitialized;
import br.com.caelum.vraptor.model.Produto;
import br.com.caelum.vraptor.model.Usuario;
import br.com.caelum.vraptor.util.JPAUtil;

public class InitialDataObserver {

	/**
	 * Esse é um exemplo simples de observer do CDI com VRaptor 4
	 * 
	 * Ele é utilizado para inserir um usuário e alguns produtos
	 * sempre que a app é startada, pois estamos usando um banco
	 * em memória. Você pode ler mais a respeito de observers em:
	 *  
	 * http://www.vraptor.org/pt/docs/eventos/
	 */
	public void insert(@Observes VRaptorInitialized event) {
		
		EntityManager em = JPAUtil.criaEntityManager();
		em.getTransaction().begin();

		em.persist(new Usuario("vraptor", "vraptor"));

		em.persist(new Produto("DVD/Blu-ray Justin Bieber", 120.8, 2));
		em.persist(new Produto("Carro de F1", 1.99, 5));
		em.persist(new Produto("Livro da Casa do Código", 29.9, 10));
		
		em.getTransaction().commit();
		em.close();
	}	
}