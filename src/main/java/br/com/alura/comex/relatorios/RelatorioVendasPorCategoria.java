package br.com.alura.comex.relatorios;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

import br.com.alura.comex.ProcessadorDeCsv;
import br.com.alura.comex.pedido.CalculosDosPedidos;
import br.com.alura.comex.pedido.Pedido;

public class RelatorioVendasPorCategoria {

	CalculosDosPedidos calculosDosPedidos = new CalculosDosPedidos();
	private ArrayList<Pedido> pedidos = new ProcessadorDeCsv().registrarPedidos();

	public RelatorioVendasPorCategoria() {}

	public void geraRelatorioByCategoria() {
		pedidos.sort((a, b) -> a.getCategoria().compareTo(b.getCategoria()));
		pedidos.stream().collect(Collectors.groupingBy(Pedido::getCategoria, Collectors.counting())).entrySet().stream()
				.sorted(Map.Entry.comparingByKey()).filter(element -> element.getValue() >= 1)
				.collect(Collectors.toList()).forEach(v -> {
					System.out.println("CATEGORIA: " + v.getKey());
					System.out.println("QUANTIDADE VENDIDA: "
							+ calculosDosPedidos.somarQuantidadePorCategoria(pedidos, v.getKey()));
					System.out.printf("MONTANTE: %.2f \n\n",
							calculosDosPedidos.calcularMontantePorCategoria(pedidos, v.getKey()));
				});
	}

	public void geraRelatorioProdutoMaisCaro() {
		pedidos.stream()
				.collect(Collectors.groupingBy(Pedido::getCategoria,
						Collectors.maxBy(Comparator.comparing(Pedido::getPreco))))
				.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toList()).forEach(v -> {
					System.out.println("CATEGORIA: " + v.getKey());
					System.out.println("PRODUTO: " + v.getValue().get().getProduto());
					System.out.printf("PREÇO: R$ %.2f\n\n", v.getValue().get().getPreco());
				});
	}
}
