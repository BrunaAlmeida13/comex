package br.com.alura.comex.dao.mainDao;

import javax.persistence.EntityManager;

import br.com.alura.comex.dao.ClienteDao;
import br.com.alura.comex.modelo.ClienteEntity;
import br.com.alura.comex.modelo.EnderecoEntity;
import br.com.alura.comex.util.JPAUtil;

public class MainClienteDao {

	public static void main(String[] args) {
		/// TODO cadastrar 3 clientes

		// TODO pesquisar clientes pelos nomes

		EntityManager em = JPAUtil.getEntityManager();
		ClienteDao clienteDao = new ClienteDao(em);

		em.getTransaction().begin();

		dadosCliente(clienteDao);

		em.getTransaction().commit();
		em.close();
	}

	private static void dadosCliente(ClienteDao clienteDao) {
		clienteDao.cadastrar(new ClienteEntity("Cliente 1", "1234567890", "6146354768", new EnderecoEntity("rua 1", "01", "complemento",
				"bairro", "cidade", "estado")));
	}

}
