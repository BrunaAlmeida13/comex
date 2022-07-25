package br.com.alura.comex.relatorios;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import br.com.alura.comex.pedido.CalculosDosPedidos;
import br.com.alura.comex.pedido.Pedido;
import br.com.alura.comex.processadores.ProcessadorDeArquivo;
import br.com.alura.comex.processadores.ProcessadorDeCsv;

class RelatorioPedidosMaisVendidosTest {

	
	
	private ArrayList<Pedido> pedidos;

	@Test
	void deveriaMostrarApenasTresProdutosComMaiorQuantidadeVendida() {
		Pedido pedido = new Pedido();
		
		Integer expected = 3;
		
		ProcessadorDeArquivo processador = new ProcessadorDeArquivo(); 
		processador.setiProcessador(new ProcessadorDeCsv());
		this.pedidos = processador.execute();
		
		RelatorioPedidosMaisVendidos relPedidosMaisVendidos = new RelatorioPedidosMaisVendidos();
		
		
		CalculosDosPedidos calculoPedidos = new CalculosDosPedidos();
		calculoPedidos.getTotalDePedidosRealizados();
		
		//Assert.assertEquals(expected, sysout);
	}

	/*
	 * 
	 * PRODUTO: iPhone 13 Pro QUANTIDADE: 6
	 * 
	 * PRODUTO: Galaxy S22 Ultra QUANTIDADE: 5
	 * 
	 * PRODUTO: Galaxy Tab S8 QUANTIDADE: 4
	 */
}
