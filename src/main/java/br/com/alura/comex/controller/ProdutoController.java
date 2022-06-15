package br.com.alura.comex.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.comex.controller.dto.ProdutoDto;
import br.com.alura.comex.modelo.CategoriaEntity;
import br.com.alura.comex.modelo.ProdutoEntity;

@RestController
public class ProdutoController {
	
	@RequestMapping("/api/produtos")
	public List<ProdutoDto> lista() {
		Long categoriaId = (long) 1;
		ProdutoEntity produto = new ProdutoEntity("Nome do Produto", "descricao", 20.0, 2, categoriaId);
		
		// TODO validacao
		return ProdutoDto.converter(Arrays.asList(produto, produto, produto));
	}
	
}
