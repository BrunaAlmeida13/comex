package br.com.alura.comex;

import java.io.IOException;
import java.net.URISyntaxException;

import br.com.alura.comex.processadores.ProcessadorDeJson;
import br.com.alura.comex.processadores.ReceptorJson;

public class TesteJson {

	public static void main(String[] args) throws IOException, URISyntaxException, NoSuchFieldException {

		System.out.println(
				ProcessadorDeJson.readObjectFromJsonFile(ReceptorJson.class, "src/main/resources/pedidos.json"));
	}
}
