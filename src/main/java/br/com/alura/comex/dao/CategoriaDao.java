package br.com.alura.comex.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.comex.modelo.CategoriaEntity;

public class CategoriaDao {

	private EntityManager em;

	public CategoriaDao(EntityManager em) {
		this.em = em;
	}

	public CategoriaEntity buscarPorId(Long id) {
		return em.find(CategoriaEntity.class, id);
	}

	public void cadastrar(CategoriaEntity categoria) {
		this.em.persist(categoria);
	}

	public void atualizar(CategoriaEntity categoria) {
		this.em.merge(categoria);
	}

	public List<CategoriaEntity> listarTodas() {
		String jpql = "SELECT c FROM CategoriaEntity c";
		return em.createQuery(jpql, CategoriaEntity.class).getResultList();
	}

	// TODO listarInativas()
}
