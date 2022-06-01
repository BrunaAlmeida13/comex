package br.com.alura.comex.relatorios;

import java.util.ArrayList;
import java.util.HashSet;

import br.com.alura.comex.pedido.CalculosDosPedidos;
import br.com.alura.comex.pedido.Pedido;
import br.com.alura.comex.processadores.ProcessadorDeCsv;

public class RelatorioSintetico {

	Pedido pedido = new Pedido();
	CalculosDosPedidos calculosDosPedidos = new CalculosDosPedidos();

	private int totalDeProdutosVendidos = 0;
	private int totalDeCategorias = 0;

	public RelatorioSintetico() {
		this.imprimeRelatorio(); 
	}
	
	private void geraRelatorio() {
		ArrayList<Pedido> pedidos = new ProcessadorDeCsv().registrarPedidos();

		HashSet<String> categoriasProcessadas = new HashSet<String>();

		for (int i = 0; i < pedidos.size(); i++) {
			Pedido pedidoAtual = pedidos.get(i);

			if (pedidoAtual == null)
				break;

			calculosDosPedidos.isMaisBaratoQue(pedidoAtual);
			calculosDosPedidos.isMaisCaroQue(pedidoAtual);

			calculosDosPedidos.getValorTotal(pedidoAtual);

			this.totalDeProdutosVendidos += pedidoAtual.getQuantidade();
			calculosDosPedidos.totalDePedidosRealizados(pedidoAtual);

			if (!categoriasProcessadas.contains(pedidoAtual.getCategoria())) {
				totalDeCategorias++;
				categoriasProcessadas.add(pedidoAtual.getCategoria());
			}
		}
	}

	public void imprimeRelatorio() {
		this.geraRelatorio();
		System.out.println("#### RELATÓRIO DE VALORES TOTAIS");
		System.out.printf("- TOTAL DE PEDIDOS REALIZADOS: %s\n", calculosDosPedidos.getTotalDePedidosRealizados());
		System.out.printf("- TOTAL DE PRODUTOS VENDIDOS: %s\n", this.getTotalDeProdutosVendidos());
		System.out.printf("- TOTAL DE CATEGORIAS: %s\n", this.getTotalDeCategorias());
		System.out.printf("- MONTANTE DE VENDAS: %s\n", calculosDosPedidos.valorTotalFormatado());
		System.out.printf("- PEDIDO MAIS BARATO: %s (%s)\n", calculosDosPedidos.pedidoMaisBaratoFormatado(),
				calculosDosPedidos.getPedidoMaisBarato().getProduto());
		System.out.printf("- PEDIDO MAIS CARO: %s (%s)\n", calculosDosPedidos.pedidoMaisCaroQueFormatado(),
				calculosDosPedidos.getPedidoMaisCaro().getProduto());
	}

	public int getTotalDeProdutosVendidos() {
		return this.totalDeProdutosVendidos;
	}

	public int getTotalDeCategorias() {
		return this.totalDeCategorias;
	}
}
