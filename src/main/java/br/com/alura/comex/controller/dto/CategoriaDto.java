package br.com.alura.comex.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.comex.modelo.CategoriaEntity;

public class CategoriaDto {
	
	private String nome;

	public CategoriaDto (CategoriaEntity categoria) {
		this.nome = categoria.getNome();
	}
	
	public String getNome() {
		return nome;
	}

	public static List<CategoriaDto> converter(List<CategoriaEntity> categorias) {
		return categorias.stream().map(CategoriaDto::new).collect(Collectors.toList());
	}
}
