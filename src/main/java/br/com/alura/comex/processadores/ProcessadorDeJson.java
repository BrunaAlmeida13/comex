package br.com.alura.comex.processadores;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class ProcessadorDeJson {

	public ProcessadorDeJson() {
	}

	public static <T> Object readObjectFromJsonFile(Class<T> c, String fileName) throws IOException {
		ObjectMapper om = new ObjectMapper();

		om.registerModule(new JavaTimeModule());

		List<ReceptorJson> obj = (List<ReceptorJson>) om.readValue(Paths.get(fileName).toFile(), new TypeReference<List<ReceptorJson>>(){});
		return obj;
	}
}
