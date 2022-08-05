package br.com.alura.comex.dao.mainDao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.comex.dao.ClienteDao;
import br.com.alura.comex.modelo.ClienteEntity;
import br.com.alura.comex.util.JPAUtil;

public class MainClienteDao {

	public static void main(String[] args) {

		EntityManager em = JPAUtil.getEntityManager();
		ClienteDao clienteDao = new ClienteDao(em);
		ClienteEntity cliente = new ClienteEntity();

		em.getTransaction().begin();

		//dadosCliente(clienteDao);
		
		List<ClienteEntity> listaClientesPorNome = clienteDao.listarPorNome("Cliente 1");
		listaClientesPorNome.forEach(c -> System.out.println(c.getNome()));

		em.getTransaction().commit();
		em.close();
	}

	private static void dadosCliente(ClienteDao clienteDao) {
		clienteDao.cadastrar(new ClienteEntity("Cliente 1", "1234567890", "6146354768", "rua 1", "01", "complemento", "bairro", "cidade", "estado"));
		clienteDao.cadastrar(new ClienteEntity("Cliente 2", "1234567890", "6146354768", "rua 1", "01", "complemento", "bairro", "cidade", "estado"));
		clienteDao.cadastrar(new ClienteEntity("Cliente 3", "1234567890", "6146354768", "rua 1", "01", "complemento", "bairro", "cidade", "estado"));
	}
}
