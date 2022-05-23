package br.com.alura.comex;

import java.util.ArrayList;

import br.com.alura.comex.pedido.CalculosPedidos;
import br.com.alura.comex.pedido.Pedido;

public class RelatorioSintetico {

	Pedido pedido = new Pedido();
	CalculosPedidos calculosPedidos = new CalculosPedidos();

	private int totalDeProdutosVendidos = 0;
	private int totalDePedidosRealizados = 0;
	private int totalDeCategorias = 0;

	public RelatorioSintetico() {
		this.imprimeRelatorio(); 
	}
	
	private void geraRelatorio() {
		ArrayList<Pedido> pedidos = new ProcessadorDeCsv().registrarPedidos();

		CategoriasProcessadas categoriasProcessadas = new CategoriasProcessadas();

		for (int i = 0; i < pedidos.size(); i++) {
			Pedido pedidoAtual = pedidos.get(i);

			if (pedidoAtual == null)
				break;

			calculosPedidos.isMaisBaratoQue(pedidoAtual);
			calculosPedidos.isMaisCaroQue(pedidoAtual);

			calculosPedidos.getValorTotal(pedidoAtual);

			this.totalDeProdutosVendidos += pedidoAtual.getQuantidade();
			this.totalDePedidosRealizados++;

			if (!categoriasProcessadas.contains(pedidoAtual.getCategoria())) {
				totalDeCategorias++;
				categoriasProcessadas.add(pedidoAtual.getCategoria());
			}
		}
	}

	

	public void imprimeRelatorio() {
		this.geraRelatorio();
		System.out.println("#### RELATÓRIO DE VALORES TOTAIS");
		System.out.printf("- TOTAL DE PEDIDOS REALIZADOS: %s\n", this.totalDePedidosRealizados);
		System.out.printf("- TOTAL DE PRODUTOS VENDIDOS: %s\n", this.totalDeProdutosVendidos);
		System.out.printf("- TOTAL DE CATEGORIAS: %s\n", totalDeCategorias);
		System.out.printf("- MONTANTE DE VENDAS: %s\n", calculosPedidos.valorTotalFormatado());
		System.out.printf("- PEDIDO MAIS BARATO: %s (%s)\n", calculosPedidos.pedidoMaisBaratoFormatado(),
				calculosPedidos.getPedidoMaisBarato().getProduto());
		System.out.printf("- PEDIDO MAIS CARO: %s (%s)\n", calculosPedidos.pedidoMaisCaroQueFormatado(),
				calculosPedidos.getPedidoMaisCaro().getProduto());
	}

	public int getTotalDeProdutosVendidos() {
		return this.totalDeProdutosVendidos;
	}

	public int getTotalDePedidosRealizados() {
		return this.totalDePedidosRealizados;
	}

	public int getTotalDeCategorias() {
		return this.totalDeCategorias;
	}
}
