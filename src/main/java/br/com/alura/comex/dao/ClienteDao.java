package br.com.alura.comex.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.comex.modelo.ClienteEntity;

public class ClienteDao {

	private EntityManager em;

	public ClienteDao(EntityManager em) {
		this.em = em;
	}
	
	public ClienteEntity buscarPorId(Long id) {
		return em.find(ClienteEntity.class, id);
	}
	
	public void cadastrar(ClienteEntity cliente) {
		this.em.persist(cliente);
	}

	public void atualizar(ClienteEntity cliente) {
		this.em.merge(cliente);
	}
	
	public void remover(ClienteEntity cliente) {
		cliente = em.merge(cliente);
		this.em.remove(cliente);
	}
	
	public List<ClienteEntity> listarTodos() {
		String jpql = "SELECT c FROM ClienteEntity c";
		return em.createQuery(jpql,ClienteEntity.class).getResultList();
	}

	public List<ClienteEntity> listarPorNome(String nome) {
		String jpql = "SELECT c FROM ClienteEntity c WHERE c.nome  = :nome";
		return em.createQuery(jpql,ClienteEntity.class)
				.setParameter("nome", nome)
				.getResultList();
	}
	
}
