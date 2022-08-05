package br.com.alura.comex.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.comex.enums.StatusEnum;
import br.com.alura.comex.modelo.CategoriaEntity;

public class CategoriaDao {

	private EntityManager em;

	public CategoriaDao() {
	}

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

	public List<CategoriaEntity> listarInativa(StatusEnum status) {
		String jpql = "A c FROM CategoriaEntity c WHERE c.status  = :status";
		return em.createQuery(jpql, CategoriaEntity.class).setParameter("status", status).getResultList();
	}

	public void atualizarPorId(Long id, String nome, StatusEnum status) {
		String jpql = "UPDATE CategoriaEntity c SET c.nome = :nome, c.status = :status WHERE c.id = :id";
		CategoriaEntity categoriaPorId = this.buscarPorId(id);
		em.createQuery(jpql).setParameter("id", id).setParameter("nome", nome)
				.setParameter("status", status).executeUpdate();
	}
	
	public void atualizarStatus(Long id, StatusEnum status) {
		String jpql = "UPDATE CategoriaEntity c SET c.status = :status WHERE c.id = :id";
		CategoriaEntity categoriaPorId = this.buscarPorId(id);
		em.createQuery(jpql).setParameter("id", id).setParameter("status", status).executeUpdate();
	}
}
