package br.com.alura.comex.relatorios;

import java.util.List;
import java.util.function.Function;

import br.com.alura.comex.pedido.Pedido;

public enum CategoriaRelatorio {
	VENDAS_POR_CATEGORIA(pedidos -> new RelatorioProxy(new RelatorioVendasPorCategoria(pedidos)));

	private final Function<List<Pedido>, Relatorio> relatorioSupplier;

	CategoriaRelatorio(Function<List<Pedido>, Relatorio> relatorioSupplier) {
		this.relatorioSupplier = relatorioSupplier;
	}

	public Relatorio getRelatorio(List<Pedido> listaDePedidos) {
		return relatorioSupplier.apply(listaDePedidos);
	}
}
