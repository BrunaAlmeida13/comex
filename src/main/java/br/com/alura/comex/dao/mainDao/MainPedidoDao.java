package br.com.alura.comex.dao.mainDao;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import br.com.alura.comex.dao.ClienteDao;
import br.com.alura.comex.dao.PedidoDao;
import br.com.alura.comex.enums.TipoDescontoEnum;
import br.com.alura.comex.modelo.PedidoEntity;
import br.com.alura.comex.util.JPAUtil;

public class MainPedidoDao {
	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		PedidoDao pedidoDao = new PedidoDao(em);
		
		em.getTransaction().begin();
		
		//dadosPedidos(pedidoDao, em);
		
		pedidoDao.listarPorClienteQueFezPedido();
		
		em.getTransaction().commit();
		em.close();
	}
	
	public static void dadosPedidos(PedidoDao pedidoDao, EntityManager em) {
	    LocalDate date = LocalDate.of(2020, 1, 13);  
		pedidoDao.cadastrar(new PedidoEntity(date, 30.0, TipoDescontoEnum.FIDELIDADE, new ClienteDao(em).buscarPorId(3l)));
		pedidoDao.cadastrar(new PedidoEntity(date, 0.0, TipoDescontoEnum.NENHUM, new ClienteDao(em).buscarPorId(2l)));
	}
}
