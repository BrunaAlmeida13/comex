package br.com.alura.comex.processadores;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import br.com.alura.comex.pedido.Pedido;

public class ProcessadorDeXml implements IProcessadorDeArquivoStrategy {

	public ProcessadorDeXml() {
	}

	@SuppressWarnings({ "unused" })
	@Override
	public ArrayList<Pedido> readFile() {

		ProcessadorDeJson processador = new ProcessadorDeJson();
		XmlMapper objectMapper = new XmlMapper();
		ArrayList<Pedido> listaPedido = null;
		String readContent;

		try {

			readContent = new String(Files.readAllBytes(Paths.get("src/main/resources/pedidos.xml")));

			listaPedido = objectMapper.readValue(readContent,new TypeReference<ArrayList<Pedido>>() {}); 

		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return listaPedido;
	}
}
