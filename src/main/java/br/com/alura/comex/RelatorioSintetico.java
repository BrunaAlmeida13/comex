package br.com.alura.comex;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

import br.com.alura.comex.pedido.CalculosDosPedidos;
import br.com.alura.comex.pedido.Pedido;

public class RelatorioSintetico {

	Pedido pedido = new Pedido();
	Pedido minValor = new Pedido();
	CalculosDosPedidos calculosDosPedidos = new CalculosDosPedidos();

	private int totalDeProdutosVendidos = 0;
	private int totalDeCategorias = 0;

	public RelatorioSintetico() throws NoSuchFieldException {
		this.imprimeRelatorio(); 
	}
	
	private void geraRelatorio() throws NoSuchFieldException {
		ArrayList<Pedido> pedidos = new ProcessadorDeCsv().registrarPedidos();



		HashSet<String> categoriasProcessadas = new HashSet<String>();
		calculosDosPedidos.calcularMontante(pedidos);
		calculosDosPedidos.definirMaisBarato(pedidos);
		calculosDosPedidos.definirMaisCaro(pedidos);
		calculosDosPedidos.contarCategorias(pedidos);
		for (int i = 0; i < pedidos.size(); i++) {
			Pedido pedidoAtual = pedidos.get(i);

			if (pedidoAtual == null)
				break;

			this.totalDeProdutosVendidos += pedidoAtual.getQuantidade();
			calculosDosPedidos.totalDePedidosRealizados(pedidoAtual);
			/*
			if (!categoriasProcessadas.contains(pedidoAtual.getCategoria())) {
				totalDeCategorias++;
				categoriasProcessadas.add(pedidoAtual.getCategoria());
			}

			 */
		}
	}

	public void imprimeRelatorio() throws NoSuchFieldException {
		this.geraRelatorio();
		System.out.println("#### RELATÓRIO DE VALORES TOTAIS");
		System.out.printf("- TOTAL DE PEDIDOS REALIZADOS: %s\n", calculosDosPedidos.getTotalDePedidosRealizados());
		System.out.printf("- TOTAL DE PRODUTOS VENDIDOS: %s\n", this.getTotalDeProdutosVendidos());
		System.out.printf("- TOTAL DE CATEGORIAS: %s\n", calculosDosPedidos.getTotalDeCategorias());
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
