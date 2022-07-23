package br.com.alura.comex.relatorios;

import java.util.ArrayList;

import br.com.alura.comex.pedido.CalculosDosPedidos;
import br.com.alura.comex.pedido.Pedido;
import br.com.alura.comex.processadores.ProcessadorDeArquivo;
import br.com.alura.comex.processadores.ProcessadorDeCsv;
import br.com.alura.comex.processadores.ProcessadorDeJson;
import br.com.alura.comex.processadores.ProcessadorDeXml;

public class RelatorioSintetico {

	RelatorioPedidosMaisVendidos relatorioPedidoMaisVendidos = new RelatorioPedidosMaisVendidos();
	RelatorioVendasPorCategoria relatorioCategoria = new RelatorioVendasPorCategoria();
	CalculosDosPedidos calculosDosPedidos = new CalculosDosPedidos();
	private ArrayList<Pedido> pedidos = null;

	public RelatorioSintetico() throws NoSuchFieldException {
		ProcessadorDeArquivo processador = new ProcessadorDeArquivo(); 
		//processador.setiProcessador(new ProcessadorDeCsv());
		//processador.setiProcessador(new ProcessadorDeJson());
		processador.setiProcessador(new ProcessadorDeXml());
		this.pedidos = processador.execute();
		
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

	public void imprimeRelatorio() throws NoSuchFieldException {

		this.geraRelatorio();

		System.out.println("#### RELATÓRIO DE VALORES TOTAIS");
		System.out.printf("- TOTAL DE PEDIDOS REALIZADOS: %s\n", calculosDosPedidos.getTotalDePedidosRealizados());

		System.out.printf("- TOTAL DE PRODUTOS VENDIDOS: %s\n", calculosDosPedidos.getTotalDeProdutosVendidos());
		System.out.printf("- TOTAL DE CATEGORIAS: %s\n", calculosDosPedidos.getTotalDeCategorias());

		System.out.printf("- MONTANTE DE VENDAS: %s\n", calculosDosPedidos.valorTotalFormatado());
		System.out.printf("- PEDIDO MAIS BARATO: %s (%s)\n", calculosDosPedidos.pedidoMaisBaratoFormatado(),
				calculosDosPedidos.getPedidoMaisBarato().getProduto());
		System.out.printf("- PEDIDO MAIS CARO: %s (%s)\n", calculosDosPedidos.pedidoMaisCaroQueFormatado(),
				calculosDosPedidos.getPedidoMaisCaro().getProduto());

		System.out.println("#################\n");

		relatorioCategoria.geraRelatorioByCategoria();

		System.out.println("#################\n");

		relatorioPedidoMaisVendidos.geraRelatorioPedidosMaisVendidos();
		
		System.out.println("#################\n");
		
		relatorioCategoria.geraRelatorioProdutoMaisCaro();
	}
}