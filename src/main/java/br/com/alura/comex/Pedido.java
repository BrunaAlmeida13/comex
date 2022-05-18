package br.com.alura.comex;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;

public class Pedido {

	private String categoria;
	private String produto;
	private String cliente;

	private BigDecimal preco;
	private int quantidade;

	private BigDecimal montanteDeVendas = BigDecimal.ZERO;
	private Pedido pedidoMaisBarato = null;
	private Pedido pedidoMaisCaro = null;

	private LocalDate data;

	public Pedido() {
	}

	public Pedido(String categoria, String produto, String cliente, BigDecimal preco, int quantidade, LocalDate data) {
		this.categoria = categoria;
		this.produto = produto;
		this.cliente = cliente;
		this.preco = preco;
		this.quantidade = quantidade;
		this.data = data;
	}

	public boolean isMaisBaratoQue(Pedido pedidoAtual) {
		if (this.pedidoMaisBarato == null || pedidoAtual.getPreco()
				.multiply(new BigDecimal(pedidoAtual.getQuantidade())).compareTo(this.pedidoMaisBarato.getPreco()
						.multiply(new BigDecimal(this.pedidoMaisBarato.getQuantidade()))) < 0) {

			this.pedidoMaisBarato = pedidoAtual;
			return true;
		}
		return false;
	}

	public boolean isMaisCaroQue(Pedido pedidoAtual) {
		if (pedidoMaisCaro == null
				|| pedidoAtual.getPreco().multiply(new BigDecimal(pedidoAtual.getQuantidade())).compareTo(
						pedidoMaisCaro.getPreco().multiply(new BigDecimal(this.pedidoMaisCaro.getQuantidade()))) > 0) {

			this.pedidoMaisCaro = pedidoAtual;
			return true;
		}
		return false;
	}

	public void setValorTotal(Pedido pedidoAtual) {
		this.montanteDeVendas = this.montanteDeVendas
				.add(pedidoAtual.getPreco().multiply(new BigDecimal(pedidoAtual.getQuantidade())));
	}

	public String getValorTotal() {
		return NumberFormat.getCurrencyInstance(new Locale("pt", "BR"))
				.format(this.montanteDeVendas.setScale(2, RoundingMode.HALF_DOWN));	
	}

	public String getMaisBaratoQue() {
		return NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(pedidoMaisBarato.getPreco()
				.multiply(new BigDecimal(pedidoMaisBarato.getQuantidade())).setScale(2, RoundingMode.HALF_DOWN));
	}

	public Pedido getPedidoMaisBarato() {
		return this.pedidoMaisBarato;
	}

	public String getMaisCaroQue() {
		return NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(pedidoMaisCaro.getPreco()
				.multiply(new BigDecimal(pedidoMaisCaro.getQuantidade())).setScale(2, RoundingMode.HALF_DOWN));
	}
	
	public Pedido getPedidoMaisCaro() {
		return this.pedidoMaisCaro;
	}

	public String getCategoria() {
		return categoria;
	}

	public String getProduto() {
		return produto;
	}

	public String getCliente() {
		return cliente;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public LocalDate getData() {
		return data;
	}

	@Override
	public String toString() {
		return "Pedido{" + "categoria='" + categoria + '\'' + ", produto='" + produto + '\'' + ", cliente='" + cliente
				+ '\'' + ", preco=" + preco + ", quantidade=" + quantidade + ", data=" + data + '}';
	}

}
