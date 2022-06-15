package br.com.alura.comex.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.comex.controller.dto.CategoriaDto;
import br.com.alura.comex.modelo.CategoriaEntity;

@RestController
public class CategoriaController {

	@RequestMapping("/api/categorias")
	public List<CategoriaDto> nome() {
		CategoriaEntity categoria = new CategoriaEntity("Nome da Categoria");

		// TODO validacao
		return CategoriaDto.converter(Arrays.asList(categoria, categoria, categoria));
	}

}
