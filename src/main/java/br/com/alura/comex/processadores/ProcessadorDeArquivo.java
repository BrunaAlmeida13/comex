package br.com.alura.comex.processadores;

import java.util.ArrayList;

import br.com.alura.comex.pedido.Pedido;

public class ProcessadorDeArquivo {
	private IProcessadorDeArquivoStrategy iProcessador;
	
	public ProcessadorDeArquivo() {
	}

	public void setiProcessador(IProcessadorDeArquivoStrategy iProcessador) {
		this.iProcessador = iProcessador;
	}
	
	public ArrayList<Pedido> execute() {
		return this.iProcessador.readFile();
	}
}
