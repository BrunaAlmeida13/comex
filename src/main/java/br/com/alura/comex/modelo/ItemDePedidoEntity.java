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
	private int quantidade;
	private double desconto;
	
	@Column(name = "preco_unitario")
	private double precoUnitario;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_desconto")
	private TipoDescontoEnum tipoDesconto;

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
		this.precoUnitario = produto.getPrecoUnitario();
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

	public double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
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

	public TipoDescontoEnum getTipoDesconto() {
		return tipoDesconto;
	}

	public void setTipoDesconto(TipoDescontoEnum tipoDesconto) {
		this.tipoDesconto = tipoDesconto;
	}

	public long getId() {
		return id;
	}
}
