package br.com.alura.comex;

import java.util.ArrayList;

public class RelatorioSintetico {

	Pedido pedido = new Pedido();

	private int totalDeProdutosVendidos = 0;
	private int totalDePedidosRealizados = 0;
	private int totalDeCategorias = 0;

	public RelatorioSintetico() {
		this.imprimeRelatorio(); 
	}
	
	private void geraRelatorio() {
		ArrayList<Pedido> pedidos = new ProcessadorDeCsv().registrarPedidos();

		CategoriasProcessadas categoriasProcessadas = new CategoriasProcessadas();
		//int totalDeCategorias = 0;

		for (int i = 0; i < pedidos.size(); i++) {
			Pedido pedidoAtual = pedidos.get(i);

			if (pedidoAtual == null)
				break;

			pedido.isMaisBaratoQue(pedidoAtual);
			pedido.isMaisCaroQue(pedidoAtual);

			pedido.getValorTotal(pedidoAtual);

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
		System.out.printf("- TOTAL DE PEDIDOS REALIZADOS: %s\n", totalDePedidosRealizados);
		System.out.printf("- TOTAL DE PRODUTOS VENDIDOS: %s\n", totalDeProdutosVendidos);
		System.out.printf("- TOTAL DE CATEGORIAS: %s\n", totalDeCategorias);
		System.out.printf("- MONTANTE DE VENDAS: %s\n", pedido.valorTotalFormatado());
		System.out.printf("- PEDIDO MAIS BARATO: %s (%s)\n", pedido.pedidoMaisBaratoFormatado(),
				pedido.getPedidoMaisBarato().getProduto());
		System.out.printf("- PEDIDO MAIS CARO: %s (%s)\n", pedido.pedidoMaisCaroQueFormatado(),
				pedido.getPedidoMaisCaro().getProduto());
	}

	public int getTotalDeProdutosVendidos() {
		return totalDeProdutosVendidos;
	}

	public int getTotalDePedidosRealizados() {
		return totalDePedidosRealizados;
	}

	public int getTotalDeCategorias() {
		return totalDeCategorias;
	}
}
