package br.com.alura.comex.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.alura.comex.enums.TipoDescontoEnum;

@Entity
@Table(name = "Pedido")
public class PedidoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private Date data;
	private double desconto;
	private Enum<TipoDescontoEnum> tipo_desconto;
	// TODO adicionar uma lista item_pedido
	// TODO criar FK id_cliente
	
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

	public Enum<TipoDescontoEnum> getTipo_desconto() {
		return tipo_desconto;
	}

	public void setTipo_desconto(Enum<TipoDescontoEnum> tipo_desconto) {
		this.tipo_desconto = tipo_desconto;
	}

	public long getId() {
		return id;
	}
}
