package br.com.alura.comex.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private Date data;
	private double desconto;
	
	@Enumerated(EnumType.STRING)
	private TipoDescontoEnum tipo_desconto;
	
	@OneToMany
	private ItemDePedidoEntity item_pedido;
	
	@ManyToOne
	@Column(name = "id_cliente")
	private ClienteEntity cliente;
	
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
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
