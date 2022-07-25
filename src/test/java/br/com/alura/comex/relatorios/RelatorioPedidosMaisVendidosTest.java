package br.com.alura.comex.relatorios;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class RelatorioPedidosMaisVendidosTest {

		RelatorioPedidosMaisVendidos relPedidosMaisVendidos = new RelatorioPedidosMaisVendidos();
	
	@Test
	void deveriaMostrarAtéTresProdutosComMaiorQuantidadeVendida() {
		assertEquals(3, relPedidosMaisVendidos.getQuantidadeDeProdutosApresentados());
	}

	@Test
	void deveriaMostrarOProdutoMaisVendido() {
		assertEquals("iPhone 13 Pro", relPedidosMaisVendidos.getProdutoMaisVendido());
	}
	
	@Test
	void deveriaMostrarAQuantidadeDeVendasDoProdutoMaisVendido() {
		assertEquals(6, relPedidosMaisVendidos.getQuantidadeDoProdutoMaisVendido());
	}
}
