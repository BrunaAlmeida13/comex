package br.com.alura.comex.formatador;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

import br.com.alura.comex.pedido.Pedido;

public class Formatacoes {

	public static String formatarValorTotal(BigDecimal valor) {
        return NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(valor);
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
