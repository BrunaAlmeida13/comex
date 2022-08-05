package br.com.alura.comex.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.alura.comex.enums.TipoDescontoEnum;

@Entity
@Table(name = "Pedido")
public class PedidoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate data = LocalDate.now();
	private double desconto;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_desconto")
	private TipoDescontoEnum tipoDesconto;

	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	@Column(name = "item_pedido")
	private List<ItemDePedidoEntity> itemPedido = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private ClienteEntity cliente;

	public PedidoEntity() {
	}

	public PedidoEntity(ClienteEntity cliente) {
		this.cliente = cliente;
	}
	
	public PedidoEntity(LocalDate data, double desconto, TipoDescontoEnum tipoDesconto, ClienteEntity cliente) {
		this.data = data;
		this.desconto = desconto;
		this.tipoDesconto = tipoDesconto;
		this.cliente = cliente;
	}
	
	public PedidoEntity(LocalDate data, double desconto, TipoDescontoEnum tipoDesconto,
			List<ItemDePedidoEntity> itemPedido, ClienteEntity cliente) {

		this.data = data;
		this.desconto = desconto;
		this.tipoDesconto = tipoDesconto;
		this.itemPedido = itemPedido;
		this.cliente = cliente;
	}

	public void adicionarItem(ItemDePedidoEntity item) {
		item.setPedido(this);
		this.itemPedido.add(item);
	}
	
	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
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

	public void setTipo_desconto(TipoDescontoEnum tipoDesconto) {
		this.tipoDesconto = tipoDesconto;
	}

	public long getId() {
		return id;
	}
}
