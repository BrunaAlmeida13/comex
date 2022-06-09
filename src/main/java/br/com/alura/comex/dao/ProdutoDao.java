package br.com.alura.comex.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.comex.modelo.ProdutoEntity;

public class ProdutoDao {

	private EntityManager em;

	public ProdutoDao(EntityManager em) {
		this.em = em;
	}

	public ProdutoEntity buscarPorId(Long id) {
		return em.find(ProdutoEntity.class, id);
	}

	public void cadastrar(ProdutoEntity produto) {
		this.em.persist(produto);
	}

	public List<ProdutoEntity> listarTodos() {
		String jpql = "SELECT p FROM ProdutoEntity p";
		return em.createQuery(jpql, ProdutoEntity.class).getResultList();
	}

	public List<ProdutoEntity> listarIndisponiveis(int quantidade_estoque) {
		String jpql = "SELECT p FROM ProdutoEntity p WHERE p.quantidade_estoque = :quantidade_estoque = 0";
		return em.createQuery(jpql, ProdutoEntity.class)
				.setParameter("quantidade_estoque", quantidade_estoque)
				.getResultList();
	}
}
