package br.com.alura.comex.formatador;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

import br.com.alura.comex.pedido.Pedido;

public class Formatacoes {

	public String formatarValorTotal(BigDecimal montanteDeVendas) {
		return NumberFormat.getCurrencyInstance(new Locale("pt", "BR"))
				.format(montanteDeVendas.setScale(2, RoundingMode.HALF_DOWN));
	}

	public String formatarPedidoMaisBarato(Pedido pedidoMaisBarato) {
		return NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(pedidoMaisBarato.getPreco()
				.multiply(new BigDecimal(pedidoMaisBarato.getQuantidade())).setScale(2, RoundingMode.HALF_DOWN));
	}
	
	public String formatarPedidoMaisCaro(Pedido pedidoMaisCaro) {
		return NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(pedidoMaisCaro.getPreco()
				.multiply(new BigDecimal(pedidoMaisCaro.getQuantidade())).setScale(2, RoundingMode.HALF_DOWN));
	}
}
