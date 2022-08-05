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

	public List<ProdutoEntity> listarIndisponiveis(int quantidadeEstoque) {
		int qntdEstoque = 0;
		String jpql = "SELECT p FROM ProdutoEntity p WHERE p.quantidadeEstoque = :qntdEstoque";
		return em.createQuery(jpql, ProdutoEntity.class)
				.setParameter("qntdEstoque", quantidadeEstoque)
				.getResultList();
	}
}
