package br.com.alura.comex.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.alura.comex.enums.Status;

@Entity
@Table(name = "categoria")
public class CategoriaEntity {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Enum<Status> status;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Enum<Status> getStatus() {
		return status;
	}
	public void setStatus(Enum<Status> status) {
		this.status = status;
	}
}
