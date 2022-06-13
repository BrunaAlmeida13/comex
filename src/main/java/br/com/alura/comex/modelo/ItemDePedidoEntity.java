package br.com.alura.comex.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.alura.comex.enums.TipoDescontoEnum;

@Entity
@Table(name = "Item_Pedido")
public class ItemDePedidoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double preco_unitario;
	private int quantidade;
	private double desconto;

	@Enumerated(EnumType.STRING)
	private TipoDescontoEnum tipo_desconto;

	@ManyToOne
	@Column(name = "pedido_id")
	private PedidoEntity pedido;

	@ManyToOne
	@Column(name = "produto_id")
	private ProdutoEntity produto;

	public ItemDePedidoEntity() {
	}

	public ItemDePedidoEntity(int quantidade, PedidoEntity pedido, ProdutoEntity produto) {
		this.quantidade = quantidade;
		this.pedido = pedido;
		this.produto = produto;
		this.preco_unitario = produto.getPreco_unitario();
	}

	public PedidoEntity getPedido() {
		return pedido;
	}

	public void setPedido(PedidoEntity pedido) {
		this.pedido = pedido;
	}

	public ProdutoEntity getProduto() {
		return produto;
	}

	public void setProduto(ProdutoEntity produto) {
		this.produto = produto;
	}

	public double getPreco_unitario() {
		return preco_unitario;
	}

	public void setPreco_unitario(double preco_unitario) {
		this.preco_unitario = preco_unitario;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	public TipoDescontoEnum getTipo_desconto() {
		return tipo_desconto;
	}

	public void setTipo_desconto(TipoDescontoEnum tipo_desconto) {
		this.tipo_desconto = tipo_desconto;
	}

	public long getId() {
		return id;
	}
}
