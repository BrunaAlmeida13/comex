package br.com.alura.comex.pedido;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

public class Pedido {

	private String categoria;
	private String produto;
	private String cliente;

	private BigDecimal preco;
	private int quantidade;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@JsonDeserialize(using = LocalDateDeserializer.class)
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

	public BigDecimal getValorTotal(){
		return this.preco.multiply(new BigDecimal(this.quantidade));
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

	public static BigDecimal getMontanteCliente(Map.Entry<String, List<Pedido>> cliente) {
		return cliente.getValue().stream().map(pedido -> pedido.getValorTotal()).reduce(BigDecimal.ZERO,
				BigDecimal::add);
	}
}
