package br.com.alura.comex.processadores;

public class ReceptorJson {

	private String categoria;
	private String produto;
	private double preco;
	private int quantidade;
	private String data;
	private String cliente;

	public ReceptorJson() {
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "\ncategoria=" + categoria + ", produto=" + produto + ", preco=" + preco + ", quantidade="
				+ quantidade + ", data=" + data + ", cliente=" + cliente + "";
	}
}
