package br.com.alura.comex.dao;

import javax.persistence.EntityManager;

import br.com.alura.comex.modelo.ClienteEntity;

public class ClienteDao {

	private EntityManager em;

	public ClienteDao(EntityManager em) {
		this.em = em;
	}
	
	//buscaPorId(id){}
	
	public void cadastra(ClienteEntity cliente) {
		this.em.persist(cliente);
	}

	// atualiza(Cliente){}
	
	// remove(Cliente){}
	
	// listaTodos()
	
	// listaPorNome(nome)
}
