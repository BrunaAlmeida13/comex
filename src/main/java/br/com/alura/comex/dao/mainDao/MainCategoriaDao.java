package br.com.alura.comex.dao.mainDao;

import javax.persistence.EntityManager;

import br.com.alura.comex.dao.CategoriaDao;
import br.com.alura.comex.enums.StatusEnum;
import br.com.alura.comex.modelo.CategoriaEntity;
import br.com.alura.comex.util.JPAUtil;

public class MainCategoriaDao {

	public static void main(String[] args) {
		
		EntityManager em = JPAUtil.getEntityManager();
		CategoriaDao categoriaDao = new CategoriaDao(em);

		em.getTransaction().begin();
		
		//dadosCategoria(categoriaDao);
		
		//categoriaDao.atualizarPorId(3l, "Categoria 3", StatusEnum.ATIVA);
		
		categoriaDao.atualizarStatus(3l, StatusEnum.INATIVA);
		
		em.getTransaction().commit();
		em.close();

	}

	@SuppressWarnings("unused")
	private static void dadosCategoria(CategoriaDao categoriaDao) {
		categoriaDao.cadastrar(new CategoriaEntity("Categoria 1", StatusEnum.ATIVA));
		categoriaDao.cadastrar(new CategoriaEntity("Categoria 2", StatusEnum.INATIVA));
		categoriaDao.cadastrar(new CategoriaEntity("Categoria 2", StatusEnum.ATIVA));
	}
}
