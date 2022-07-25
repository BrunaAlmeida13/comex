package br.com.alura.comex.relatorios;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import br.com.alura.comex.pedido.CalculosDosPedidos;
import br.com.alura.comex.pedido.Pedido;
import br.com.alura.comex.processadores.ProcessadorDeArquivo;
import br.com.alura.comex.processadores.ProcessadorDeCsv;

public class RelatorioPedidosMaisVendidos {

	CalculosDosPedidos calculosDosPedidos = new CalculosDosPedidos();
	private ArrayList<Pedido> pedidos = null;
	List<Entry<Integer,Map<String,List<Pedido>>>> pedidosMaisVendidos;

	public RelatorioPedidosMaisVendidos() {
		ProcessadorDeArquivo processador = new ProcessadorDeArquivo(); 
		processador.setiProcessador(new ProcessadorDeCsv());
		//processador.setiProcessador(new ProcessadorDeJson());
		//processador.setiProcessador(new ProcessadorDeXml());
		this.pedidos = processador.execute();
	}

	public List<Entry<Integer, Map<String, List<Pedido>>>> geraRelatorioPedidosMaisVendidos() {
		pedidosMaisVendidos = pedidos.stream()
				.collect(Collectors.groupingBy(Pedido::getQuantidade, Collectors.groupingBy(Pedido::getProduto)))
				.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).limit(3)
				.collect(Collectors.toList());
		return pedidosMaisVendidos;
		
		//
	}
	
	public void apresentaRelatorio() {
		this.geraRelatorioPedidosMaisVendidos();
		pedidosMaisVendidos.forEach(v -> {
			System.out.println("PRODUTO: "
					+ v.getValue().entrySet().stream().collect(Collectors.toList()).get(0).getKey());
			System.out.printf("QUANTIDADE: %s \n\n", v.getKey());
		});
	}
}
