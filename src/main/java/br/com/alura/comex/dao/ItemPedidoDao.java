package br.com.alura.comex.dao;

import javax.persistence.EntityManager;

import br.com.alura.comex.modelo.ItemDePedidoEntity;

public class ItemPedidoDao {
	private EntityManager em;

	public ItemPedidoDao(EntityManager em) {
		this.em = em;
	}
	
	public ItemDePedidoEntity buscarPorId(Long id) {
		return em.find(ItemDePedidoEntity.class, id);
	}
	
	public void cadastrar(ItemDePedidoEntity itemPedido) {
		this.em.persist(itemPedido);
	}
	
}
