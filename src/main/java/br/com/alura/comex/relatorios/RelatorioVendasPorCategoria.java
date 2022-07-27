package br.com.alura.comex.relatorios;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.alura.comex.pedido.CalculosDosPedidos;
import br.com.alura.comex.pedido.Pedido;
import br.com.alura.comex.processadores.ProcessadorDeArquivo;
import br.com.alura.comex.processadores.ProcessadorDeCsv;

public class RelatorioVendasPorCategoria {

	CalculosDosPedidos calculosDosPedidos = new CalculosDosPedidos();
	private ArrayList<Pedido> pedidos = null;
	private List<Entry<String, Long>> listaPedido;
	private List<Entry<String, Optional<Pedido>>> listaProdutoMaisCaro;

	public RelatorioVendasPorCategoria() {
		ProcessadorDeArquivo processador = new ProcessadorDeArquivo();
		processador.setiProcessador(new ProcessadorDeCsv());
		// processador.setiProcessador(new ProcessadorDeJson());
		// processador.setiProcessador(new ProcessadorDeXml());
		this.pedidos = processador.execute();
	}

	public void geraRelatorioByCategoria() {
		pedidos.sort((a, b) -> a.getCategoria().compareTo(b.getCategoria()));
		listaPedido = pedidos.stream().collect(Collectors.groupingBy(Pedido::getCategoria, Collectors.counting()))
				.entrySet().stream().sorted(Map.Entry.comparingByKey()).filter(element -> element.getValue() >= 1)
				.collect(Collectors.toList());
	}

	public void apresentaRelatorioByCategoria() {
		this.geraRelatorioByCategoria();
		listaPedido.forEach(v -> {
			System.out.println("CATEGORIA: " + v.getKey());
			System.out.println(
					"QUANTIDADE VENDIDA: " + calculosDosPedidos.somarQuantidadePorCategoria(pedidos, v.getKey()));
			System.out.printf("MONTANTE: %.2f \n\n",
					calculosDosPedidos.calcularMontantePorCategoria(pedidos, v.getKey()));
		});
	}

	public List<Entry<String, Long>> getListaVazia() {
		return listaPedido;
	}

	public void geraRelatorioProdutoMaisCaro() {
		listaProdutoMaisCaro = pedidos.stream()
				.collect(Collectors.groupingBy(Pedido::getCategoria,
						Collectors.maxBy(Comparator.comparing(Pedido::getPreco))))
				.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toList());
	}

	public void apresentaRelatorioProdutoMaisCaro() {
		this.geraRelatorioProdutoMaisCaro();
		listaProdutoMaisCaro.forEach(v -> {
			System.out.println("CATEGORIA: " + v.getKey());
			System.out.println("PRODUTO: " + v.getValue().get().getProduto());
			System.out.printf("PREÇO: R$ %.2f\n\n", v.getValue().get().getPreco());
		});
	}
	
	public List<Entry<String, Optional<Pedido>>>  getListaProdutoMaisCaroVazia () {
		return listaProdutoMaisCaro;
	}

	//------------------------------------------------------------------------------------------------------
	public void geraRelatorioProdutoMaisCaro_umPedido() {
		listaProdutoMaisCaro = pedidos.stream()
				.collect(Collectors.groupingBy(Pedido::getCategoria,
						Collectors.maxBy(Comparator.comparing(Pedido::getPreco))))
				.entrySet().stream().sorted(Map.Entry.comparingByKey()).limit(1).collect(Collectors.toList());
	}
	
	public void apresentaRelatorioProdutoMaisCaro_umPedido() {
		this.geraRelatorioProdutoMaisCaro_umPedido();
		listaProdutoMaisCaro.forEach(v -> {
			System.out.println("CATEGORIA: " + v.getKey());
			System.out.println("PRODUTO: " + v.getValue().get().getProduto());
			System.out.printf("PREÇO: R$ %.2f\n\n", v.getValue().get().getPreco());
		});
	}
	
	public void apresentaRelatorioComClientesEProduto() {
		this.geraRelatorioProdutoMaisCaro();
		listaProdutoMaisCaro.forEach(v -> {
			System.out.printf("[PRODUTO: %s | ", v.getValue().get().getProduto());
			System.out.printf("CLIENTE: %s ]\n", v.getValue().get().getCliente());
		});
	}
}