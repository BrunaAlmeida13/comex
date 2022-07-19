package br.com.alura.comex;

import java.util.ArrayList;
import java.util.HashSet;

import br.com.alura.comex.pedido.CalculosDosPedidos;
import br.com.alura.comex.pedido.Pedido;

public class RelatorioSintetico {

	CalculosDosPedidos calculosDosPedidos = new CalculosDosPedidos();
	private ArrayList<Pedido> pedidos = new ProcessadorDeCsv().registrarPedidos();
	public RelatorioSintetico() throws NoSuchFieldException {
		this.imprimeRelatorio();
	}

	private void geraRelatorio() throws NoSuchFieldException {
		calculosDosPedidos.calcularMontante(this.pedidos);
		calculosDosPedidos.definirMaisBarato(this.pedidos);
		calculosDosPedidos.definirMaisCaro(this.pedidos);
		calculosDosPedidos.contarCategorias(this.pedidos);
		calculosDosPedidos.contarTotalProdutoVendidos(this.pedidos);
		calculosDosPedidos.calcularTotalDePedidosRealizados(this.pedidos);
	}

	private void geraRelatorioByCategoria() {
	}
	public void imprimeRelatorio() throws NoSuchFieldException {
		this.geraRelatorio();
		this.geraRelatorioByCategoria();

		System.out.println("#### RELATÓRIO DE VALORES TOTAIS");
		System.out.printf("- TOTAL DE PEDIDOS REALIZADOS: %s\n", calculosDosPedidos.getTotalDePedidosRealizados());

		System.out.printf("- TOTAL DE PRODUTOS VENDIDOS: %s\n", calculosDosPedidos.getTotalDeProdutosVendidos());
		System.out.printf("- TOTAL DE CATEGORIAS: %s\n", calculosDosPedidos.getTotalDeCategorias());

		System.out.printf("- MONTANTE DE VENDAS: %s\n", calculosDosPedidos.valorTotalFormatado());
		System.out.printf("- PEDIDO MAIS BARATO: %s (%s)\n", calculosDosPedidos.pedidoMaisBaratoFormatado(),
				calculosDosPedidos.getPedidoMaisBarato().getProduto());
		System.out.printf("- PEDIDO MAIS CARO: %s (%s)\n", calculosDosPedidos.pedidoMaisCaroQueFormatado(),
				calculosDosPedidos.getPedidoMaisCaro().getProduto());
	}

}
