package br.com.alura.comex.dao.mainDao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.comex.dao.CategoriaDao;
import br.com.alura.comex.dao.ProdutoDao;
import br.com.alura.comex.modelo.ProdutoEntity;
import br.com.alura.comex.util.JPAUtil;

public class MainProdutoDao {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		
		em.getTransaction().begin();
		
		//dadosProduto(produtoDao, em);
		
		List<ProdutoEntity> listaProdutoIndispo = produtoDao.listarIndisponiveis(0);
		listaProdutoIndispo.forEach(p -> System.out.println(p.getNome()));
		
		em.getTransaction().commit();
		em.close();
		
	}

	public static void dadosProduto(ProdutoDao produtoDao, EntityManager em) {

		produtoDao.cadastrar(new ProdutoEntity("Produto 1", "desc", 20.0, 1, new CategoriaDao(em).buscarPorId(1l)));
		produtoDao.cadastrar(new ProdutoEntity("Produto 2", "desc", 25.0, 2, new CategoriaDao(em).buscarPorId(2l)));
		produtoDao.cadastrar(new ProdutoEntity("Produto 3", "desc", 55.0, 0, new CategoriaDao(em).buscarPorId(3l)));
		produtoDao.cadastrar(new ProdutoEntity("Produto 4", "desc", 65.0, 0, new CategoriaDao(em).buscarPorId(1l)));
	}
}
