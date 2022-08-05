package br.com.alura.comex.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.comex.modelo.ClienteEntity;
import br.com.alura.comex.modelo.PedidoEntity;

public class PedidoDao {
	private EntityManager em;

	public PedidoDao(EntityManager em) {
		this.em = em;
	}
	
	public PedidoEntity buscarPorId(Long id) {
		return em.find(PedidoEntity.class, id);
	}
	
	public void cadastrar(PedidoEntity pedido) {
		this.em.persist(pedido);
	}
	
	@SuppressWarnings("unchecked")
	public List<PedidoEntity> listarPorClienteQueFezPedido() {
		String jpql = "SELECT p.cliente.nome FROM PedidoEntity p WHERE p.cliente.id > 0";
		return em.createQuery(jpql)
				.getResultList();
	}
}
