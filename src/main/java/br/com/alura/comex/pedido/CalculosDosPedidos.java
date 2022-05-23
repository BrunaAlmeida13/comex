package br.com.alura.comex.pedido;

import java.math.BigDecimal;

import br.com.alura.comex.formatador.Formatacoes;

public class CalculosDosPedidos {
	
	protected BigDecimal montanteDeVendas = BigDecimal.ZERO;
	protected Pedido pedidoMaisBarato = null;
	protected Pedido pedidoMaisCaro = null;
	private int totalDePedidosRealizados = 0;
	
	private Formatacoes formatador = new Formatacoes();
	
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
	
	public int totalDePedidosRealizados(Pedido pedidoAtual) {
		if(pedidoAtual != null)
			return this.totalDePedidosRealizados++;
		return 0;
	}
	
	public int getTotalDePedidosRealizados() {
		return this.totalDePedidosRealizados;
	}
}
