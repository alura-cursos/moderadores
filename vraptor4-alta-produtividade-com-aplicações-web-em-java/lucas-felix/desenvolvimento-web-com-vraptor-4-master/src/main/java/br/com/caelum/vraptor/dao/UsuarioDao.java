package br.com.caelum.vraptor.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.vraptor.model.Usuario;

public class UsuarioDao {

	private final EntityManager em;
	
    @Inject
	public UsuarioDao(EntityManager em) {
		this.em = em;
	}
	
	@Deprecated
	public UsuarioDao() {
		this(null); // para uso do CDI
	}
	
	public boolean existe(Usuario usuario) {
		return !em.createQuery("select u from Usuario u where u.nome = "
			+ ":nome and u.senha = :senha", Usuario.class)
			.setParameter("nome", usuario.getNome())
			.setParameter("senha", usuario.getSenha())
			.getResultList().isEmpty();
	}

	public void salva(Usuario usuario) {
		em.persist(usuario);
	}

}
