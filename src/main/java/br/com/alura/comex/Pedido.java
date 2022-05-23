package br.com.alura.comex;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Pedido {

	private String categoria;
	private String produto;
	private String cliente;

	private BigDecimal preco;
	private int quantidade;

	private BigDecimal montanteDeVendas = BigDecimal.ZERO;
	private Pedido pedidoMaisBarato = null;
	private Pedido pedidoMaisCaro = null;
	private Formatacoes formatador = new Formatacoes();
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
	
	public String pedidoMaisBaratoFormatado() {
		return formatador.formatarPedidoMaisBarato(this.pedidoMaisBarato);
	}

	public Pedido getPedidoMaisBarato() {
		return this.pedidoMaisBarato;
	}

	public String pedidoMaisCaroQueFormatado() {
		return formatador.formatarPedidoMaisCaro(this.pedidoMaisCaro);
	}

	public Pedido getPedidoMaisCaro() {
		return this.pedidoMaisCaro;
	}

	public String valorTotalFormatado() {
		String vtFormatado = formatador.formatarValorTotal(this.montanteDeVendas);
		return vtFormatado;
	}
	
	public BigDecimal getValorTotal(Pedido pedidoAtual) {
		return this.montanteDeVendas = this.montanteDeVendas
				.add(pedidoAtual.getPreco().multiply(new BigDecimal(pedidoAtual.getQuantidade())));
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
