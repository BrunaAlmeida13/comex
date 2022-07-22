package br.com.alura.comex.processadores;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import br.com.alura.comex.pedido.Pedido;

@SuppressWarnings("unchecked")
public class ProcessadorDeJson implements IProcessadorDeArquivoStrategy{

	public ProcessadorDeJson() {
	}

	@Override
	public ArrayList<Pedido> readFile() {
		
		ArrayList<Pedido> listaPedido = null;

		try {
			listaPedido = (ArrayList<Pedido>) this.readObjectFromJsonFile(Pedido.class,
					"src/main/resources/pedidos.json");
			
		} catch (IOException e) {
			throw new RuntimeException("Erro: " + e);
		}
		
		return listaPedido;
	}

	private <T> Object readObjectFromJsonFile(Class<T> c, String fileName) throws IOException {
		ObjectMapper om = new ObjectMapper();

		om.registerModule(new JavaTimeModule());

		ArrayList<Pedido> obj = om.readValue(Paths.get(fileName).toFile(),
				new TypeReference<ArrayList<Pedido>>() {});
		
		return obj;
	}
}
