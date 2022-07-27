package br.com.alura.comex.relatorios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;
import java.util.Map.Entry;

import org.junit.jupiter.api.Test;

import br.com.alura.comex.pedido.Pedido;

class RelatorioVendasPorCategoriaTest {

	RelatorioVendasPorCategoria relCategoria = new RelatorioVendasPorCategoria();
	String cliente;

	// Relatório por Categoria
	
	@Test
	void listaDeveriaEstarVazia() {
		List<Entry<String, Long>> listaPedido = null;
		   assertEquals(listaPedido, relCategoria.getLista());
	}

	// Relatorio Produto Mais Caro por Categoria
	
	@Test
	void deveriaTerUmPedido() {
		assertEquals(1, relCategoria.getTamanhoLista_UmPedido());
	}
	
	@Test
	void listaRelatorioProdutoMaisCaroDeveriaEstarVazia() {
		 List<Entry<String, Optional<Pedido>>> listaProdutoMaisCaro = null;
		 assertEquals(listaProdutoMaisCaro, relCategoria.getListaProdutoMaisCaro());
	}
	
	@Test 
	void deveriaTerOnomeDeUmCliente() {
		relCategoria.geraRelatorioProdutoMaisCaro();
		List<Entry<String, Optional<Pedido>>> listaClienteProduto = relCategoria.getListaProdutoMaisCaro();
		
		listaClienteProduto.forEach(valor -> {
			cliente = valor.getValue().get().getCliente();
		});
		
		assertTrue(cliente.contains("ELI"));
	}
}
