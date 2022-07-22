package br.com.alura.comex.processadores;

import java.util.ArrayList;

import br.com.alura.comex.pedido.Pedido;

public interface IProcessadorDeArquivoStrategy {
	
	ArrayList<Pedido> readFile();
}
