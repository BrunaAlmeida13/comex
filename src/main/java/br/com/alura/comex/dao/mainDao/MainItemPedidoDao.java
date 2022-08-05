package br.com.alura.comex.dao.mainDao;

import javax.persistence.EntityManager;

import br.com.alura.comex.dao.ItemPedidoDao;
import br.com.alura.comex.dao.PedidoDao;
import br.com.alura.comex.dao.ProdutoDao;
import br.com.alura.comex.enums.TipoDescontoEnum;
import br.com.alura.comex.modelo.ItemDePedidoEntity;
import br.com.alura.comex.util.JPAUtil;

public class MainItemPedidoDao {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		ItemPedidoDao itemPedidoDao = new ItemPedidoDao(em);
		
		em.getTransaction().begin();
		
		dadosPedidos(itemPedidoDao, em);
		
		em.getTransaction().commit();
		em.close();

	}

	public static void dadosPedidos(ItemPedidoDao itemPedidoDao, EntityManager em) {
		itemPedidoDao.cadastrar(new ItemDePedidoEntity(2, 20.90, 90.0, TipoDescontoEnum.PROMOCAO,
				new PedidoDao(em).buscarPorId(5l), new ProdutoDao(em).buscarPorId(2l)));
	}
}
